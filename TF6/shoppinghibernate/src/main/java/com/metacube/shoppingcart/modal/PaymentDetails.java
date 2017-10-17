package com.metacube.shoppingcart.modal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * ClassName  : PaymentDetails
 * @author    : Vaishali Jain
 * Description: POJO class for PaymentDetails
 * 				provide mapping with the database
 */
@Entity
@Table(name="payment_details")
public class PaymentDetails {
	@Id
	@Column(name = "paymentId")
	@GeneratedValue(strategy= GenerationType.AUTO)
	private int paymentId;
	
	@Column(name = "cardNumber")
	private String cardNumber;
	
	@Column(name = "expiryMonth")
	private int expiryMonth;
	
	@Column(name = "expiryYear")
	private int expiryYear;
	
	@Column(name="userId")
	private int userId;
	 
	public  PaymentDetails(){
		
	}
	public int getPaymentId() {
		return paymentId;
	}
	public void setPaymentId(int paymentId) {
		this.paymentId = paymentId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getCardNumber() {
		return cardNumber;
	}
	public PaymentDetails( String cardNumber, int expiryMonth,
			int expiryYear, int userId) {
		
		this.cardNumber = cardNumber;
		this.expiryMonth = expiryMonth;
		this.expiryYear = expiryYear;
		this.userId = userId;
	}
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	
	public int getExpiryMonth() {
		return expiryMonth;
	}
	
	public void setExpiryMonth(int expiryMonth) {
		this.expiryMonth = expiryMonth;
	}
	
	public int getExpiryYear() {
		return expiryYear;
	}
	
	public void setExpiryYear(int expiryYear) {
		this.expiryYear = expiryYear;
	}
}
