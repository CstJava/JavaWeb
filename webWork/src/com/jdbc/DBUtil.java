package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * <pre>
 * 连接数据库工具类
 * @author assassin
 * </pre>
 */
public class DBUtil {
	
	private static Connection connection = null;
	
	static{
		
		try {
			//加载数据库驱动
			Class.forName("com.mysql.jdbc.Driver");			
			String user = "root";
			String password = "";
			String url = "jdbc:mysql://localhost:3306/webwork";
			//获取数据库连接  alt + shift + L
			connection = DriverManager.getConnection(url, user, password);			
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}

	//提供外部调用获取数据库连接
	public static Connection getSQLConnection() throws Exception {
		return connection;
	}
}
