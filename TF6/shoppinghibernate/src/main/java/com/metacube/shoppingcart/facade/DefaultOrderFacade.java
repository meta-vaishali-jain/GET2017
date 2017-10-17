package com.metacube.shoppingcart.facade;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.metacube.shoppingcart.dto.OrderDetailsDto;
import com.metacube.shoppingcart.enums.Status;
import com.metacube.shoppingcart.modal.OrderDetails;
import com.metacube.shoppingcart.modal.Product;
import com.metacube.shoppingcart.service.OrderService;
import com.metacube.shoppingcart.service.ProductService;

/**
 * ClassName  : DefaultOrderFacade
 * @author    : Vaishali Jain
 * Description: Class performing business logic for order operations
 */
@Component("orderFacade")
public class DefaultOrderFacade implements OrderFacade {
	
	@Autowired
	OrderService orderService;

	@Override
	public Status saveOrderedProducts(OrderDetails orderDetails,
			List<Product> cartList) {
		
		return orderService.saveOrderedProducts(orderDetails,cartList);
	}

	@Override
	public List<OrderDetails> getOrdersById(int userId) {
		// TODO Auto-generated method stub
		return orderService.getOrdersById(userId);
	}

	@Override
	public List<OrderDetailsDto> getOrderDetailsById(int orderId) {
		// TODO Auto-generated method stub
		return orderService.getOrderDetailsById(orderId);
	}

}
