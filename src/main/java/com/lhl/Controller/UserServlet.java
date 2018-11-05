package com.lhl.Controller;

import com.lhl.model.User;
import com.lhl.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author lhl28
 * @Title: javaDay01
 * @date 2018/10/25 20:22
 */
@WebServlet(urlPatterns = "/login" ,name = "login")
public class UserServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //解决乱码
        req.setCharacterEncoding("UTF-8");
        String name=req.getParameter("name");
        String password=req.getParameter("password");
        UserService userService=new UserService();
        User user= userService.Login(name,password);
//        User user=new User("admin","admin");
        // 如果不存在 session 会话，则创建一个 session 对象
        HttpSession session = req.getSession(true);
        // 获取 session 创建时间
//        Date createTime = new Date(session.getCreationTime());
        // 获取该网页的最后一次访问时间
//        Date lastAccessTime = new Date(session.getLastAccessedTime());
        session.setMaxInactiveInterval(10000);

        if(user != null){
            //设置session
            session.setAttribute("user", user);
            System.out.println("登录成功！");
            System.out.println(user.getName()+" "+user.getPassword());
            //定位到首页
            resp.sendRedirect("/blog/starter");
        }else{
            System.out.println("登录失败！");
            session.setAttribute("user", null);
            req.setAttribute("loginInfo","用户名或密码错误");
            req.getRequestDispatcher("/login.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
