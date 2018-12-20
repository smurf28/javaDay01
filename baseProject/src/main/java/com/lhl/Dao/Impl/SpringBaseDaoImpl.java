package com.lhl.Dao.Impl;

import com.lhl.Dao.SpringBaseDao;
import com.lhl.utils.ReflectionUtils;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class SpringBaseDaoImpl<T> extends JdbcDaoSupport implements SpringBaseDao<T>{

    private Class<T> clazz;

    public SpringBaseDaoImpl() {
        clazz = ReflectionUtils.getSuperGenericType(getClass());
    }

    public long insert(String sql, Object... args) {
        long id = 0;
        try {
            this.getJdbcTemplate().update(sql, args);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return id;
    }

    public void update(String sql, Object... args) {
        try {
            this.getJdbcTemplate().update(sql, args);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



}
