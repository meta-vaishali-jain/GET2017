package model;

/**
 * ClassName   : OrderedProductDetails
 * @author     : Vaishali Jain
 * Description : Contains complete details of the user ordered product
 */
public class OrderedProductDetails {
	private int productID;
	private int productQuantity;
	private double totalCost;
	public int getProductID() {
		return productID;
	}
	public void setProductID(int productID) {
		this.productID = productID;
	}
	public int getProductQuantity() {
		return productQuantity;
	}
	public void setProductQuantity(int productQuantity) {
		this.productQuantity = productQuantity;
	}
	public double getTotalCost() {
		return totalCost;
	}
	public void setTotalCost(double totalCost) {
		this.totalCost = totalCost;
	}
	//parametrize  constructor
	public OrderedProductDetails(int productID, int productQuantity,
			double totalCost) {
		this.productID = productID;
		this.productQuantity = productQuantity;
		this.totalCost = totalCost;
	}
	
	
}
