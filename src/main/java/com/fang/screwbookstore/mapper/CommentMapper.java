package com.fang.screwbookstore.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fang.screwbookstore.entity.Comment;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CommentMapper extends BaseMapper<Comment> {
}
