package com.metacube.get.shoppingcart.dao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.metacube.get.shoppingcart.Status;
import com.metacube.get.shoppingcart.model.Product;

/**
 * ClassName  :GenericJdbcDao
 * @author    :  Vaishali Jain
 * Description: Abstract class having definition for some of the methods declared by AbstractDao interface.
 */

public abstract class GenericJdbcDao<T, ID extends Serializable> implements AbstractDao<T,ID>
{
	JdbcConnectionFactory connectionFactory = new JdbcConnectionFactory();
	
	
	protected abstract String getTableName();
	protected abstract T extractResultSetRow(ResultSet resultSet);
	protected abstract String getPrimaryKeyColoumnName();
	protected abstract String setData(T entity);
	protected abstract String getColumns();
	
	
	/**
	 * Method to find product on the basis of the product id.
	 */
	public T findOne(final ID primaryKey)
	{
		try {
			Connection connection = connectionFactory.getConnection();
			Statement stmt = connection.createStatement();
			ResultSet resultSet = stmt.executeQuery("SELECT * FROM " + getTableName() + " where " + getPrimaryKeyColoumnName() +" = '" + primaryKey + "'");
			while(resultSet.next()) {
				return extractResultSetRow(resultSet);
			}
			return null;
		} catch (Exception e) {
			//TODO - Logging
			return null;
		}
	}
	
	/**
	 * method to find all the products .
	 */
	public Iterable<T> findAll ()
	{
		try {
			Connection connection = connectionFactory.getConnection();
			Statement stmt = connection.createStatement();
			ResultSet resultSet = stmt.executeQuery("SELECT * FROM " + getTableName());
			List<T> productList = new ArrayList<>();
			while(resultSet.next()) {
				productList.add(extractResultSetRow(resultSet));
			}
			return productList;

		} catch (Exception e) {
			//TODO - Logging
			return Collections.emptyList();
		}

	}

	
}
