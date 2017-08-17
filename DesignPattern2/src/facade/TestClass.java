package facade;

import java.util.HashMap;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import model.ProductDetails;

public class TestClass {
    CartOperations cartOperations;
    HashMap<Integer,ProductDetails> productDetails;
    
    @Before
   public void setup(){
    	cartOperations=CartOperations.getInstance();
    	productDetails=cartOperations.getProductDetails();
    }
    
    //to check product is valid or not
    //valid Product
    @Test
    public void testValidProduct(){
		Assert.assertTrue(cartOperations.isProductInProductDetails(1001));
	}
    //Invalid Product
    @Test
    public void testInValidProduct(){
		Assert.assertFalse(cartOperations.isProductInProductDetails(3001));
	}
    
    //To check product exist in cart or not
    @Test
    public void testIsProductInCart(){
    	Assert.assertFalse(cartOperations.isProductInCart(productDetails.get(1001)));
    }
    
    //test to check add product in cart
    @Test
    public void testAddProductInCart(){
    	Assert.assertTrue(cartOperations.isProductInProductDetails(1003));
    	Assert.assertFalse(cartOperations.isProductInCart(productDetails.get(1003)));
    	cartOperations.addProductToCart(1003, 2);
    	Assert.assertTrue(cartOperations.isProductInCart(productDetails.get(1003)));
    }
    
    //test to deleter product from cart
     @Test
     public void testDeleteProductFromCart(){
    	Assert.assertTrue(cartOperations.isProductInProductDetails(1002));
    	cartOperations.addProductToCart(1002, 2);
    	Assert.assertTrue(cartOperations.isProductInCart(productDetails.get(1002)));
    	cartOperations.deleteProductFromCart(1002);
    	Assert.assertFalse(cartOperations.isProductInCart(productDetails.get(1002))); 	
   }
    
     //Test to update cart
    @Test
    public void testUpdateCart(){
    	Assert.assertTrue(cartOperations.isProductInProductDetails(1001));
    	cartOperations.addProductToCart(1001, 2);
    	Assert.assertTrue(cartOperations.isProductInCart(productDetails.get(1001)));
    	cartOperations.updateProductCart(1001,8);
    	int quantity=cartOperations.getSelectedProducts().get(productDetails.get(1001)).getProductQuantity();
    	Assert.assertEquals(8, quantity);
    }
    
    
}
