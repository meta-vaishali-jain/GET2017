package com.metacube.shoppingcart.dto;

/**
 * ClassName  : ProductDto
 * @author    : Vaishali Jain
 * Description: DataTransferObject POJO class
 */
public class ProductDto {
	//describe product id
	private int id;
	//describe product name
	private String name;
	//describe product price
	private double price;
	//describe image url of the product
	private String imageUrl;
	
	public int getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public double getPrice() {
		return price;
	}
	
	public void setId(final int id) {
		this.id = id;
	}
	
	public void setName(final String name) {
		this.name = name;
	}
	
	public void setPrice(final double price) {
		this.price = price;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	
}
