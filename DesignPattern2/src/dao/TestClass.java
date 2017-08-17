package dao;

import java.util.ArrayList;
import java.util.HashMap;

import org.junit.Before;
import org.junit.Test;
import org.junit.*;

import model.ProductDetails;
import model.ProductPrice;

public class TestClass {
	ProductPriceInMemory productsPrice;
	ProductDetailsInMemory productsDetails;
    
	@Before
	public void setup(){
		productsPrice=new ProductPriceInMemory();
		productsDetails=new ProductDetailsInMemory();
	}
	
	//Test case to check ProductPrice file read operation
	@Test 
	public void testProductPriceFileRead(){
		ArrayList<ProductPrice> readProductPrice=productsPrice.readProductCosts("ProductPrice.txt");
		Assert.assertEquals(3,readProductPrice.size());		
	}
	
	//Test case to check ProductDetails file read operation
	@Test 
	public void testProductDetailsFileRead(){
		ArrayList<ProductPrice> readProductPrice=productsPrice.readProductCosts("ProductPrice.txt");
		Assert.assertEquals(3,readProductPrice.size());	
		HashMap<Integer,ProductDetails> productDetailsList=productsDetails.readProductDetails("ProductDetails.txt");
		Assert.assertEquals(3, productDetailsList.size());		
	}
	
	//Test check to check if no file path is passed
	@Test(expected=NullPointerException.class)
	public void testFileNull(){
		HashMap<Integer,ProductDetails> productDetailsList=productsDetails.readProductDetails("");
	}

}
