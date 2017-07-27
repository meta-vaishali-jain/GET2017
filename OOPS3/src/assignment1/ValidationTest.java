package assignment1;

import org.junit.*;
public class ValidationTest {
    ProductDetails productDetails[];
   
	@Before
	public void setup(){
		 productDetails=new ProductDetails[ReadFile.getNoOfLines("ProductDetails.csv")];
		 productDetails= ReadFile.readProductList("ProductDetails.csv");
		
	}
	//To test Product id enter is valid or not
	@Test
	public void TestValidProductID(){
		Assert.assertTrue(Validation.checkProductID(1001, productDetails));
	}
	//to test if Product id is invalid
	@Test
	public void TestInValidProductID(){
		Assert.assertTrue(!Validation.checkProductID(2001, productDetails));
	}
	//to test if order size is valid
	@Test
	public void TestValidOrderSize(){
		Assert.assertTrue(Validation.checkOrderSize(10));
	}
	
	@Test
	public void TestInValidOrderSize(){
		Assert.assertTrue(!Validation.checkOrderSize(-1));
	}
	// to test if quantity is valid
	@Test
	public void TestValidQuantity(){
		Assert.assertTrue(Validation.checkQuantitySize(2));
	}
	
	@Test
	public void TestInValidQuantity(){
		Assert.assertTrue(!Validation.checkQuantitySize(-2));
	}
	
	
}
