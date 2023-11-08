package com.fang.screwbookstore.filter;


import lombok.extern.slf4j.Slf4j;
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
                "user/register",
                "/data/**",

        };

//        匹配成功 直接放行
        if(check(urls,requersURI)){
            log.info("匹配成功，放行"+requersURI);
            filterChain.doFilter(request,response);
            return;
        }

        log.info("未登录，已拦截...."+requersURI);
//        response.getWriter().write(JSON.toJSONString(R.error("NOLOGIN")));
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
