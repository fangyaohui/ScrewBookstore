package com.fang.screwbookstore;

import com.fang.screwbookstore.entity.Book;
import com.fang.screwbookstore.service.BookService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class ScrewBookstoreApplicationTests {

    @Autowired
    private BookService bookService;

    @Test
    void contextLoads() {
//        BookUtils.BookImagePath(null);
    }

    @Test
    void connectmysql(){
        Book book = bookService.getById(1);
        System.out.println(book.toString());
    }

    @Test
    void getbooklist(){
//        LambdaQueryWrapper queryWrapper = LambdaQueryWrapper<>();
        List<Book> res = bookService.list();
        res = res.subList(0,8);
        System.out.println(res.size());
        System.out.println(res.toString());

    }

}
