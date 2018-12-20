package com.lhl.Filter;

import com.lhl.model.User;
import com.lhl.service.UserService;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.net.URLDecoder;

/**
 * Created by artsing on 2018/11/2.
 */
public class LoginFilter implements Filter {
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        servletRequest.setCharacterEncoding("UTF-8");
        System.out.println("开始执行doFilter");
        // 转发到下一个组件，进行后续的处理（组件可以是一个过滤器，也可以是一个servlet）
        HttpServletRequest httpRequest = (HttpServletRequest)servletRequest;
        HttpServletResponse httpResponse = (HttpServletResponse)servletResponse;
        //校验session
        HttpSession session = httpRequest.getSession(true);
        User session_user = (User)session.getAttribute("user");

        //登录不成功直接进入登录
        if(session_user == null){
            System.out.println("======= 没有登录 ========");
            System.out.println(httpRequest.getRequestURL());
            httpResponse.sendRedirect("/");
            return;
        }else{
            filterChain.doFilter(servletRequest, servletResponse);
        }
        System.out.println("======= 结束执行doFilter ========");
    }

    public void destroy() {

    }
}
