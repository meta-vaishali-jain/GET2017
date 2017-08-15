package Model;

/**
 * Class Name :ProductDetails
 * @author    :Vaishali Jain
 * Description:Description of product its code type and name .
 *
 */
public class ProductDetails {
	private int productID;
	private String productType;
	private String productName;
	
	//parameterize constructor to set class data members
	public ProductDetails(int productCode, String productType,String productName) {
		this.productID = productCode;
		this.productType = productType;
		this.productName = productName;
	}
	
	/*
	 * getter and setter for all data members
	 */
	public int getProductCode() {
		return productID;
	}
	public void setProductCode(int productCode) {
		this.productID = productCode;
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
}
