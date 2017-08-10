package assignment1;
/**
 * ClassName   : ProductDetails
 * @author     : Vaishali Jain
 * Description : Class describing all the details of the product as product id ,product name,product price
 *               and contains getter and setter methods for all this types. 
 */

public class ProductDetails {
	private int productID ;
	private String productName;
	private double productPrice;
	
	ProductDetails(String productData[]){	
		 this.setProductID(Integer.parseInt(productData[0]));
		 this.setProductName(productData[1]);
		 this.setProductPrice(Double.parseDouble(productData[2]));
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
	
	public double getProductPrice() {
		return productPrice;
	}
	
	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}
	

}
