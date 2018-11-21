package com.lhl.model;

import com.sun.xml.internal.ws.api.ha.StickyFeature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * Created by artsing on 2018/11/7.
 */
@Component("BeanTest")
public class BeanTest {
    private String name;
    @Resource(name = "")
    private User user;
    public BeanTest(String name, User user) {
        this.name = name;
        this.user = user;
    }

    public BeanTest() {
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }


    public void printHello() {
        System.out.println("Spring 3 : Hello ! " + name);
    }

    @Override
    public String toString() {
        return "BeanTest{" +
                "name='" + name + '\'' +
                ", user=" + user +
                '}';
    }
}
