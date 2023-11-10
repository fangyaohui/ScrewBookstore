package com.fang.screwbookstore.dto;

import com.fang.screwbookstore.entity.Book;
import com.fang.screwbookstore.entity.TbBookexpand;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;

/**
 * 类说明
 *
 * @author fangyaohui
 * @date 2023/11/10
 */

@Data
@Slf4j
public class BookDto extends Book implements Serializable {
    private TbBookexpand tbBookexpand;
}
