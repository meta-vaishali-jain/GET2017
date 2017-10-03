package com.metacube.shoppingcart.facade;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.metacube.shoppingcart.dto.ProductDto;
import com.metacube.shoppingcart.modal.Product;
import com.metacube.shoppingcart.service.ProductService;
import com.metacube.shoppingcart.status.Status;

/**
 * ClassName  : DefaultProductFacade
 * @author    : Vaishali Jain
 * Deacription: Facade class performing all business logic
 */
@Component("productFacade")
public class DefaultProductFacade implements ProductFacade {
	
	@Autowired
	ProductService productService;
	//default constructor
	public DefaultProductFacade() {
		
	}
	
	public void setProductService(final ProductService productService)
	{
		this.productService = productService;
	}

	public ProductService getProductService()
	{
		return productService;
	}
	
	//parameterize constructor
	public DefaultProductFacade(ProductService productService) {
		this.productService = productService;
	}
	
	//method to get all products
	@Override
	public Iterable<ProductDto> getAllProducts() {
		List<ProductDto> productDtoList = new ArrayList<>();

		for (Product product : productService.getAllProducts()) {
			productDtoList.add(modelToDto(product));
		}

		return productDtoList;
	}
	
	//method to get products on the basis of id
	@Override
	public ProductDto getProductById(int id) {
		// TODO Auto-generated method stub
		return modelToDto(productService.getProductById(id));
	}
	
	/**
	 * DataTransferObject to model conversion
	 * @param productDto
	 * @return
	 */
	protected Product dtoToModel(ProductDto productDto) {
		if (productDto == null) {
			return null;
		}
		Product user = new Product();
		user.setId(productDto.getId());
		user.setName(productDto.getName());
		user.setPrice(productDto.getPrice());
		user.setImageUrl(productDto.getImageUrl());
		return user;
	}
	
	/**
	 * Model to dataTransferObject conversion
	 * @param product
	 * @return
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
	
	//method to add product
	@Override
	public Status addProduct(Product entity) {
		// TODO Auto-generated method stub
		return productService.addProduct(entity);
	}
	
	//method to delete product
	public Status deleteProduct(int id) {
		return  productService.deleteProduct(id);
	}
	
	//method to edit product
	@Override
	public Status editProduct(Product entity,int id) {
		// TODO Auto-generated method stub
		return productService.editProduct(entity,id);
	}
}
