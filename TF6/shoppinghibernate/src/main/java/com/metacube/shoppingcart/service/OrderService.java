package com.metacube.shoppingcart.service;

import java.util.List;

import com.metacube.shoppingcart.dto.OrderDetailsDto;
import com.metacube.shoppingcart.enums.Status;
import com.metacube.shoppingcart.modal.OrderDetails;
import com.metacube.shoppingcart.modal.Product;

public interface OrderService {
	Status saveOrderedProducts(OrderDetails orderDetails,List<Product> cartList);
	List<OrderDetails> getOrdersById(int userId);
	List<OrderDetailsDto> getOrderDetailsById(int orderId);

}
