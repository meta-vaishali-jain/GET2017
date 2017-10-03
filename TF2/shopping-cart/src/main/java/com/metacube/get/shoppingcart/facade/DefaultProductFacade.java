package com.metacube.get.shoppingcart.facade;

import java.util.ArrayList;
import java.util.List;

import com.metacube.get.shoppingcart.Status;
import com.metacube.get.shoppingcart.dto.ProductDto;
import com.metacube.get.shoppingcart.model.Product;
import com.metacube.get.shoppingcart.service.ProductService;

/**
 * ClassName  : DefaultProductFacade
 * @author    : Vaishali Jain
 * Description: Facade class performing all business logics.
 */
public class DefaultProductFacade implements ProductFacade
{
	ProductService productService;
	
	//default constructor
	public DefaultProductFacade() {
		// TODO Auto-generated constructor stub
	}
	
	public ProductService getProductService() {
		return productService;
	}


	public void setProductService(ProductService productService) {
		this.productService = productService;
	}

	//parameterize constructor
	public DefaultProductFacade(ProductService productService) {
		this.productService = productService;
	}

	//method to get all products from the database
	@Override public Iterable<ProductDto> getAllProducts()
	{
		List<ProductDto> productDtoList = new ArrayList<>();

		for (Product product : productService.getAllProducts()) {
			productDtoList.add(modelToDto(product));
		}

		return productDtoList;
	}
	
	//method to get product by id
	@Override public ProductDto getProductById(final int id)
	{
		return modelToDto(productService.getProductById(id));
	}
	
	/*
	 * DataTransferObject To model conversion method.
	 */
	protected Product dtoToModel(ProductDto productDto) {
		if (productDto == null) {
			return null;
		}
		Product product = new Product();
		product.setId(productDto.getId());
		product.setName(productDto.getName());
		
		product.setPrice(productDto.getPrice());
		product.setImageUrl(productDto.getImageUrl());
		return product;
	}
	
	/*
	 * Model to DataTransferObject cponversion method.
	 */
	protected ProductDto modelToDto(Product product) {
		if (product == null) {
			return null;
		}
		ProductDto productDto = new ProductDto();
		productDto.setId(product.getId());
		productDto.setName(product.getName());
	
		productDto.setPrice(product.getPrice());
		productDto.setImageUrl(product.getImageUrl());
		return productDto;
	}


	

}
