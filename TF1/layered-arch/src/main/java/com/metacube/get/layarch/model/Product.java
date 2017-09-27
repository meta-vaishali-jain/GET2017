package com.metacube.get.layarch.model;

/**
ClassName  : Product
@author    : Vaishali Jain
Description: POJO class for product
*/
public class Product
{
	private int id;
	private String name;
	private int price;
	private String img_url;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getImg() {
		return img_url;
	}
	public void setImg(String img) {
		this.img_url = img;
	}

}
