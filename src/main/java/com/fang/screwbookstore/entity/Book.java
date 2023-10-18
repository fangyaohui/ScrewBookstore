package com.fang.screwbookstore.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;

@Data
@Slf4j
@TableName("tb_book")
public class Book implements Serializable {

    private int id;

    private String bookname;

    private String author;

    private int booktype;

    private String imgpath;

    private String bookabstract;

    private int state;

}
