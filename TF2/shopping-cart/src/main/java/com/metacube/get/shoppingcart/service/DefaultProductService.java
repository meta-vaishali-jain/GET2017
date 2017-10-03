package com.metacube.get.shoppingcart.service;

import com.metacube.get.shoppingcart.Status;
import com.metacube.get.shoppingcart.dao.product.ProductDao;
import com.metacube.get.shoppingcart.model.Product;


public class DefaultProductService implements ProductService
{
	ProductDao productDao;

	public DefaultProductService(ProductDao productDao) {
		this.productDao = productDao;
	}

	@Override public Iterable<Product> getAllProducts()
	{
		return productDao.findAll();
	}

	@Override public Product getProductById(final int id)
	{
		return productDao.findOne(id);
	}

	
}
