package com.fang.screwbookstore.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fang.screwbookstore.entity.Book;
import com.fang.screwbookstore.mapper.BookMapper;
import com.fang.screwbookstore.service.BookService;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl extends ServiceImpl<BookMapper, Book> implements BookService {
}
