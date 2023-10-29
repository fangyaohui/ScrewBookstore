package com.fang.screwbookstore.controller;

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

@RequestMapping("/front/")
public class LoginController {


    @RequestMapping("/login")
    public void login(){

        return ;
    }

}
