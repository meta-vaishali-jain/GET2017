package com.metacube.get.layarch.controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.metacube.get.layarch.dao.user.JdbcProductDao;
import com.metacube.get.layarch.facade.DefaultProductFacade;
import com.metacube.get.layarch.facade.ProductFacade;
import com.metacube.get.layarch.service.DefaultProductService;
/**
ClassName: ProductController
@author  : Vaishali Jain
Description: providing path for all services.
*/

@Path("/product")
public class ProductController
{
	ProductFacade productFacade;
	
	//default constructor
	public ProductController() {
		productFacade = new DefaultProductFacade(new DefaultProductService(new JdbcProductDao()));
	}
	
	/**
	get all products from the database ,which calls the facade logic for database access.
	*/
	@GET
	@Path("/list")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getUsers() {
		
		//calls facade getAllProducts method
		return Response.status(Response.Status.OK).entity(productFacade.getAllProducts()).build();

	}
}
