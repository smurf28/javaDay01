package com.lhl.Dao;

import com.lhl.model.User;

import java.util.List;

/**
 * @author lhl28
 * @Title: javaDay01
 * @date 2018/10/25 20:02
 */
public interface UserDao  {
    //��
    void save(User u);
    //ɾ
    void delete(Integer id);
    //��
    void update(User u);
    //��
    User getById(Integer id);
    public User getUser(String username,String password);
    //��
    int getTotalCount();
    //��
    List<User> getAll();
}
