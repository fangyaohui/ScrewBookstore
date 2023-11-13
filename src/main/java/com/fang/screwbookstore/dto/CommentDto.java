package com.fang.screwbookstore.dto;

import com.fang.screwbookstore.entity.Comment;
import com.fang.screwbookstore.entity.User;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;

/**
 * 类说明
 *
 * @author fangyaohui
 * @date 2023/11/13
 */

@Data
@Slf4j
public class CommentDto extends Comment implements Serializable {

    public User user;

}
