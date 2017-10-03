package com.metacube.shoppingcart.modal;
/**
 * ClassName  : Product
 * @author    : Vaishali Jain
 * Description : POJO class of product
 */
public class Product {
	//describing product id
    private int Id;
    //describing product name
    private String name;
    //describing product price
    private double price;
    //describing product image url
    private String imageUrl;

    //default constructor
    public Product() {

    }

    public int getId() {
        return Id;
    }
    
    public void setId(final int Id) {
        this.Id = Id;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
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
