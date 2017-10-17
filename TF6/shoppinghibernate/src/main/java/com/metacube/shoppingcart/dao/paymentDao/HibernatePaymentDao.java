package com.metacube.shoppingcart.dao.paymentDao;

import org.springframework.stereotype.Repository;

import com.metacube.shoppingcart.dao.GenericHibernateDao;
import com.metacube.shoppingcart.enums.Status;
import com.metacube.shoppingcart.modal.Cart;
import com.metacube.shoppingcart.modal.OrderDetails;
import com.metacube.shoppingcart.modal.PaymentDetails;
import com.metacube.shoppingcart.modal.Product;

@Repository("hibernatePaymentDao")
public class HibernatePaymentDao extends GenericHibernateDao<OrderDetails, Integer> implements PaymentDao {
	
	public HibernatePaymentDao() {
		super(OrderDetails.class);
	}

	

	
}
