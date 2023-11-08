package com.fang.screwbookstore.controller;

import com.fang.screwbookstore.common.Result;
import com.fang.screwbookstore.entity.User;
import com.fang.screwbookstore.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

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

    @Resource
    private UserService userService;


    /**
     * 该函数要求：
     *      1、对前端传来的用户名进行查询，不允许数据库中已经存在的用户名
     *      2、对密码进行加密处理，将加密后的密码存入数据库中
     * @param userData
     * @return
     */
    @RequestMapping("/register")
    public Result Register(@RequestBody User userData){
//        实现注册功能
        return userService.register(userData);
    }

    /**
     * 该函数要求：
     *      1、对前端传来的用户名以及密码进行查询，
     *      2、判断密码是否正确，该用户账号状态是否正常
     * @return
     */
    @RequestMapping("/login")
    public Result login(@RequestBody User userData, HttpSession session){
        log.info(userData.toString());
//      实现登录功能
        return userService.login(userData,session);

    }

}
