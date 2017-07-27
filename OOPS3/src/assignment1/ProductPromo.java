package assignment1;
/**
 * Class Name : ProductPromo
 * @author    : Vaishali Jain
 * Description: to describe product promotion details
 */

public class ProductPromo implements Action{
	private String promotionType;
    private double discount;
    private int[]  productId;
    
    //default constructor
    public ProductPromo(){
    	
    }
    
    //parameterize constructor
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

	@Override
	public void performAction() {
		  PrintProductDetails printProductDetails=new PrintProductDetails();
	       printProductDetails.printProductPromoDetails(new ReadFile());
		
	}
	
	
}
