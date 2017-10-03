package com.metacube.shoppingcart.service;

import com.metacube.shoppingcart.modal.Product;
import com.metacube.shoppingcart.status.Status;

public interface ProductService {
	Iterable<Product> getAllProducts();
	Product getProductById(int id);
	Status addProduct(Product entity);
	Status deleteProduct(int id);
	Status editProduct(Product entity, int id);
}
