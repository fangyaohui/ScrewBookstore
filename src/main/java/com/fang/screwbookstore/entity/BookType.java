package com.fang.screwbookstore.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;

/**
 * 类说明
 *
 * @author fangyaohui
 * @date 2023/11/14
 */
@Data
@Slf4j
@TableName("tb_booktype")
public class BookType implements Serializable {

    private int id;

    private String name;

    private int num;
}
