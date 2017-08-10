package assignment1;

public class OrderPromo {
	private String promotionType;
    private double discount;
    private double threshHoldValue;
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
}
