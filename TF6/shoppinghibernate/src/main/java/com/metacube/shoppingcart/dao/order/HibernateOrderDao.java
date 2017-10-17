package com.metacube.shoppingcart.dao.order;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.metacube.shoppingcart.dao.GenericHibernateDao;
import com.metacube.shoppingcart.dto.OrderDetailsDto;
import com.metacube.shoppingcart.enums.Status;
import com.metacube.shoppingcart.modal.Cart;
import com.metacube.shoppingcart.modal.Order;
import com.metacube.shoppingcart.modal.OrderDetails;
import com.metacube.shoppingcart.modal.PaymentDetails;
import com.metacube.shoppingcart.modal.Product;

@Repository("hibernateOrderDao")
public class HibernateOrderDao extends GenericHibernateDao<Order, Integer> implements OrderDao {
	
	public HibernateOrderDao() {
		super(Order.class);
	}

	

	
}
