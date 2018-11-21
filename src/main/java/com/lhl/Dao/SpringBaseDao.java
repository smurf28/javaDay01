package com.lhl.Dao;

import java.util.List;

public interface SpringBaseDao <T>{
    /**
     * 执行 INSERT 操作, 返回插入后的记录的 ID
     * @param sql: 待执行的 SQL 语句
     * @param args: 填充占位符的可变参数
     * @return: 插入新记录的 id
     */
    long insert(String sql, Object ... args);

    /**
     * 执行 UPDATE 操作, 包括 INSERT(但没有返回值), UPDATE, DELETE
     * @param sql: 待执行的 SQL 语句
     * @param args: 填充占位符的可变参数
     */
    void update(String sql, Object ... args);

}
