package com.lhl.Dao;

import java.util.List;

/**
 * @author lhl28
 * @Title: javaDay01
 * @date 2018/10/25 19:33
 */
public interface BaseDao<T> {
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

    /**
     * ִ�е�����¼�Ĳ�ѯ����, �������¼��Ӧ�����һ������
     * @param sql: ��ִ�е� SQL ���
     * @param args: ���ռλ���Ŀɱ����
     * @return: ���¼��Ӧ�����һ������
     */
    T query(String sql, Object ... args);

    /**
     * ִ�ж�����¼�Ĳ�ѯ����, �������¼��Ӧ�����һ�� List
     * @param sql: ��ִ�е� SQL ���
     * @param args: ���ռλ���Ŀɱ����
     * @return: ���¼��Ӧ�����һ�� List
     */
    List<T> queryForList(String sql, Object ... args);

    /**
     * ִ��һ�����Ի�ֵ�Ĳ�ѯ����, �����ѯĳһ����¼��һ���ֶ�, ���ѯĳ��ͳ����Ϣ, ����Ҫ��ѯ��ֵ
     * @param sql: ��ִ�е� SQL ���
     * @param args: ���ռλ���Ŀɱ����
     * @return: ִ��һ�����Ի�ֵ�Ĳ�ѯ����, �����ѯĳһ����¼��һ���ֶ�, ���ѯĳ��ͳ����Ϣ, ����Ҫ��ѯ��ֵ
     */
    <V> V getSingleVal(String sql, Object ... args);

    /**
     * ִ���������²���
     * @param sql: ��ִ�е� SQL ���
     * @param params: ���ռλ���Ŀɱ����
     */
    void batch(String sql, Object[]... params);
}
