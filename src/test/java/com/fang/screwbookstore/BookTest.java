package com.fang.screwbookstore;

import com.fang.screwbookstore.utils.BookUtils;
import com.fang.screwbookstore.common.Result;
import com.fang.screwbookstore.entity.Book;
import com.fang.screwbookstore.service.BookService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@SpringBootTest
public class BookTest {

    @Autowired
    private BookService bookService;

    @Test
    public void BookUtilsTest(){
        List<Book> res = new ArrayList<>();
        Set<Integer> randomNumbers = BookUtils.generateRandomNumbers(8);
        System.out.println(randomNumbers.toString());
        for(Integer index : randomNumbers){
            Book book = bookService.getById(index);
            res.add(book);
        }
        res = BookUtils.BookImagePath(res,"..");
        System.out.println(res.toString());
    }

    @Test
    public void queryBookByXTest(){
        Result bookList =  bookService.queryBookByX("buynum");
        System.out.println(bookList.toString());
    }

}
