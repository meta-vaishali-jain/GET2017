package model;

/**
 * Name  		:	ProductDetails
 * Author  		:	Vaishali Jain
 * Description	:	Description of product, its code type and name.
 */
public class ProductDetails {
	private int productID;
	private String productType;
	private String productName;
	private ProductPrice productPrice;
	public int getProductID() {
		return productID;
	}
	public void setProductID(int productID) {
		this.productID = productID;
	}
	
	public String getProductType() {
		return productType;
	}
	public void setProductType(String productType) {
		this.productType = productType;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	
	public ProductPrice getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(ProductPrice productPrice) {
		this.productPrice = productPrice;
	}
	
	//parametrize constructor
	public ProductDetails(int productID, String productType,
			String productName, ProductPrice productPrice) {
		this.productID = productID;
		this.productType = productType;
		this.productName = productName;
		this.productPrice = productPrice;
	}
	
	
}
