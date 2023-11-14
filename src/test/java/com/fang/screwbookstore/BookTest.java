package com.fang.screwbookstore;

import com.fang.screwbookstore.dto.BookDto;
import com.fang.screwbookstore.entity.BookType;
import com.fang.screwbookstore.entity.Comment;
import com.fang.screwbookstore.service.BookTypeService;
import com.fang.screwbookstore.service.CommentService;
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

    @Autowired
    private CommentService commentService;

    @Autowired
    private BookTypeService bookTypeService;

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

    @Test
    public void queryBookByIdTest(){
        int id = 1;
        Result data = bookService.queryBookById(id);
        BookDto bookdto = (BookDto) data.getData();
        System.out.println(bookdto.toString());
    }

    @Test
    public void queryBookCommentByBookIdTest(){
        Comment comment = new Comment();
        comment.setBookId(1540);
        Result result = commentService.getcomment(1540,1);
        System.out.println(result.getData().toString());
    }

    @Test
    public void queryBookTypeListTest(){
        List<BookType> booklist = bookTypeService.query().list();
        System.out.println(booklist.toString());
    }

}
