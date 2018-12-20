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
        //�������
        req.setCharacterEncoding("UTF-8");
        String name=req.getParameter("name");
        String password=req.getParameter("password");
        UserService userService=new UserService();
        User user= userService.Login(name,password);

        HttpSession session = req.getSession(true);

        session.setMaxInactiveInterval(10000);

        if(user != null){
            //����session
            session.setAttribute("user", user);
            System.out.println("��¼�ɹ���");
            System.out.println(user.getName()+" "+user.getPassword());
            //��λ����ҳ
            resp.sendRedirect("/blog/starter");
        }else{
            System.out.println("��¼ʧ�ܣ�");
            session.setAttribute("user", null);
            req.setAttribute("loginInfo","�û������������");
            req.getRequestDispatcher("/login.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
