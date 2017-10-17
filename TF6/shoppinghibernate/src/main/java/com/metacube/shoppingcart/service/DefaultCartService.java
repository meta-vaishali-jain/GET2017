package com.metacube.shoppingcart.service;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.metacube.shoppingcart.dao.cart.CartDao;
import com.metacube.shoppingcart.dao.paymentDao.PaymentDao;
import com.metacube.shoppingcart.enums.Status;
import com.metacube.shoppingcart.modal.Cart;
import com.metacube.shoppingcart.modal.OrderDetails;
import com.metacube.shoppingcart.modal.PaymentDetails;
import com.metacube.shoppingcart.modal.Product;

/**
 * ClassName  : DefaultCartService
 * @author    : Vaishali Jain
 * Description: Calls the particular Dao method
 */
@Service("cartService")
@Transactional
public class DefaultCartService implements CartService{
	
	@Resource(name = "hibernateCartDao")
	CartDao cartDao;
	
	@Resource(name = "hibernatePaymentDao")
	PaymentDao paymentDao;
	
	public DefaultCartService(){
		
	}

	@Override
	public Status addProductToCart(Cart cart) {
		// TODO Auto-generated method stub
		return cartDao.addToCart(cart);
	}

	@Override
	public Iterable<Product> getProductsById(int userId) {
		// TODO Auto-generated method stub
		return cartDao. getProductsById(userId);
	}

	@Override
	public Status deleteProductFromCart(int productId, int userId) {
		// TODO Auto-generated method stub
		return cartDao.deleteProductFromCart(productId,userId);
	}

	@Override
	public int savePaymentDetails(OrderDetails orderDetails) {
		// TODO Auto-generated method stub
		return paymentDao.savePaymentDetails(orderDetails);
	}

}
