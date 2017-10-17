package com.metacube.shoppingcart.service;

import com.metacube.shoppingcart.enums.Status;
import com.metacube.shoppingcart.modal.Cart;
import com.metacube.shoppingcart.modal.OrderDetails;
import com.metacube.shoppingcart.modal.PaymentDetails;
import com.metacube.shoppingcart.modal.Product;

public interface CartService {
	Status addProductToCart(Cart cart);
	Iterable<Product> getProductsById(int userId);
	Status deleteProductFromCart(int productId, int userId);
	int savePaymentDetails(OrderDetails orderDetails);
}
