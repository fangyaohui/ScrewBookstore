package com.fang.screwbookstore.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fang.screwbookstore.Utils.BookUtils;
import com.fang.screwbookstore.common.R;
import com.fang.screwbookstore.entity.Book;
import com.fang.screwbookstore.service.BookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
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
    public R<List<Book>> index(){
        List<Book> res = new ArrayList<>();
        Set<Integer> randomNumbers = BookUtils.generateRandomNumbers(10);

        for(Integer index : randomNumbers){
            Book book = bookService.getById(index);
            res.add(book);
        }
        res = BookUtils.BookImagePath(res,"..");
        return R.success(res);
    }


}
