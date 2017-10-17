package com.metacube.shoppingcart.dao.paymentDao;

import com.metacube.shoppingcart.dao.AbstractDao;
import com.metacube.shoppingcart.modal.Cart;
import com.metacube.shoppingcart.modal.OrderDetails;
import com.metacube.shoppingcart.modal.PaymentDetails;
import com.metacube.shoppingcart.modal.Product;
import com.metacube.shoppingcart.modal.User;

public interface PaymentDao extends AbstractDao<OrderDetails, Integer> {

}
