package com.metacube.shoppingcart.modal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * ClassName  : Order
 * @author    : Vaishali Jain
 * Description: POJO class for Order
 * 				provide mapping with the database
 */
@Entity
@Table(name="orderProduct")
public class Order {
	
	@Id
	@Column(name = "orderSequence")
	@GeneratedValue(strategy= GenerationType.AUTO)
	private int orderSequence;
	
	@Column(name="orderId")
	private int orderId;
	
	@Column(name="productId")
	private int productId;
	
	@Column(name="discount")
	private double discount;
	
	

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}



	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getOrderSequence() {
		return orderSequence;
	}

	public void setOrderSequence(int orderSequence) {
		this.orderSequence = orderSequence;
	}
	
	
	
}
