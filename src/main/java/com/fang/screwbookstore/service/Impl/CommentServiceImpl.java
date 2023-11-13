package com.fang.screwbookstore.service.Impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.conditions.query.QueryChainWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fang.screwbookstore.common.Result;
import com.fang.screwbookstore.dto.CommentDto;
import com.fang.screwbookstore.entity.Comment;
import com.fang.screwbookstore.entity.User;
import com.fang.screwbookstore.mapper.CommentMapper;
import com.fang.screwbookstore.service.CommentService;
import com.fang.screwbookstore.service.UserService;
import com.fang.screwbookstore.utils.SystemConstants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * 类说明
 *
 * @author fangyaohui
 * @date 2023/11/12
 */

@Service
@Slf4j
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment> implements CommentService {

    @Autowired
    private UserService userService;

    @Override
    public Result addcomment(String commentstr, int bookid, HttpSession session) {
        Comment comment = new Comment();
        comment.setComment(commentstr);
        comment.setBookId(bookid);
        User user = (User) session.getAttribute("user");
        comment.setUserId(user.getId());
        save(comment);
        return Result.ok();
//        return null;
    }

    /**
     * 该函数：
     *      1、获取当前页面的十条评论
     * @param bookid
     * @param pagenum
     * @return
     */
    @Override
    public Result getcomment(int bookid,int pagenum) {
//        int bookid = comment.getBookId();

        Page<Comment> page = query().eq("book_id",bookid).orderByAsc("registerdate")
                .page(new Page<>(pagenum, SystemConstants.MAX_PAGE_SIZE));

        List<Comment> commentList = page.getRecords();
        List<CommentDto> commentDtos = new ArrayList<>();

        for (Comment comment :commentList) {
            CommentDto commentDto = new CommentDto();
            int userid = comment.getUserId();
            User user = userService.query().eq("id",userid).one();
            BeanUtils.copyProperties(comment,commentDto);
            commentDto.setUser(user);
            commentDtos.add(commentDto);
        }

//        commentList = query().eq("book_id",bookid).list();

        log.info(commentDtos.toString());

        return Result.ok(commentDtos);

//        return null;
    }
}
