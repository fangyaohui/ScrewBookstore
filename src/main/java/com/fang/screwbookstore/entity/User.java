package com.fang.screwbookstore.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * 类说明
 *
 * @author fangyaohui
 * @date 2023/11/8
 */
@Data
@Slf4j
@TableName("tb_user")
public class User {
    private int id;

    private String username;

    private String password;

    private String name;

    private String imgpath;

    private int balance;

    private int state;
}
