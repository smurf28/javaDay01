
import java.io.InputStream;

import com.lhl.model.My_user;
import com.lhl.model.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import org.apache.ibatis.io.Resources;

/**
 * Created by artsing on 2018/11/25.
 */
public class MybatisTest {
    @Test
    public void testMybatis() throws Exception{
        String resoure = "sqlMapConfig.xml";
        InputStream in= Resources.getResourceAsStream(resoure);
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder=new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory= sqlSessionFactoryBuilder.build(in);
        SqlSession sqlSession= sqlSessionFactory.openSession();
        //Ö´ÐÐÓï¾ä
        My_user user = sqlSession.selectOne("mapper.UserMapper.findUserById", 10);
        System.out.println(user);

    }

}
