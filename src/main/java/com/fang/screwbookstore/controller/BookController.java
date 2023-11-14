package com.fang.screwbookstore.controller;

import com.fang.screwbookstore.common.Result;
import com.fang.screwbookstore.entity.Book;
import com.fang.screwbookstore.entity.BookType;
import com.fang.screwbookstore.entity.Comment;
import com.fang.screwbookstore.service.BookService;
import com.fang.screwbookstore.service.BookTypeService;
import com.fang.screwbookstore.service.CommentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

/**
 * 类说明：
 *      1、该类对所有前缀为book的业务进行处理
 *
 * @author fangyaohui
 * @date 2023/11/9
 */
@RestController
@Slf4j
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService bookService;

    @Autowired
    private CommentService commentService;

    @Autowired
    private BookTypeService bookTypeService;

    /**
     * 该函数功能：
     *      1、通过前端传来的bookid查找到目标图书信息
     * @param book
     * @return
     *      2、将找到的图书信息打包返回给前端
     */
    @RequestMapping("/getbook")
    public Result getbook(@RequestBody Book book){

        log.info("查询bookid :" + book.getId());

        return bookService.queryBookById(book.getId());

    }

    /**
     * 该函数：
     *      1、为用户添加评论，保存评论
     * @param requestBody
     * @param session
     * @return
     */
    @RequestMapping("/addcomment")
    public Result addcomment(@RequestBody Map<String,String> requestBody,HttpSession session){

        log.info(requestBody.get("comment")+" "+requestBody.get("bookid"));

        return commentService.addcomment(requestBody.get("comment"),Integer.parseInt(requestBody.get("bookid")),session);
    }

    /**
     * 该函数：
     *      1、抓取这本书所有评论 并返回评论集
     *
     *
     * @param map
     * @return
     */
    @RequestMapping("/getcomment")
    public Result getcomment(@RequestBody Map<String,String> map){
//        log.info("getcomment：" + comment.getBookId());
        int page = Integer.parseInt(map.get("page"));
        int bookid = Integer.parseInt(map.get("bookid"));
        log.info(page+" " + bookid);

        return commentService.getcomment(bookid,page);

//        return Result.ok();

    }

    @RequestMapping("getbooktype")
    public Result getbooktype(){
        List<BookType> booklist = bookTypeService.query().list();
        return Result.ok(booklist);
    }

}
