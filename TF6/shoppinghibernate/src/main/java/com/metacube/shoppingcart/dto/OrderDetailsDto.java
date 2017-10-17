package com.metacube.shoppingcart.dto;
/**
 * ClassName  : OrderDetailsDto
 * @author   : Vaishali Jain
 * Description : DTO  class to store Order Details.
 *
 */
public class OrderDetailsDto {
	
	private int productId;
	private String productName;
	private double productPrice;
	private double productDiscount;
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public double getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}
	public double getProductDiscount() {
		return productDiscount;
	}
	public void setProductDiscount(double productDiscount) {
		this.productDiscount = productDiscount;
	}
	public OrderDetailsDto(int productId, String productName,
			double productPrice, double productDiscount) {
		
		this.productId = productId;
		this.productName = productName;
		this.productPrice = productPrice;
		this.productDiscount = productDiscount;
	}
	public OrderDetailsDto() {
		
	}
}
