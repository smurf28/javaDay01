
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

    //查询
    @Test
    public void testMybatis() throws Exception{
        String resoure = "sqlMapConfig.xml";
        InputStream in= Resources.getResourceAsStream(resoure);
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder=new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory= sqlSessionFactoryBuilder.build(in);
        SqlSession sqlSession= sqlSessionFactory.openSession();
        //执行语句
        My_user user = sqlSession.selectOne("com.lhl.mapper.My_UserMapper.findUserById", 1);
        System.out.println(user);
    }

    //插入
    @Test
    public void testInsertUser() throws Exception{
        String resoure = "sqlMapConfig.xml";
        InputStream in= Resources.getResourceAsStream(resoure);
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder=new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory= sqlSessionFactoryBuilder.build(in);
        SqlSession sqlSession= sqlSessionFactory.openSession();
        //执行语句
        My_user user =new My_user();
        user.setUsername("lhl2");
        user.setBirthday(new Date());
        user.setSex("女");
        int i= sqlSession.insert("com.lhl.mapper.My_UserMapper.insertUser", user);
        sqlSession.commit();

        //返回保存的id
        System.out.println(user.getId());
    }

    //更新
    @Test
    public void testUpdateUserbyId() throws Exception{
        String resoure = "sqlMapConfig.xml";
        InputStream in= Resources.getResourceAsStream(resoure);
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder=new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory= sqlSessionFactoryBuilder.build(in);
        SqlSession sqlSession= sqlSessionFactory.openSession();
        //执行语句
        My_user user =new My_user();
        user.setId(27);
        user.setUsername("lhl3");
        user.setBirthday(new Date());
        user.setSex("男");
        int i= sqlSession.update("com.lhl.mapper.My_UserMapper.updateUserById", user);
        sqlSession.commit();
        System.out.println(i);
    }

    //删除
    @Test
    public void testDelete() throws Exception{
        String resoure = "sqlMapConfig.xml";
        InputStream in= Resources.getResourceAsStream(resoure);
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder=new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory= sqlSessionFactoryBuilder.build(in);
        SqlSession sqlSession= sqlSessionFactory.openSession();
        //执行语句
        sqlSession.delete("com.lhl.mapper.My_UserMapper.deleteUserById", 27);
        sqlSession.commit();
    }
}
