package com.lhl.Test;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 * @author lhl28
 * @Title: javaDay01
 * @date 2018/10/24 21:29
 */
public class TestjdbcC3P0Test {
    @org.junit.Test
    public void testAddUser() throws Exception {
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        ComboPooledDataSource dataSource=new ComboPooledDataSource();
//        try {
//            connection=dataSource.getConnection();
//          //  String sql = "insert into "
//        }
    }

}