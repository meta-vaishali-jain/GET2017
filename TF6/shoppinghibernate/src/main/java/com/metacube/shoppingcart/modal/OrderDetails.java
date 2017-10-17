package com.metacube.shoppingcart.modal;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * ClassName  : OrderDetails
 * @author    : Vaishali Jain
 * Description: POJO class for OrderDetails
 * 				provide mapping with the database
 */
@Entity
@Table(name="orderdetail")
public class OrderDetails {
	
	@Id
	@Column(name = "orderId")
	@GeneratedValue(strategy= GenerationType.AUTO)
	private int orderId;
	@Column(name = "finalPrice")
	private int finalPrice;
	@Column(name = "orderDate")
	private String orderDate;
	
	@ManyToOne(cascade = CascadeType.ALL)	private PaymentDetails paymentId;
	
	public OrderDetails(){
		
	}
	
	
	
	public OrderDetails( int finalPrice, String orderDate,
			PaymentDetails paymentId) {
		
		this.finalPrice = finalPrice;
		this.orderDate = orderDate;
		this.paymentId = paymentId;
	}



	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public int getFinalPrice() {
		return finalPrice;
	}
	public void setFinalPrice(int finalPrice) {
		this.finalPrice = finalPrice;
	}
	public String getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}
	public PaymentDetails getPaymentId() {
		return paymentId;
	}
	public void setPaymentId(PaymentDetails paymentId) {
		this.paymentId = paymentId;
	}
	
}
