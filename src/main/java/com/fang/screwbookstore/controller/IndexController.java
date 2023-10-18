package com.fang.screwbookstore.controller;

import com.fang.screwbookstore.common.R;
import com.fang.screwbookstore.entity.Book;
import com.fang.screwbookstore.service.BookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@Slf4j

@RequestMapping("/front/index")
public class IndexController {

    @Autowired
    private BookService bookService;

    @RequestMapping("/getimage8")
    @ResponseBody
    public R<List<Book>> index(){
//        Map<String,String> ha = new HashMap<>();
        ArrayList<Book> res = new ArrayList<>();



    }


}
