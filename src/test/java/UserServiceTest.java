package com.lhl.service; 

import com.lhl.Dao.Impl.UserDaoImpl;
import com.lhl.Dao.UserDao;
import com.lhl.model.User;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/** 
* UserService Tester. 
* 
* @author <Authors name> 
* @since <pre>10/25/2018</pre> 
* @version 1.0 
*/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class UserServiceTest {
    @Resource(name="userDao")
   private UserDao userDao;
@Before
public void before() throws Exception { 
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: getUser(String username) 
* 
*/ 
@Test
public void testGetUser() throws Exception { 
//TODO: Test goes here...

//    String name="admin";
//    String password="admin";
//    UserService userService=new UserService();
    userDao.getAll();
//    User user= userService.Login(name,password);
//    System.out.println(user.getName()+" "+user.getPassword());
//    if(user != null){
//        System.out.println("µÇÂ¼³É¹¦£¡");
//    }else{
//        System.out.println("µÇÂ¼Ê§°Ü£¡");
//    }
} 


} 
