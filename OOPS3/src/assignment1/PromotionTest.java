package assignment1;

import org.junit.*;
public class PromotionTest {
	 ProductPromo productPromoDetails[];
	 OrderPromo orderPromoDetails[];
	 OrderProductDetails orderDetails=new OrderProductDetails();
		@Before
		public void setup(){
			 productPromoDetails=new ProductPromo[ReadFile.getNoOfLines("ProductPromo.csv")];
			 productPromoDetails= ReadFile.readProductPromo("ProductPromo.csv");
			 orderPromoDetails=new OrderPromo[ReadFile.getNoOfLines("OrderPromo.csv")];
			 orderPromoDetails=ReadFile.readOrderPromo("OrderPromo.csv");
			 orderDetails.setProductID(1001);
			 orderDetails.setProductQuantity(2);
		}
		/*
		 * To check whether on product there is percent promotion or order promotion
		 */
		@Test
		public void testValidIsProductPercentPromotion(){
		   Assert.assertTrue(Promotion.isPercentPromotion(productPromoDetails[2]));
		}
		
		@Test
		public void testInValidIsProductPercentPromotion(){
		   Assert.assertFalse(Promotion.isPercentPromotion(productPromoDetails[1]));
		}
		
		@Test
		public void testValidIsOrderPercentPromotion(){
		   Assert.assertTrue(Promotion.isPercentPromotion(orderPromoDetails[2]));
		}
		
		@Test
		public void testInValidIsOrderPercentPromotion(){
		   Assert.assertFalse(Promotion.isPercentPromotion(orderPromoDetails[1]));
		}
		
		//calculate discount
		@Test
		public void testValidCalculateDiscount(){
			Assert.assertEquals(800.00,Promotion.calculateDiscount(productPromoDetails, orderDetails), 0.01);
		}
}
