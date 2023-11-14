package com.fang.screwbookstore.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fang.screwbookstore.entity.BookType;
import com.fang.screwbookstore.mapper.BookTypeMapper;
import com.fang.screwbookstore.service.BookTypeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * 类说明
 *
 * @author fangyaohui
 * @date 2023/11/14
 */
@Service
@Slf4j

public class BookTypeServiceImpl extends ServiceImpl<BookTypeMapper, BookType> implements BookTypeService {
}
