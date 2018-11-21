package com.lhl.Dao;

import com.lhl.model.User;

import java.util.List;

/**
 * @author lhl28
 * @Title: javaDay01
 * @date 2018/10/25 20:02
 */
public interface UserDao  {
    //增
    void save(User u);
    //删
    void delete(Integer id);
    //改
    void update(User u);
    //查
    User getById(Integer id);
    public User getUser(String username,String password);
    //查
    int getTotalCount();
    //查
    List<User> getAll();
}
