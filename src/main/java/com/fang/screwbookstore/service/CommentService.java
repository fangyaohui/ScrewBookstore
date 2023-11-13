package com.fang.screwbookstore.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.fang.screwbookstore.common.Result;
import com.fang.screwbookstore.entity.Comment;

import javax.servlet.http.HttpSession;

public interface CommentService extends IService<Comment> {

    Result addcomment(String comment, int bookid, HttpSession session);

    Result getcomment(int bookid,int page);
}
