package com.fang.screwbookstore.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.fang.screwbookstore.common.Result;
import com.fang.screwbookstore.entity.Book;

public interface BookService extends IService<Book> {
    Result queryBookByX(String s);
}
