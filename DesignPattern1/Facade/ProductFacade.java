package Facade;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import Dao.ProductDetailsDao;
import Dao.ProductPriceDao;
import Model.ProductDetails;
import Model.ProductPrice;

/**
 * ClassName  : ProductFacade
 * @author    : Vaishali Jain
 * Description: Facade class to perform business logics and to validate input from the user
 */
public class ProductFacade {
	private static ProductFacade productFacadeObject = null;
	private HashMap<Integer,ProductDetails> productDetailsList=new HashMap<Integer,ProductDetails>();
	private HashMap<Integer,ProductPrice> productPriceList=new HashMap<Integer,ProductPrice>();
	ProductDetailsDao productDetailsDaoObject=new ProductDetailsDao(); 
	ProductPriceDao productPriceDaoObject=new ProductPriceDao();
	
	//private constructor
	private ProductFacade(){
	}
	
	/*
	 * getter of the constructor to get the instance of the object,to make singleton class
	 */
	public static ProductFacade getInstance(){
		if(productFacadeObject==null){
			productFacadeObject=new ProductFacade();
		}
		return productFacadeObject;
	}
	
	// getter and setter of Hash map of productPricelist containing key as productID
	public HashMap<Integer, ProductPrice> getProductPriceList() {
		return productPriceList;
	}

	public void setProductPriceList(HashMap<Integer, ProductPrice> productPriceList) {
		this.productPriceList = productPriceList;
	}
	
	// getter and setter of Hash map of productDetailsList containing key as productID
	public HashMap<Integer, ProductDetails> getProductDetailsList() {
		return productDetailsList;
	}

	public void setProductDetailsList(HashMap<Integer, ProductDetails> productDetailsList) {
		this.productDetailsList = productDetailsList;
	}
	
	/*
	 * method to check that the productID is in list or not
	 */
	public boolean isValidId(String productID){
		return productDetailsList.containsKey(Integer.parseInt(productID));
	}
	
	/*
	 * method to check that the enter entity is in number format only
	 */
	public boolean isValidEntity(String entity){
		try{
			double parsedEntity=Double.parseDouble(entity);
		}catch(NumberFormatException e){
			return false;
		}
		return true;
	}
	
	/*
	 * method to check enter entity is not empty or null
	 */
	public boolean isNotNull(String entity){
		if(entity==null||entity==""){
			return false;
		}
		return true;
	}
	
	/*
	 * method to retrieve values from the files using dao class
	 */
	public void retrieveValues(){
	   productDetailsList=productDetailsDaoObject.readProductDetails();	
	   productPriceList=productPriceDaoObject.readProductCosts("ProductPrice.txt");
	}
	
    /*
     * method to update the products in files and in hashmaps
     */
	public void updateDetails(ProductDetails productDetailsObject,ProductPrice productPriceObject){
		int productCode=productDetailsObject.getProductCode();
		productDetailsList.put(productCode, productDetailsObject);
		productPriceList.put(productCode, productPriceObject);
		productDetailsDaoObject.writeToFile(productDetailsList);
		productPriceDaoObject.writeToFile(productPriceList);
	}
}
