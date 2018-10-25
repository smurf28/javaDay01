package com.lhl.Controller;

import com.lhl.model.User;
import com.lhl.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author lhl28
 * @Title: javaDay01
 * @date 2018/10/25 20:22
 */
@WebServlet(urlPatterns = "/login" ,name = "login")
public class UserController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //½â¾öÂÒÂë
        req.setCharacterEncoding("UTF-8");
        String name=req.getParameter("name");
        String password=req.getParameter("password");
        UserService userService=new UserService();
        User user= userService.getUser(name);

        if(user != null&&user.getPassword().equals(password)){
            System.out.println("µÇÂ¼³É¹¦£¡");
            System.out.println(user.getName()+" "+user.getPassword());
            req.getRequestDispatcher("/starter.jsp").forward(req, resp);
        }else{
            System.out.println("µÇÂ¼Ê§°Ü£¡");

        }
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
