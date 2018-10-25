package com.lhl.service;

import com.lhl.Dao.Impl.UserDaoImpl;
import com.lhl.Dao.UserDao;
import com.lhl.model.User;

/**
 * @author lhl28
 * @Title: javaDay01
 * @date 2018/10/25 20:19
 */
public class UserService {

    public UserService() {
    }

    public User getUser(String username){
        UserDao userDao=new UserDaoImpl();
        return userDao.getUser(username);
    }
}
