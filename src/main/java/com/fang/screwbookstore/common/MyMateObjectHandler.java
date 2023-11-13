package com.fang.screwbookstore.common;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * 类说明
 *
 * @author fangyaohui
 * @date 2023/11/8
 */
@Slf4j
@Component
public class MyMateObjectHandler implements MetaObjectHandler {
    @Override
    public void insertFill(MetaObject metaObject) {
        log.info("插入字段，字段处理成功");
        metaObject.setValue("registerdate", LocalDateTime.now());
//        metaObject.setValue("time", LocalDateTime.now());
    }

    @Override
    public void updateFill(MetaObject metaObject) {

    }
}
