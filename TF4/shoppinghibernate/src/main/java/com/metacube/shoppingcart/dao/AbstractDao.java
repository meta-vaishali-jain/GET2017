package com.metacube.shoppingcart.dao;

import java.io.Serializable;

import com.metacube.shoppingcart.enums.Status;

/**
 * Interface  : AbstractDao
 * @author    : Vaishali Jain
 * Description: Declares method to be performed on the databse.
 * @param <T>
 * @param <ID>
 */
public interface AbstractDao<T, ID extends Serializable> {
	<S extends T> Status save(S entity);
	T findOne(ID primaryKey);
	Iterable<T> findAll();
	Status delete(ID primaryKey);
	<S extends T>Status edit(S entity,ID primaryKey);
}
