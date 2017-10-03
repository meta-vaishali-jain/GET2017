package com.metacube.get.shoppingcart.dao;

import java.io.Serializable;
import com.metacube.get.shoppingcart.Status;

/**
 * ClassName  :AbstractDao
 * @author    :  Vaishali Jain
 * Description: Interface containing declaration of function to be implemented by Dao class.
 */

public interface AbstractDao<T, ID extends Serializable>
{
	
	T findOne(ID primaryKey);
	Iterable<T> findAll();
	
}
