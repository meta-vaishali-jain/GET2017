package assignment1; 
/**
 * ClassName: Promotion
 * @author  : Vaishali Jain
 * Description : class to handle both order promotion and product promotion
 */
public class Promotion {
    /**
     * for product promotion to get whether promotion is in percent or number and return value according to that
     * @param productPromo
     * @return
     */
	public static boolean isPercentPromotion(ProductPromo productPromo) {
		return ("ProductFixedPercentPromotion".equals(productPromo.getPromotionType()) );
	}
	/**
	 * for order promotion to get whether promotion is in percent or number and return value according to that
	 * @param orderPromo
	 * @return
	 */
	public static boolean isPercentPromotion(OrderPromo orderPromo) {
		return ("OrderFixedPercentPromotion".equals(orderPromo.getPromotionType()) );
	}
	/**
	 * caluclate maximumdiscount among different discount on particular orderid on product promo
	 * @param productPromo
	 * @param order
	 * @return
	 */
	public static double calculateDiscount(ProductPromo productPromo[] ,OrderProductDetails order) {
		double maxDiscount=0;
		for(ProductPromo productIndex:productPromo){
			for(int k=0;k< productIndex.getProductId().length;k++){
			if(productIndex.getProductId()[k]==order.getProductID()){
				double discount = productIndex.getDiscount() * order.getProductQuantity();
				double currentDiscount=isPercentPromotion(productIndex) ? order.getCostPrice()*discount/100.0 : discount;
				if(maxDiscount<currentDiscount){
					maxDiscount=currentDiscount;
				}
		
	}
			}
		}
		return maxDiscount;
	}
}

