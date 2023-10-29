package com.fang.screwbookstore.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.fang.screwbookstore.common.R;
import com.fang.screwbookstore.entity.Book;

import java.util.List;

public interface BookService extends IService<Book> {
    R queryBookByX(String s);
}
