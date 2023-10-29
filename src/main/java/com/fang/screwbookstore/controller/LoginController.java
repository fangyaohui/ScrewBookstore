package com.fang.screwbookstore.controller;

import com.fang.screwbookstore.common.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 类说明
 *
 * @author fangyaohui
 * @date 2023/10/25
 */
@RestController
@Slf4j

@RequestMapping("/front")
public class LoginController {


    @RequestMapping("/login")
    public R login(){
        log.info("login running...");
        return R.success(null);
//        return ;
    }

}
