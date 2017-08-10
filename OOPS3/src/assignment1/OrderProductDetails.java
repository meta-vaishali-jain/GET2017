package assignment1;
/**
 * ClassName:OrderProductDetails
 * @author  :Vaishali Jain 
 * including its price Description:class which stores all the details of the user orders
 */
public class OrderProductDetails {
	private int productID;
	private String productName;
	private int productQuantity;
	private double costPrice;
	private double orderTotalPrice;
	
	//to set values
	public void setValues(OrderDetails userOrder,ProductDetails[] productDetail){
		for(ProductDetails product : productDetail) {
			if(userOrder.getOrderProductId() == product.getProductID()) {
				setValues(userOrder, product);
				break;
			}
		}
	}
	//overloaded method
	private void setValues(OrderDetails userOrder,ProductDetails product){
		this.setProductID(userOrder.getOrderProductId());
		this.setProductName(product.getProductName());
		this.setProductQuantity(userOrder.getOrderProductQuantity());
		this.setCostPrice(product.getProductPrice());
		orderTotalPrice=this.getCostPrice()*this.getProductQuantity();
	}
	
	/**
	 * method to check whether the given productID is applicable for discount or not
	 * @param productPromoDetails
	 * @return
	 */
	public boolean isApplicableForProductPromotion(ProductPromo[] productPromoDetails){
		boolean flag=false;
		// item is to iterate array of productPromo
		for(ProductPromo item:productPromoDetails){
			for(int k=0;k< item.getProductId().length;k++){
				if(this.getProductID()==item.getProductId()[k]){
				    flag=true	;
				    break;
				}
			}
		}
		return flag;
	}
    /**
     * method to get discount for a particular orderProductID
     * @param productPromoDetails
     * @return
     */
	public double getDiscount(ProductPromo[] productPromoDetails){
		double discount=0;
		for(ProductPromo item:productPromoDetails){
			for(int k=0;k< item.getProductId().length;k++){
				if(this.getProductID()==item.getProductId()[k]){
				  discount=  item.getDiscount();
				    break;
				}
			}
		}
		return discount;
	}
	
	/**
	 * method to calculate maximum discount among different discount for particular orderID
	 * @param productPromoDetails
	 * @return
	 */
	public  double calculateDiscount(ProductPromo[] productPromoDetails){
		
				return Promotion.calculateDiscount(productPromoDetails,this);
			} 
	
	public int getProductID() {
		return productID;
	}

	public void setProductID(int productID) {
		this.productID = productID;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getProductQuantity() {
		return productQuantity;
	}

	public void setProductQuantity(int productQuantity) {
		this.productQuantity = productQuantity;
	}

	public double getCostPrice() {
		return costPrice;
	}

	public void setCostPrice(double costPrice) {
		this.costPrice = costPrice;
	}

	public double getOrderTotalPrice() {
		return orderTotalPrice;
	}

	public void setOrderTotalPrice(double orderTotalPrice) {
		this.orderTotalPrice = orderTotalPrice;
	}

}
