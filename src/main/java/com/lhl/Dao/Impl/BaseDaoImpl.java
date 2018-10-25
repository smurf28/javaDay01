package com.lhl.Dao.Impl;

import com.lhl.Dao.BaseDao;
import com.lhl.jdbc.JDBCUtils_V3;
import com.lhl.utils.ReflectionUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;


/**
 * @author lhl28
 * @Title: javaDay01
 * @date 2018/10/25 19:34
 */
public class BaseDaoImpl<T> implements BaseDao<T> {
    private QueryRunner queryRunner = new QueryRunner();

    private Class<T> clazz;

    public BaseDaoImpl() {
        clazz = ReflectionUtils.getSuperGenericType(getClass());
    }

    public long insert(String sql, Object... args) {

        long id = 0;

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = JDBCUtils_V3.getConnection();
            preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            if(args != null){
                for(int i = 0; i < args.length; i++){
                    preparedStatement.setObject(i + 1, args[i]);
                }
            }

            preparedStatement.executeUpdate();

            //获取生成的主键值
            resultSet = preparedStatement.getGeneratedKeys();
            if(resultSet.next()){
                id = resultSet.getLong(1);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally{
            JDBCUtils_V3.release(connection, preparedStatement,resultSet);
        }

        return id;
    }

    public void update(String sql, Object... args) {
        Connection connection = null;

        try {
            connection = JDBCUtils_V3.getConnection();
            queryRunner.update(connection, sql, args);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public T query(String sql, Object... args) {

        Connection connection = null;

        try {
            connection = JDBCUtils_V3.getConnection();
            return queryRunner.query(connection, sql, new BeanHandler<T>(clazz), args);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public List<T> queryForList(String sql, Object... args) {
        Connection connection = null;

        try {
            connection = JDBCUtils_V3.getConnection();
            return queryRunner.query(connection, sql, new BeanListHandler<T>(clazz), args);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public <V> V getSingleVal(String sql, Object... args) {
        Connection connection = null;

        try {
            connection = JDBCUtils_V3.getConnection();
            return (V)queryRunner.query(connection, sql, new ScalarHandler(), args);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public void batch(String sql, Object[]... params) {
        Connection connection = null;

        try {
            connection = JDBCUtils_V3.getConnection();
            queryRunner.batch(connection, sql, params);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
