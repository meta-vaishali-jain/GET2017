package com.metacube.shoppingcart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.metacube.shoppingcart.dto.OrderDetailsDto;
import com.metacube.shoppingcart.dto.ProductDto;
import com.metacube.shoppingcart.dto.UserDto;
import com.metacube.shoppingcart.enums.Status;
import com.metacube.shoppingcart.facade.CartFacade;
import com.metacube.shoppingcart.facade.OrderFacade;
import com.metacube.shoppingcart.facade.UserFacade;
import com.metacube.shoppingcart.modal.Cart;
import com.metacube.shoppingcart.modal.OrderDetails;
import com.metacube.shoppingcart.modal.PaymentDetails;
import com.metacube.shoppingcart.modal.Product;
import com.metacube.shoppingcart.modal.User;

/**
 * ClassName   : UserController
 * @author     : Vaishali Jain
 * Description : Controller class of the User
 *               Decide what action to perform on the basis of the path
 */
@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	UserFacade userFacade;
	
	@Autowired
	CartFacade cartFacade;
	
	@Autowired
	OrderFacade orderFacade;
	
	//request to get user on the basis of id
		@RequestMapping(value="/get/{userName}" , produces="application/json")
		public @ResponseBody UserDto  getUserBy(@PathVariable("userName") String userName) {
			return userFacade.getUserByName(userName);
		}
		
		//request to display cart product on the basis of user id 
		@RequestMapping(value="/getCart/{userId}" , produces="application/json")
		public @ResponseBody Iterable<Product> getProductsById(@PathVariable("userId") int userId) {
			return cartFacade.getProductsById(userId);
		}
		
		//request to add product to the cart
		@RequestMapping(value="/add")
		public @ResponseBody Status addProduct(@RequestBody Cart cart) {
			return cartFacade.addProductToCart(cart);
		}
		
		//request to delete product from cart on the basis of product id and usr id
		@RequestMapping(value="/deleteFromCart/{productId}/{userId}" , produces="application/json")
		public @ResponseBody Status deleteProductFromCartById(@PathVariable("productId") int productId, @PathVariable("userId") int userId){
			return cartFacade.deleteProductFromCart(productId,userId);
		}
		
		//request to save payment details
		@RequestMapping(value="/savePaymentDetails" , produces="application/json")
		public @ResponseBody Status savePaymentDetails(@RequestBody OrderDetails orderDetails) {
			cartFacade.savePaymentDetails(orderDetails);
			List<Product> cartList= (List<Product>) cartFacade. getProductsById(orderDetails.getPaymentId().getUserId());
			return orderFacade.saveOrderedProducts(orderDetails,cartList);
		}
		
		// request to get user orders
		@RequestMapping(value = "/getOrders/{userId}", produces = "application/json")
		public @ResponseBody List<OrderDetails> getOrdersById(
			@PathVariable("userId") int userId) {
		return orderFacade.getOrdersById(userId);
		}
		
		// request to display details of order on the basis of order id
				@RequestMapping(value = "/getOrderDetails/{orderId}", produces = "application/json")
				public @ResponseBody List<OrderDetailsDto> getOrderDetailsById(
					@PathVariable("orderId") int orderId) {
				return orderFacade.getOrderDetailsById(orderId);
				}
	  
		
}
