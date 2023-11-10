package com.fang.screwbookstore.controller;

import com.fang.screwbookstore.common.Result;
import com.fang.screwbookstore.entity.Book;
import com.fang.screwbookstore.service.BookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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

}
