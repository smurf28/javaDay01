package com.lhl.Dao.Impl;

import com.lhl.Dao.UserDao;
import com.lhl.model.User;

/**
 * @author lhl28
 * @Title: javaDay01
 * @date 2018/10/25 20:04
 */
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao {
    public User getUser(String username,String password) {
        String sql = "SELECT * " + "FROM tbl_user WHERE name = ? AND password = ?";
        return query(sql,username,password);
    }
}
