package Model;

/**
 * ClassName  :ProductPrice
 * @author    :Vaishali Jain
 * Description:class containing details of the price of all the products
 */
public class ProductPrice {
	private int productID;
	private double productPrice;
	
	//parameterize constructor
	public ProductPrice(int productId, double productPrice) {
		this.productID = productId;
		this.productPrice = productPrice;
	}
	
	/*
	 * getters and setters to get and set class data members values
	 */
	public int getProductID() {
		return productID;
	}
	public void setProductID(int productId) {
		this.productID = productId;
	}
	public double getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}
	
	
}
