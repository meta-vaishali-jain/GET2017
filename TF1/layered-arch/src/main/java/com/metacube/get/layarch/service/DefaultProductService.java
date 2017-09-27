package com.metacube.get.layarch.service;

import com.metacube.get.layarch.dao.user.ProductDao;
import com.metacube.get.layarch.model.Product;
/**
ClassName  : DefaultProductService
@author    : Vaishali Jain
Description: Class implementing ProductService interface describing all methods
*/
public class DefaultProductService implements ProductService
{
	ProductDao productDao;
	
	//Default constructor
	public DefaultProductService(ProductDao productDao) {
		this.productDao = productDao;
	}

	
	@Override public Product getProductById(int id)
	{
		return productDao.findOne(id);
	}
	
	/**
	Overriden method
	Method to get all products.
	*/
	@Override
	public Iterable<Product> getAllProducts() {
		// TODO Auto-generated method stub
		return productDao.findAll();
	}
}
