package com.lhl.Dao;

import java.util.List;

public interface SpringBaseDao <T>{
    /**
     * ִ�� INSERT ����, ���ز����ļ�¼�� ID
     * @param sql: ��ִ�е� SQL ���
     * @param args: ���ռλ���Ŀɱ����
     * @return: �����¼�¼�� id
     */
    long insert(String sql, Object ... args);

    /**
     * ִ�� UPDATE ����, ���� INSERT(��û�з���ֵ), UPDATE, DELETE
     * @param sql: ��ִ�е� SQL ���
     * @param args: ���ռλ���Ŀɱ����
     */
    void update(String sql, Object ... args);

}
