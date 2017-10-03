package com.metacube.shoppingcart.dao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.metacube.shoppingcart.modal.Product;
import com.metacube.shoppingcart.status.Status;


/**
 * ClassName :GenericJdbcDao
 * @author   : Vaishali Jain
 * Description:Performing all operation on the database
 * @param <T>
 * @param <ID>
 */
public abstract class GenericJdbcDao<T, ID extends Serializable> implements AbstractDao<T,ID> {

	// The connection factory. //
	JdbcConnectionFactory connectionFactory = new JdbcConnectionFactory();

	//method to get table name
	protected abstract String getTableName();
	//method to get particular row of result set
	protected abstract T extractResultSetRow(ResultSet resultSet);
	
	protected abstract String getPrimaryKeyColoumnName();

	/**
	 * method to save particular product entity in the database
	 */
	public <S extends T> Status save(S entity) {
		Status result = Status.Success;
		Product product = (Product)entity;
		try {
			Connection connection = connectionFactory.getConnection();
			Statement stmt = connection.createStatement();
			String query = "INSERT INTO " + getTableName() + " (name,price,imageUrl)"+" VALUES ('" +product.getName() +"','"+ product.getPrice() +"','"+ product.getImageUrl()+ "');";
		    stmt.executeUpdate(query);
		} catch(Exception e) {
			e.printStackTrace();
			result = Status.Error_Occured;
		}
		return result;
	}

	/**
	 * method to find particular id product from the database
	 */
	public T findOne(ID primaryKey) {
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
	 * method to get all products from the database
	 */
	public Iterable<T> findAll() {
		try {
			Connection connection = connectionFactory.getConnection();
			Statement stmt = connection.createStatement();
			ResultSet resultSet = stmt.executeQuery("SELECT * FROM " + getTableName());
			List<T> userList = new ArrayList<>();
			while(resultSet.next()) {
				userList.add(extractResultSetRow(resultSet));
			}
			return userList;

		} catch (Exception e) {
			//TODO - Logging
			return Collections.emptyList();
		}
	}

	public Long count() {
		return null;
	}

	/**
	 * method to delete particular product with given id from database
	 */
	public Status delete(ID primaryKey) {
		Status result = Status.Success;
		try {
			Connection connection = connectionFactory.getConnection();
			Statement stmt = connection.createStatement();
			String query = "DELETE FROM " + getTableName() + " where " + getPrimaryKeyColoumnName() +" = '" + primaryKey + "'";
		    stmt.executeUpdate(query);
		} catch(Exception e) {
			e.printStackTrace();
			result = Status.Error_Occured;
		}
		return result;
	}
	
	/**
	 * method to update the product
	 * @param product
	 * @param primaryKey
	 * @return
	 */
	public Status edit(Product product,ID primaryKey) {
		Status result = Status.Success;
		try {
			Connection connection = connectionFactory.getConnection();
			Statement stmt = connection.createStatement();
			String query = "UPDATE " + getTableName() + " SET name = '"+ product.getName() +" SET imageUrl = '"+ product.getImageUrl()+  "' , price = " + product.getPrice()+" where " + getPrimaryKeyColoumnName() +" = " + primaryKey + " ;";
		    stmt.executeUpdate(query);
		} catch(Exception e) {
			e.printStackTrace();
			result = Status.Error_Occured;
		}
		return result;
	}

	public boolean exists(ID primaryKey) {
		return false;
	}

}
