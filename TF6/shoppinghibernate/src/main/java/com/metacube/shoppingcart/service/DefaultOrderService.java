package com.metacube.shoppingcart.service;

import java.util.List;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.metacube.shoppingcart.dao.order.OrderDao;
import com.metacube.shoppingcart.dao.paymentDao.PaymentDao;
import com.metacube.shoppingcart.dao.product.ProductDao;
import com.metacube.shoppingcart.dto.OrderDetailsDto;
import com.metacube.shoppingcart.enums.Status;
import com.metacube.shoppingcart.modal.OrderDetails;
import com.metacube.shoppingcart.modal.Product;

/**
 * ClassName  : DefaultOrderService
 * @author    : Vaishali Jain
 * Description: Calls the particular Dao method
 */
@Service("orderService")
@Transactional
public class DefaultOrderService implements OrderService {

	@Resource(name = "hibernateOrderDao")
	OrderDao orderDao;
	
	@Resource(name = "hibernatePaymentDao")
	PaymentDao paymentDao;
	@Override
	public Status saveOrderedProducts(OrderDetails orderDetails,
			List<Product> cartList) {
		
		return orderDao.saveOrderedProducts(orderDetails,cartList);
	}
	@Override
	public List<OrderDetails> getOrdersById(int userId) {
	
		return paymentDao.getOrdersById(userId) ;
	}
	@Override
	public List<OrderDetailsDto> getOrderDetailsById(int orderId) {
		// TODO Auto-generated method stub
		return orderDao.getOrderDetailsById(orderId);
	}

}
