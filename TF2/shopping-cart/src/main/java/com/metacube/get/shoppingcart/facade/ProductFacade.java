package com.metacube.get.shoppingcart.facade;

import com.metacube.get.shoppingcart.Status;
import com.metacube.get.shoppingcart.dto.ProductDto;
import com.metacube.get.shoppingcart.model.Product;

public interface ProductFacade
{
	Iterable<ProductDto> getAllProducts();
	ProductDto getProductById(int id);
	
}
