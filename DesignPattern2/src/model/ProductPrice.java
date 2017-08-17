package model;

/**
 * ClassName   : ProductPrice
 * @author     : Vaishali Jain
 * Description : contains details of the product cost
 */
public class ProductPrice {
	private double productCost;

	public double getProductCost() {
		return productCost;
	}

	public void setProductCost(double productCost) {
		this.productCost = productCost;
	}
    
	//parametrize  constructor
	public ProductPrice(double productCost) {
		this.productCost = productCost;
	}
	
	
}
