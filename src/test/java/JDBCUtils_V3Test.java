package com.lhl.jdbc; 

import org.junit.Test; 
import org.junit.Before; 
import org.junit.After;

import java.sql.Connection;

import static com.lhl.jdbc.JDBCUtils_V3.getConnection;
import static javafx.scene.input.KeyCode.J;

/** 
* JDBCUtils_V3 Tester. 
* 
* @author <Authors name> 
* @since <pre>10/25/2018</pre> 
* @version 1.0 
*/ 
public class JDBCUtils_V3Test { 

@Before
public void before() throws Exception { 
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: getConnection() 
* 
*/ 
@Test
public void testGetConnection() throws Exception {
    System.out.println("path2 = " + this.getClass().getResource("/"));
    Connection connection= JDBCUtils_V3.getConnection();
    System.out.println(connection);

} 

/** 
* 
* Method: release(Connection conn, PreparedStatement pstmt, ResultSet rs) 
* 
*/ 
@Test
public void testRelease() throws Exception { 
//TODO: Test goes here... 
} 


} 
