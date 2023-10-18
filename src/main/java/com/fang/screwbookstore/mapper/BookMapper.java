package com.fang.screwbookstore.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fang.screwbookstore.entity.Book;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BookMapper extends BaseMapper<Book> {
}
