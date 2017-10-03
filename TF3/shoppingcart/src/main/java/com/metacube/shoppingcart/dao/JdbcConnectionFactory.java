package com.metacube.shoppingcart.dao;

import java.sql.Connection;
import java.sql.DriverManager;
/**
 * ClassName  : JdbcConnectionFactory
 * @author    : Vaishali Jain
 * Description: class to get database connection from the database
 */
public class JdbcConnectionFactory {
	Connection getConnection() throws Exception
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/shopping_cart", "cart_user", "get_pwd");
			return con;
		}
		catch (Exception e)
		{
			System.out.println(e);
			throw e;
		}
	}
}
