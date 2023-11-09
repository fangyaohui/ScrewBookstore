package com.fang.screwbookstore.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fang.screwbookstore.common.Result;
import com.fang.screwbookstore.entity.User;
import com.fang.screwbookstore.mapper.UserMapper;
import com.fang.screwbookstore.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import javax.servlet.http.HttpSession;
import java.util.Random;
import java.util.UUID;

import static com.fang.screwbookstore.utils.UserConstans.USER_NAME;

/**
 * 类说明:
 *      对User各类的数据操作进行实现
 *
 * @author fangyaohui
 * @date 2023/11/8
 */
@Service
@Slf4j
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {


    /**
     * 实现注册功能：username不重复,password加密存储
     * @param user
     * @return
     */
    @Override
    public Result register(User user) {

        User usertemp = query().eq("username",user.getUsername()).one();
        if(usertemp != null)    return Result.fail("该用户名已被注册");

//       获取加密后的密文
        String pwd = user.getPassword();
        String hashedPwd = DigestUtils.md5DigestAsHex(pwd.getBytes());
        user.setPassword(hashedPwd);

        log.info(hashedPwd);

        Random random = new Random();
        String name = USER_NAME + user.getUsername();
        user.setName(name);
        user.setState(1);
        user.setBalance(random.nextInt(10000));

        save(user);

        return Result.ok();
//        return null;
    }


    /**
     * 实现登录功能：
     *      1、根据username查询用户
     *      2、是否存在该用户
     *      3、该用户账号状态是否正常
     *      4、该用户输入的密码是否正确
     * @param user
     * @return
     */
    @Override
    public Result login(User user, HttpSession session) {
        User usertemp = query().eq("username",user.getUsername()).one();

        if(usertemp == null) return Result.fail("该用户未注册");

        if(usertemp.getState() == 0) return Result.fail("该用户账号已封禁，请联系管理员解禁");

        String pwd = user.getPassword();
        String hasdedpwd = DigestUtils.md5DigestAsHex(pwd.getBytes());

        if(hasdedpwd.equals(usertemp.getPassword())){
            log.info(user.getUsername() + " 登录成功");

//            String token = UUID.randomUUID().toString();

            session.setAttribute("user",usertemp);
            return Result.ok();
        }else{
            return Result.fail("密码输入错误，请重新输入");
        }
//        return null;
    }

}
