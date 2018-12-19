/**
 * Created by lhl on 2018/12/19.
 */


import java.io.InputStream;
import java.util.Date;

import com.lhl.mapper.My_UserMapper;
import com.lhl.model.My_user;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import org.apache.ibatis.io.Resources;

public class MybatisMapperTest {
    @Test
    public void testMybatis() throws Exception{
        String resoure = "sqlMapConfig.xml";
        InputStream in= Resources.getResourceAsStream(resoure);
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder=new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory= sqlSessionFactoryBuilder.build(in);
        SqlSession sqlSession= sqlSessionFactory.openSession();
        //Ö´ÐÐÓï¾ä
        My_UserMapper userMapper = sqlSession.getMapper(My_UserMapper.class);
        My_user user= userMapper.findUserById(10);
        System.out.println(user);
    }
}
