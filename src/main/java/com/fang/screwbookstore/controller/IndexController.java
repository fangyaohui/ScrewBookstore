package com.fang.screwbookstore.controller;

import com.fang.screwbookstore.Utils.BookUtils;
import com.fang.screwbookstore.common.Result;
import com.fang.screwbookstore.entity.Book;
import com.fang.screwbookstore.service.BookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

//@Controller
@Slf4j
@RestController
@RequestMapping("/front/index")
public class IndexController {

    @Autowired
    private BookService bookService;

//    查询8张图片
    @RequestMapping("/getimage8")
    public Result index(){
        List<Book> res = new ArrayList<>();
        Set<Integer> randomNumbers = BookUtils.generateRandomNumbers(10);

        for(Integer index : randomNumbers){
            Book book = bookService.getById(index);
            res.add(book);
        }
        res = BookUtils.BookImagePath(res,"..");
        return Result.ok(res);
    }

//    查询热门图书
    @RequestMapping("/gethotbook")
    public Result gethotbook(){
        return bookService.queryBookByX("buynum");
    }

//    查询特价图书
    @RequestMapping("/getcheapbook")
    public Result getcheapbook(){
        return bookService.queryBookByX("price");
    }

//    查询好评图书
    @RequestMapping("/getgoodbook")
    public Result getgoodbook(){
        return bookService.queryBookByX("grade");
    }


}
