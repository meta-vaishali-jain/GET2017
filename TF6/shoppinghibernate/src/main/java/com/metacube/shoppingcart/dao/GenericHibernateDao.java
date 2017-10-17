package com.metacube.shoppingcart.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

import com.metacube.shoppingcart.dto.OrderDetailsDto;
import com.metacube.shoppingcart.dto.UserDto;
import com.metacube.shoppingcart.enums.Status;
import com.metacube.shoppingcart.modal.Cart;
import com.metacube.shoppingcart.modal.Order;
import com.metacube.shoppingcart.modal.OrderDetails;
import com.metacube.shoppingcart.modal.PaymentDetails;
import com.metacube.shoppingcart.modal.Product;
import com.metacube.shoppingcart.modal.User;

/**
 * ClassName : GenericHibernateDao
 * 
 * @author :Vaishali Jain 
 * Description: Give definition of all the methods
 *         related to database
 * @param <T>
 * @param <ID>
 */
public abstract class GenericHibernateDao<T, ID extends Serializable>
		implements AbstractDao<T, ID> {

	// object of session factory
	@Autowired
	private SessionFactory sessionFactory;

	// parameterize constructor
	public GenericHibernateDao(Class<T> modelClass) {
		this.modelClass = modelClass;

	}

	// getter to get session factory
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	// setter to set session factory
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	private Class<T> modelClass;

	// getter to get modal class
	public Class<T> getModelClass() {
		return modelClass;
	}

	/**
	 * Method to add product entity to the database
	 */
	@Override
	public <S extends T> Status save(final S entity) {
		Status result = Status.Success;
		try {
			// to get current session
			Session session = this.sessionFactory.getCurrentSession();
			session.save(entity);
		} catch (Exception e) {
			result = Status.Error_Occured;
		}
		return result;
	}

	/**
	 * method to find product on the basis of id
	 */
	@Override
	public Product findOne(ID primaryKey) {
		// to get current session
		Session session = this.sessionFactory.getCurrentSession();
		// Criteria query
		Criteria cr = session.createCriteria(Product.class).add(
				Restrictions.eq("id", primaryKey));
		Product product = (Product) cr.uniqueResult();
		return  product;
	}
	
/**
 * method to get user mini cart details on the basis of name
 */
	@Override
	public UserDto findOne(String name) {
		// to get current session
		Session session = this.sessionFactory.getCurrentSession();
		// Criteria query
		Criteria cr = session.createCriteria(getModelClass()).add(
				Restrictions.eq("mail", name));
		User user = (User) cr.uniqueResult();
		
		return getUserMiniCartDetails(user);
	}

	public UserDto getUserMiniCartDetails(User user) { 
		UserDto userCartDetail = new UserDto();
		if(user==null){
			userCartDetail.setUser(user);
			userCartDetail.setTotalPrice(-50.00);
			userCartDetail.setTotalProduct(-1);
		}else{
		
		Double totalPrice = 0.00;
		
		userCartDetail.setUser(user);
		Session session = this.sessionFactory.getCurrentSession();

		Criteria cr = session.createCriteria(Cart.class).add(
				Restrictions.eq("userId", user.getUserId()));

		List<Cart> cartList = cr.list();
		
		userCartDetail.setTotalProduct(cartList.size());
		for (int i = 0; i < cartList.size(); i++) {

			int id = cartList.get(i).getProductId();
			cr = session.createCriteria(Product.class).add(
					Restrictions.eq("id", id));
			Product curproduct = (Product) cr.uniqueResult();
			Double discount = (curproduct.getPrice()*curproduct.getDiscount())*0.01;
			totalPrice += (curproduct.getPrice()-discount);

		}
		userCartDetail.setTotalPrice(totalPrice);
		}
		return userCartDetail;
	}

	/**
	 * method to get all products
	 */
	@Override
	public Iterable<T> findAll() {
		// to get current session
		Session session = this.sessionFactory.getCurrentSession();
		Criteria cr = session.createCriteria(getModelClass());
		List<T> personsList = cr.list();
		return personsList;
	}

	/**
	 * method to delete product on the basis of id
	 */
	@Override
	public Status delete(final ID primaryKey) {
		Status result = Status.Success;
		try {
			// to get current session
			Session session = this.sessionFactory.getCurrentSession();
			Product product = (Product) session.get(Product.class, primaryKey);
			session.delete(product);
		} catch (Exception e) {
			result = Status.Error_Occured;
		}
		return result;
	}

	/**
	 * method to edit product
	 */
	@Override
	public <S extends T> Status edit(S entity, ID primaryKey) {

		Status result = Status.Added;
		try {
			// to get current session
			Session session = this.sessionFactory.getCurrentSession();
			Product update = (Product) entity;
			Product product = (Product) session.get(Product.class, primaryKey);
			product.setName(update.getName());
			product.setPrice(update.getPrice());
			session.update(product);
		} catch (Exception e) {
			result = Status.Error_Occured;
		}
		return result;
	}
	
	/**
	 * Method to add product to the user cart
	 */
	public Status addToCart(Cart cart){
		Status result = Status.Success;
		try {
			Session session = this.sessionFactory.getCurrentSession();
			 Cart currentCart = (Cart)session.createCriteria(getModelClass()).add(
					Restrictions.eq("userId", cart.getUserId())).add(Restrictions.eq("productId", cart.getProductId())).uniqueResult();
			// to get current session
			 
			 if(currentCart == null ) {
	                session.save(cart);
	            }else {
	                result = Status.Failure;
	            }
			
	
		} catch (Exception e) {
			result = Status.Error_Occured;
		}
		return result;
	}
	
	/**
	 * Method to get cart products of the particular user
	 */
	@Override
	public Iterable<Product> getProductsById(int userId) {
		// to get current session
		Session session = this.sessionFactory.getCurrentSession();
		
		List<Product> cartProductList=new ArrayList<Product>();
		// Criteria query
		Criteria cr = session.createCriteria(getModelClass()).add(
				Restrictions.eq("userId", userId));
		List<Cart> productIdList = cr.list();
		for(int i=0;i<productIdList.size();i++){
			int id = productIdList.get(i).getProductId();
			cr = session.createCriteria(Product.class).add(
					Restrictions.eq("id", id));
			Product curproduct = (Product) cr.uniqueResult();
			
			cartProductList.add(curproduct);
		}
		return cartProductList;

	}
	
	/**
	 * method to delete product from cart
	 */
	@Override
	public Status deleteProductFromCart(int productId, int userId) {
		
		Status result = Status.Success;
		try {
			// to get current session
			Session session = this.sessionFactory.getCurrentSession();
			Cart cart = (Cart)session.createCriteria(getModelClass()).add(
					Restrictions.eq("productId", productId)).add(Restrictions.eq("userId",userId)).uniqueResult();
			session.delete(cart);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			result = Status.Error_Occured;
		}
		return result;
	}
	
	/**
	 * method to save user payment details
	 */
	@Override
	public int savePaymentDetails(OrderDetails orderDetails) {
		// TODO Auto-generated method stub
		int curorderId = 0;
		try {
			Session session = this.sessionFactory.getCurrentSession();	
			session.save(orderDetails);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			
		}
		return curorderId;
	}
	
	/**
	 * Method to save Details on the checkout and create order
	 */
	@Override
	public Status saveOrderedProducts(OrderDetails orderDetails,
			List<Product> cartList) {

		Status result = Status.Success;
		try {
			Session session = this.sessionFactory.getCurrentSession();
			for (Product product : cartList) {
				Order order = new Order();
				order.setOrderId(orderDetails.getOrderId());
				order.setProductId(product.getId());
				order.setDiscount(product.getDiscount());
				session.save(order);
			}

			session = this.sessionFactory.getCurrentSession();

			int userId = orderDetails.getPaymentId().getUserId();

			Criteria cr = session.createCriteria(Cart.class).add(Restrictions.eq("userId", userId));

			List<Cart> cartItemsToBeDeletedAfterCheckout = cr.list();

			for (Cart cart : cartItemsToBeDeletedAfterCheckout) {
				session.delete(cart);
			}

			System.out.println("Inserted Successfully");

		} catch (Exception e) {
			e.printStackTrace();
			e.getMessage();
			result = Status.Error_Occured;
		}
		return result;
	}
	
	/**
	 * method to get order of the particular user
	 */
	@Override
	public List<OrderDetails> getOrdersById(int userId) {
		List<OrderDetails> allOrders=new ArrayList<OrderDetails>();
		
		Session session = this.sessionFactory.getCurrentSession();
		Criteria cr = session.createCriteria(PaymentDetails.class).add(
				Restrictions.eq("userId", userId));
		List<PaymentDetails> productIdList = cr.list();
		for(int i=0;i<productIdList.size();i++){
			int id = productIdList.get(i).getPaymentId();
			System.out.println(id);
			cr = session.createCriteria(OrderDetails.class).add(
					Restrictions.eq("paymentId",productIdList.get(i) ));
			List<OrderDetails> curproduct = cr.list();
			
			allOrders.addAll(curproduct);
		}
		
		return allOrders;
	}
	
	/**
	 * method to get details of the particular order
	 */
	@Override
	public List<OrderDetailsDto> getOrderDetailsById(int orderId) {
		// TODO Auto-generated method stub
		List<OrderDetailsDto> orderProductDetailsDtoList=new ArrayList<OrderDetailsDto>();
		OrderDetailsDto orderProductDetails=new OrderDetailsDto();
		Session session = this.sessionFactory.getCurrentSession();
		Criteria cr = session.createCriteria(Order.class).add(
				Restrictions.eq("orderId", orderId));
		List<Order> orderProductList = cr.list();
		for(int i=0;i<orderProductList.size();i++){
			int productId=orderProductList.get(i).getProductId();
			cr = session.createCriteria(Product.class).add(
					Restrictions.eq("id",productId ));
			Product curproduct = (Product) cr.uniqueResult();
			orderProductDetails=new OrderDetailsDto(curproduct.getId(),curproduct.getName(),curproduct.getPrice(),orderProductList.get(i).getDiscount());
			orderProductDetailsDtoList.add(orderProductDetails);
		}
		return orderProductDetailsDtoList;
	}
}
