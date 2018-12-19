
import java.io.InputStream;
import java.util.Date;

import com.lhl.model.My_user;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import org.apache.ibatis.io.Resources;

/**
 * Created by artsing on 2018/11/25.
 */
public class MybatisTest {

    //��ѯ
    @Test
    public void testMybatis() throws Exception{
        String resoure = "sqlMapConfig.xml";
        InputStream in= Resources.getResourceAsStream(resoure);
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder=new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory= sqlSessionFactoryBuilder.build(in);
        SqlSession sqlSession= sqlSessionFactory.openSession();
        //ִ�����
        My_user user = sqlSession.selectOne("mapper.UserMapper.findUserById", 10);
        System.out.println(user);
    }

    //����
    @Test
    public void testInsertUser() throws Exception{
        String resoure = "sqlMapConfig.xml";
        InputStream in= Resources.getResourceAsStream(resoure);
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder=new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory= sqlSessionFactoryBuilder.build(in);
        SqlSession sqlSession= sqlSessionFactory.openSession();
        //ִ�����
        My_user user =new My_user();
        user.setUsername("lhl");
        user.setBirthday(new Date());
        user.setSex("Ů");
        int i= sqlSession.insert("mapper.UserMapper.insertUser", user);
        sqlSession.commit();

        //���ر����id
        System.out.println(user.getId());
    }

    //����
    @Test
    public void testUpdateUserbyId() throws Exception{
        String resoure = "sqlMapConfig.xml";
        InputStream in= Resources.getResourceAsStream(resoure);
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder=new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory= sqlSessionFactoryBuilder.build(in);
        SqlSession sqlSession= sqlSessionFactory.openSession();
        //ִ�����
        My_user user =new My_user();
        user.setId(27);
        user.setUsername("lhl3");
        user.setBirthday(new Date());
        user.setSex("��");
        int i= sqlSession.update("mapper.UserMapper.updateUserById", user);
        sqlSession.commit();
        System.out.println(i);
    }

    //ɾ��
    @Test
    public void testDelete() throws Exception{
        String resoure = "sqlMapConfig.xml";
        InputStream in= Resources.getResourceAsStream(resoure);
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder=new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory= sqlSessionFactoryBuilder.build(in);
        SqlSession sqlSession= sqlSessionFactory.openSession();
        //ִ�����
        sqlSession.delete("mapper.UserMapper.deleteUserById", 27);
        sqlSession.commit();
    }
}
