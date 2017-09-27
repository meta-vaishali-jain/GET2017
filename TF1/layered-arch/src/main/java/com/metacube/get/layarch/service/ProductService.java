package com.metacube.get.layarch.service;

import com.metacube.get.layarch.model.Product;
/**
 ProductService Interface having method declaration of getAllProducts.
*/
public interface ProductService
{
	Iterable<Product> getAllProducts();
	Product getProductById(int id);
}
