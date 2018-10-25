package com.lhl.Dao;

import com.lhl.model.User;

/**
 * @author lhl28
 * @Title: javaDay01
 * @date 2018/10/25 20:02
 */
public interface UserDao  {
    /**
     * 根据用户名获取 User 对象
     * @param username
     * @return User
     */
    public abstract User getUser(String username);

}
