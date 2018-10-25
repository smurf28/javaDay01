package com.lhl.jdbc;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 * @author lhl28
 * @Title: javaDay01
 * @date 2018/10/23 9:46
 */
public class JDBCUtils_V3 {
	private static String driver;
	private static String url;
	private static String username;
	private static String password;

	/**
	 * 静态代码块加载配置文件信息
	 */
	static {
		try {



			// 1.通过当前类获取类加载器
			ClassLoader classLoader = JDBCUtils_V3.class.getClassLoader();
			// 2.通过类加载器的方法获得一个输入流
			InputStream is = classLoader.getResourceAsStream("db.properties");
			// 3.创建一个properties对象
			Properties props = new Properties();
			// 4.加载输入流
			props.load(is);
			// 5.获取相关参数的值
			System.out.println(is);
			driver = props.getProperty("driver");
			url = props.getProperty("url");
			username = props.getProperty("username");
			password = props.getProperty("password");
		} catch (FileNotFoundException e1){
			System.out.println("文件找不到！");
			e1.printStackTrace();
		}catch (IOException e) {
			System.out.println("加载文件出错！");
			e.printStackTrace();
		}

	}

	/**
	 * 获取连接方法
	 * 
	 * @return
	 */
	public static Connection getConnection() {

		Connection conn = null;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, username, password);
		} catch (Exception e) {
			System.out.println("数据库连接错误！");
			e.printStackTrace();
		}
		return conn;
	}

	/**
	 * 释放资源方法
	 * 
	 * @param conn
	 * @param pstmt
	 * @param rs
	 */
	public static void release(Connection conn, PreparedStatement pstmt, ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (pstmt != null) {
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}
}
