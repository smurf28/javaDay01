package com.lhl.mapper;

import com.lhl.model.My_user;

/**
 * Created by artsing on 2018/12/19.
 */
public interface My_UserMapper {
    //�ӿ� ������  == User.xml �� id ��
    //����ֵ����  ��  Mapper.xml�ļ��з���ֵ����Ҫһ��
    //������������� ��Mapper.xml����ε�����Ҫһ��
    //�����ռ� �󶨴˽ӿ�
    public My_user findUserById(Integer id);
}
