package com.lhl.Dao.Impl;

import com.lhl.Dao.UserDao;
import com.lhl.model.User;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * @author lhl28
 * @Title: javaDay01
 * @date 2018/10/25 20:04
 */
public class UserDaoImpl extends JdbcDaoSupport implements UserDao {
    public User getUser(String username,String password) {

       String sql = "SELECT * " + "FROM tbl_user WHERE name = ? AND password = ?";
        return super.getJdbcTemplate().queryForObject(sql,new RowMapper<User>(){

            public User mapRow(ResultSet rs, int arg) throws SQLException {
                User u = new User();
                u.setId(rs.getInt("id"));
                u.setName(rs.getString("name"));
                u.setPassword(rs.getString("password"));
                return u;
            }}, username,password);
    }

    public void save(User u) {
        String sql = "insert into tbl_user values(null,?) ";
        super.getJdbcTemplate().update(sql, u.getName());
    }

    public void delete(Integer id) {
        String sql = "delete from tbl_user where id = ? ";
        super.getJdbcTemplate().update(sql,id);
    }

    public void update(User u) {
        String sql = "update  tbl_user set name = ? where id=? ";
        super.getJdbcTemplate().update(sql, u.getName(),u.getId());
    }

    public User getById(Integer id) {
        String sql = "select * from tbl_user where id = ? ";
        return super.getJdbcTemplate().queryForObject(sql,new RowMapper<User>(){

            public User mapRow(ResultSet rs, int arg1) throws SQLException {
                User u = new User();
                u.setId(rs.getInt("id"));
                u.setName(rs.getString("name"));
                u.setPassword(rs.getString("password"));
                return u;
            }}, id);

    }

    public int getTotalCount() {
        String sql = "select count(*) from tbl_user  ";
        Integer count = super.getJdbcTemplate().queryForObject(sql, Integer.class);
        return count;
    }

    public List<User> getAll() {
        String sql = "select * from tbl_user  ";
        List<User> list = super.getJdbcTemplate().query(sql, new RowMapper<User>(){

            public User mapRow(ResultSet rs, int arg1) throws SQLException {
                User u = new User();
                u.setId(rs.getInt("id"));
                u.setName(rs.getString("name"));
                return u;
            }});
        return list;
    }

}
