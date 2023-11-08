package com.fang.screwbookstore.service;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.fang.screwbookstore.common.Result;
import com.fang.screwbookstore.entity.User;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

public interface UserService extends IService<User> {
    Result register(User user);

    Result login(User user, HttpSession session);
}
