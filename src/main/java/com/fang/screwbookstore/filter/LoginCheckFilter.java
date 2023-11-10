package com.fang.screwbookstore.filter;


import com.fang.screwbookstore.entity.User;
import com.fang.screwbookstore.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.AntPathMatcher;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 用户登录过滤器
 *
 * @author fangyaohui
 * @date 2023/10/25
 */
@Slf4j
@WebFilter(filterName = "loginCheckFilter",urlPatterns = "/*")
public class LoginCheckFilter implements Filter {

//    路径匹配工具
//    https://knife.blog.csdn.net/article/details/120678900
    public static final AntPathMatcher ANT_PATH_MATCHER = new AntPathMatcher();

    @Autowired
    UserService userService;


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
//        获取当前的URI
        String requersURI = request.getRequestURI();
        log.info("用户过滤器成功拦截请求："+requersURI);

        String[] urls = {
                "/front/**",
                "/user/login",
                "/user/register",
                "/data/**",


        };

//       开后门以便不用登录
        User user1 = userService.query().eq("id",1).one();
        request.getSession().setAttribute("user",user1);
//        session.setAttribute("user",user);



//        匹配成功 直接放行
        if(check(urls,requersURI)){
            log.info("匹配成功，放行"+requersURI);
            filterChain.doFilter(request,response);
            return;
        }
        User user = (User) request.getSession().getAttribute("user");
        if(user != null){
            log.info("用户已登录，已放行...");
            filterChain.doFilter(request,response);
            return;
        }

        log.info("未登录，已拦截...."+requersURI);

//      这里为了方便测试 为所有访问开后门 后续需要注释掉 并把respon下一行代码去掉注释
//        filterChain.doFilter(request,response);
//        return;

        response.flushBuffer();
    }

    public boolean check(String[] urls, String requestUri) {
        for (String url : urls) {
            boolean match = ANT_PATH_MATCHER.match(url, requestUri);
            if (match) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
