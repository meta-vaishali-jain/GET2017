package com.metacube.get.shoppingcart.controller;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.metacube.get.shoppingcart.dao.product.JdbcProductDao;
import com.metacube.get.shoppingcart.facade.DefaultProductFacade;
import com.metacube.get.shoppingcart.facade.ProductFacade;
import com.metacube.get.shoppingcart.factory.Factory;
import com.metacube.get.shoppingcart.model.Product;
import com.metacube.get.shoppingcart.service.DefaultProductService;

/**
 * ClassName  : ProductController
 * @author    :  Vaishali Jain
 * Description: Controller of the project
 * 				Decide which method to call on the basis of URL.
 */

@Path("/products")
public class ProductController
{
	ProductFacade productFacade;

	public ProductController() {
		productFacade = Factory.getApplicationContext().getBean("productFacade", ProductFacade.class);
	}

	@GET
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getProducts() {

		return Response.status(Response.Status.OK).entity(productFacade.getAllProducts()).build();

	}
	@GET
	@Path("/getProduct/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getProductById(@PathParam("id") int id) {
		return Response.status(Response.Status.OK).entity(productFacade.getProductById(id)).build();

	}
	
}
