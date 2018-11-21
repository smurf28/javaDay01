package com.lhl.model;

import com.lhl.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

/**
 * Created by artsing on 2018/11/7.
 */
public class BeanTestTest {


    @Test
    public void printHello() throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        BeanTest obj = (BeanTest) context.getBean("BeanTest");
        UserService Usersevice = (UserService) context.getBean("Usersevice");
        Usersevice.Login("admin","admin");
        System.out.println(obj);
    }

}