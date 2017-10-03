package com.metacube.get.shoppingcart.model;

/**
 * ClassName  : Product
 * @author    : Vaishali Jain
 * Description: POJO class of Product
 */
public class Product
{	
	//describe product id
	private int id;
	//describe product name
	private String name;
	//describe product price
	private double price;
	//describe image url of the product image
	private String imageUrl;

	public int getId()
	{
		return id;
	}
	public void setId(final int id)
	{
		this.id = id;
	}

	public String getName()
	{
		return name;
	}
	public void setName(final String name)
	{
		this.name = name;
	}
	
	public double getPrice() {
		return price;
	}
	public void setPrice(double d) {
		this.price = d;
	}



	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
}
