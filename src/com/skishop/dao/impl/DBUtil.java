package com.skishop.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * jdbc操作
 * 
 * @author anneli
 * @date 2019年10月14日 上午8:59:51
 *
 */
public class DBUtil {
	static String url = "jdbc:mysql://127.0.0.1:3306/ski_db?useUnicode=true&characterEncoding=UTF-8";
	static String user = "root";
	static String password = "189219";

	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");// 加载Mysql驱动
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 得到jdbc的连接
	 * 
	 * @return 返回jdbc连接
	 */
	public static Connection getCon() {
		try {
			Connection con = DriverManager.getConnection(url, user, password);
			return con;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
