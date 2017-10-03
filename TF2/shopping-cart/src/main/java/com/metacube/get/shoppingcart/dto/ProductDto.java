package com.metacube.get.shoppingcart.dto;

/**
 * ClassName  :ProductDto
 * @author    :Vaishali Jain
 * Description:POJO class generating Data transfer object.
 */
public class ProductDto
{
	private int id;
	private String name;
	private double price;

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
	public void setPrice(double price) {
		this.price = price;
	}

	

	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
}
