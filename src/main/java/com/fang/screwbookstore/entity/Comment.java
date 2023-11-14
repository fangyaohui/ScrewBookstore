package com.fang.screwbookstore.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 类说明
 *
 * @author fangyaohui
 * @date 2023/11/12
 */

@Data
@Slf4j
@TableName("tb_comment")
public class Comment implements Serializable {

    @TableId
    private int id;

    private int bookId;

    private int userId;

    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime registerdate;

    private String comment;

    private int likenum;


}