package assignment1;

import java.util.Arrays;
/**
 * ClassName   : PrintProductDetails
 * @author     : Vaishali Jain
 * Description : class containing method to print different files
 */

public class PrintProductDetails {
	/**
	 * Print productdetails file
	 * @param file
	 * @return
	 */
	
public static ProductDetails[] printProductDetails(ReadFile file ){
	ProductDetails[] productDetails=file.readProductList("ProductDetails.csv");
	System.out.println("List of Products");
	System.out.println("ProductID \t ProductName \t\t\t ProductPrice");
	
	for(ProductDetails index:productDetails){
		System.out.println(index.getProductID()+"\t\t"+index.getProductName()+"\t\t"+index.getProductPrice());
	}
    return productDetails;
}

/**
 * print product promotion file
 * @param file
 * @return
 */
public static ProductPromo[] printProductPromoDetails(ReadFile file){
	ProductPromo[] productPromoDetails=file.readProductPromo("ProductPromo.csv");
	System.out.println("List of product and promotions");
	System.out.println("PromotionType\t\t\t Discount\t\t\t Products Applicaple");
	
	for(ProductPromo index: productPromoDetails){
		System.out.println(index.getPromotionType()+"\t\t"+index.getDiscount()+"\t\t"+Arrays.toString(index.getProductId()));
	}
	return productPromoDetails;
}

/**
 * print orderPromotion file
 * @param file
 * @return
 */
public static OrderPromo[] printOrderPromoDetails(ReadFile file){
	OrderPromo[] orderPromoDetails=file.readOrderPromo("OrderPromo.csv");
	System.out.println("List of discounts based on total order");
	System.out.println("ProductID\t\t\t Discount \t\t\t Minimum value of total order");
	
	for(OrderPromo index:orderPromoDetails){
		System.out.println(index.getPromotionType()+"\t\t\t"+index.getDiscount()+"\t\t\t"+index.getThreshHoldValue());
	}
	return orderPromoDetails;
}
}
