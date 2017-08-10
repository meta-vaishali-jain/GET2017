package assignment1;

import org.junit.*;
public class OrderProductDetailsTest {
  
	OrderProductDetails orderProductDetails[];
	 ProductPromo productPromoDetails[];
	@Before
	public void setup(){
		 productPromoDetails=new ProductPromo[ReadFile.getNoOfLines("ProductPromo.csv")];
		 productPromoDetails= ReadFile.readProductPromo("ProductPromo.csv");
		orderProductDetails=new OrderProductDetails[2];
		orderProductDetails[0]=new OrderProductDetails();
		orderProductDetails[1]=new OrderProductDetails();
		orderProductDetails[0].setProductID(1001);
		orderProductDetails[1].setProductID(2001);
		orderProductDetails[0].setProductName("Reebok Sneakers");
		orderProductDetails[1].setProductName("Reebok Shoes");
		orderProductDetails[0].setProductQuantity(1);
		orderProductDetails[0].setProductQuantity(2);
		orderProductDetails[0].setCostPrice(749);
		orderProductDetails[0].setCostPrice(7490);
	}
	/*
	 * To check order is applicable for discount or not
	 */
	@Test
	public void isOrderApplicableForDiscount(){
		Assert.assertTrue(orderProductDetails[0].isApplicableForProductPromotion(productPromoDetails));
	}
	
    /*
     * To check order is applicable for discount or not
     */
	@Test
	public void isOrderNotApplicableForDiscount(){
		Assert.assertFalse(orderProductDetails[1].isApplicableForProductPromotion(productPromoDetails));
	}
	//to check discount value

	@Test
	public void testGetDiscount(){
		Assert.assertEquals(400.00,orderProductDetails[0].getDiscount(productPromoDetails),0.01);
	}
 
}
