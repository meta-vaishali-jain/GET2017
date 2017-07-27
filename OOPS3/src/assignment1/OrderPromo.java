package assignment1;
/**
 * ClassName  : OrderPromo 
 * @author    : Vaishali Jain
 * Description: to describe order promotion details.
 */

public class OrderPromo implements Action {
	private String promotionType;
    private double discount;
    private double threshHoldValue;
    
    //default constructor
    public OrderPromo(){
    	
    }
    
    //parameterize constructor
    public OrderPromo(String[] orderPromoData){
    	this.promotionType=orderPromoData[0];
    	this.discount=Double.parseDouble(orderPromoData[1]);
    	this.threshHoldValue=Double.parseDouble(orderPromoData[2]);
    }
    
  
   
	public String getPromotionType() {
		return promotionType;
	}
	public double getDiscount() {
		return discount;
	}
	public double getThreshHoldValue() {
		return threshHoldValue;
	}

	@Override
	public void performAction() {
		PrintProductDetails printProductDetails=new PrintProductDetails();
	       printProductDetails.printOrderPromoDetails(new ReadFile());
		
	}
}
