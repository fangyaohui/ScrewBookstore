package com.fang.screwbookstore.controller;

import com.fang.screwbookstore.common.Result;
import com.fang.screwbookstore.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 类说明
 *
 * @author fangyaohui
 * @date 2023/11/8
 */
@RestController
@Slf4j
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/register")
    public Result Register(@RequestBody User userData){
        System.out.println(userData.getUsername());


        return Result.ok();
    }
    @RequestMapping("/login")
    public Result login(){
        log.info("login running...");
        return Result.ok();

//        return ;
    }

}
