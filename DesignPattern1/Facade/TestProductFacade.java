package Facade;

import java.util.HashMap;

import org.junit.*;

import Dao.ProductDetailsDao;
import Dao.ProductPriceDao;
import Model.ProductDetails;
import Model.ProductPrice;

public class TestProductFacade {
	ProductFacade productFacadeObject=null;
	ProductDetailsDao productDetailsDaoObject; 
	ProductPriceDao productPriceDaoObject;
	
	@Before
	public void setUp(){
		productFacadeObject=ProductFacade.getInstance();
		productDetailsDaoObject=new ProductDetailsDao();
		productPriceDaoObject=new ProductPriceDao();
		productFacadeObject.retrieveValues();
	}
	
	//Test case to check for valid id
	@Test
	public void checkValidID(){
		Assert.assertTrue(productFacadeObject.isValidId("1001"));
	}
     
	//Test Case to check for invalid id
	@Test
	public void checkInvalidID(){
		Assert.assertFalse(productFacadeObject.isValidId("2001"));
	}
	
	//Test case to check input is in valid format
	@Test
	public void checkValidEntity(){
		Assert.assertTrue(productFacadeObject.isValidEntity("1001"));
	}
	
	//Test case when input is in invalid form
	@Test
	public void checkInvalidEntity(){
		Assert.assertFalse(productFacadeObject.isValidEntity("cdnjddj"));
	}
	
	//Test case to check updatefunction
	@Test
	public void testUpdateDetails(){
		Assert.assertFalse(productFacadeObject.isValidId("7001"));
		Assert.assertTrue(productFacadeObject.isNotNull("a"));
		Assert.assertTrue(productFacadeObject.isNotNull("a"));
		
		ProductDetails p = new ProductDetails(7001, "a", "a");
		ProductPrice p1 = new ProductPrice(7001,200);
		productFacadeObject.updateDetails(p, p1);
		Assert.assertTrue(productFacadeObject.isValidId("7001"));	
	}
	
	//Test case to check data is retrieved or not
	@Test
	public void checkRetrieveValues(){
		productFacadeObject.retrieveValues();
		int size=productFacadeObject.getProductDetailsList().size();
		Assert.assertEquals(6, size);
	}
}
