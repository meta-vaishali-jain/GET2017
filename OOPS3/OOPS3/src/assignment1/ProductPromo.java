package assignment1;

import java.util.Arrays;

public class ProductPromo {
    private String promotionType;
    private double discount;
    private int[]  productId;
    public ProductPromo(String productPromoData[]){
    	
    	
    	this.promotionType = productPromoData[0];	
    	this.discount = Double.parseDouble(productPromoData[1]); 
    	
    	String[] products = productPromoData[2].split(";"); 
        
    	productId = new int[products.length];
    	for(int index = 0; index < products.length; index++){
    		
        	productId[index] = Integer.parseInt(products[index]); 
        }
    }
    public String getPromotionType() {
		return promotionType;
	}
	
	public double getDiscount() {
		return discount;
	}
	
	public int[] getProductId() {
		return productId;
	}
	
	
}
