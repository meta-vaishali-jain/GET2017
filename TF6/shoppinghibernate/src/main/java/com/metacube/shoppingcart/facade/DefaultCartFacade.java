package com.metacube.shoppingcart.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.metacube.shoppingcart.enums.Status;
import com.metacube.shoppingcart.modal.Cart;
import com.metacube.shoppingcart.modal.OrderDetails;
import com.metacube.shoppingcart.modal.PaymentDetails;
import com.metacube.shoppingcart.modal.Product;
import com.metacube.shoppingcart.service.CartService;

/**
 * ClassName  : DefaultCartFacade
 * @author    : Vaishali Jain
 * Description: Class performing business logic for cart operations
 */
@Component("cartFacade")
public class DefaultCartFacade  implements CartFacade {
	
	@Autowired
	CartService cartService;

	@Override
	public Status addProductToCart(Cart cart) {
		// TODO Auto-generated method stub
		return cartService.addProductToCart(cart);
	}

	@Override
	public Iterable<Product> getProductsById(int userId) {
		
		return  cartService.getProductsById(userId);
	}
	
	public Status deleteProductFromCart(int productId, int userId) {
		return  cartService.deleteProductFromCart(productId,userId);
	}

	@Override
	public int savePaymentDetails(OrderDetails orderDetails) {
		
		return cartService.savePaymentDetails(orderDetails);
	}


}
