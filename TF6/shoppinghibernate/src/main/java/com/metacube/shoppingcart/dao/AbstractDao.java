package com.metacube.shoppingcart.dao;

import java.io.Serializable;
import java.util.List;

import com.metacube.shoppingcart.dto.OrderDetailsDto;
import com.metacube.shoppingcart.dto.UserDto;
import com.metacube.shoppingcart.enums.Status;
import com.metacube.shoppingcart.modal.Cart;
import com.metacube.shoppingcart.modal.OrderDetails;
import com.metacube.shoppingcart.modal.PaymentDetails;
import com.metacube.shoppingcart.modal.Product;


/**
 * Interface  : AbstractDao
 * @author    : Vaishali Jain
 * Description: Declares method to be performed on the database.
 * @param <T>
 * @param <ID>
 */
public interface AbstractDao<T, ID extends Serializable> {
	<S extends T> Status save(S entity);
	Product findOne(ID primaryKey);
	Iterable<T> findAll();
	Status delete(ID primaryKey);
	<S extends T>Status edit(S entity,ID primaryKey);
	UserDto findOne(String name);
	Iterable<Product> getProductsById(int userId);
	Status addToCart(Cart cart);
	Status deleteProductFromCart(int productId, int userId);
	int savePaymentDetails(OrderDetails orderDetails);
	Status saveOrderedProducts(OrderDetails orderDetails,List<Product> cartList);
	List<OrderDetails> getOrdersById(int userId);
	List<OrderDetailsDto> getOrderDetailsById(int orderId);
}
