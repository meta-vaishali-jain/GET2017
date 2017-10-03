package com.metacube.shoppingcart.dao;

import java.io.Serializable;

import com.metacube.shoppingcart.status.Status;


/**
 * Interface : AbstractDao
 * @author   : Vaishali Jain
 *
 * @param <T>
 * @param <ID>
 */
public interface AbstractDao<T, ID extends Serializable> {
	
	/**
	 * Declaration of method to save the product
	 * @param entity
	 * @return
	 */
	<S extends T> Status save(S entity);
	
	/**
	 * declaration of the method to get product on the basis of id
	 * @param primaryKey
	 * @return
	 */
	T findOne(ID primaryKey);
	
	/**
	 * declaration of method to get all product
	 * @return
	 */
	Iterable<T> findAll();
	
	
	Long count();
	
	/**
	 * method to delete product on the basis of id
	 * @param primaryKey
	 * @return
	 */
	Status delete(ID primaryKey);
	
	/**
	 * method to update the product
	 * @param entity
	 * @param primaryKey
	 * @return
	 */
	<S extends T>Status edit(S entity,ID primaryKey);
	
	/**
	 * method to check if product exist
	 * @param primaryKey
	 * @return
	 */
	boolean exists(ID primaryKey);
}
