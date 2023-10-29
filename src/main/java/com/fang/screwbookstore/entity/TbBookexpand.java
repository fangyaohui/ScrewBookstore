package com.fang.screwbookstore.entity;


import lombok.Data;

import java.io.Serializable;

/**
 * (TbBookexpand)表实体类
 *
 * @author makejava
 * @since 2023-10-24 20:34:47
 */
@Data

public class TbBookexpand implements Serializable {

    private Integer id;

    private Integer bookId;

    private Integer price;

    private Integer iscoupon;

    private Integer buynun;

    private Integer grade;

    private Integer gradenum;

}

