package com.metacube.get.shoppingcart.service;

import com.metacube.get.shoppingcart.Status;
import com.metacube.get.shoppingcart.model.Product;


public interface ProductService
{
	Iterable<Product> getAllProducts();
	Product getProductById(int id);
	
}
