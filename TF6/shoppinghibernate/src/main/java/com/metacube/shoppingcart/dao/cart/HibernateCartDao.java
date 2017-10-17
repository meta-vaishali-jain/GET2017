package com.metacube.shoppingcart.dao.cart;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.metacube.shoppingcart.dao.GenericHibernateDao;
import com.metacube.shoppingcart.enums.Status;
import com.metacube.shoppingcart.modal.Cart;
import com.metacube.shoppingcart.modal.OrderDetails;
import com.metacube.shoppingcart.modal.Product;

@Repository("hibernateCartDao")
public class HibernateCartDao extends GenericHibernateDao<Cart, Integer> implements CartDao {
	
	public HibernateCartDao() {
		super(Cart.class);
	}

	
}
