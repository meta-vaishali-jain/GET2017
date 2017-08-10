package assignment1;
/**
 * ClassName ProductDetails
 * @author   Vaishali Jain
 * Description Describe all the details of the products with its getter and setter method.
 */

public class ProductDetails implements Action {
	private int productID ;
	private String productName;
	private double productPrice;
	
	//default constructor
	public ProductDetails(){
	}
	
	//parameterize constructor
	public ProductDetails(String productData[]){	
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
	
	public void performAction(){
      PrintProductDetails printProductDetails=new PrintProductDetails();
       printProductDetails.printProductDetails(new ReadFile());
	}
}
