package com.lhl.Controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author lhl28
 * @Title: javaDay01
 * @date 2018/10/24 16:40
 */
@WebServlet(urlPatterns = "/login" ,name = "login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //解决乱码
        req.setCharacterEncoding("UTF-8");
        String name=req.getParameter("name");
        String password=req.getParameter("password");

        System.out.println("登录成功！");
        req.getRequestDispatcher("/starter.jsp").forward(req, resp);
    }
}
