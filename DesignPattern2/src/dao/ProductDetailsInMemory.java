package dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import model.ProductDetails;
import model.ProductPrice;

/**
 * ClassName   : ProductDetailsInMemory
 * @author     : Vaishali Jain
 * Description : This class is performing read and write operation on ProductDetails file
 * 			   : while reading returning HashMap of ProductID as key and ProductDetails Object as value
 */
public class ProductDetailsInMemory {
	
	private HashMap<Integer,ProductDetails> productDetailsList=new HashMap<Integer,ProductDetails>();
	ProductPriceInMemory productPriceInMemory=new ProductPriceInMemory();	
	ArrayList<ProductPrice> productsPrice=productPriceInMemory.readProductCosts("ProductPrice.txt");

	//getter method to get hashMap value containing key as productID and ProductDetails class object.
	public HashMap<Integer, ProductDetails> getProductList() {
		return productDetailsList;
	}
	
	public ArrayList<ProductPrice> getProductsPrice(){	
		return productPriceInMemory.getProductsPrice();
	}
    
	/*
	 * function to read product details an split the details on the basis of ',' from the file and return hashMap 
	 */
	public  HashMap<Integer,ProductDetails> readProductDetails(String fileName){
		if(fileName==""){
			throw new NullPointerException();
		}
		else{
		BufferedReader reader=null;
		try {
			reader = new BufferedReader(new FileReader(new File(fileName)));
			String productDetails;
			int count=0;
			while((productDetails = reader.readLine()) != null) {
				String[] splitedProductDetails=productDetails.split("\\,");
				int productID=Integer.parseInt(splitedProductDetails[0]);
				String productType=splitedProductDetails[1];
				String productName=splitedProductDetails[2];
				productsPrice=getProductsPrice();
				ProductDetails productDetailsObject=new ProductDetails(productID,productType,productName,productsPrice.get(count++));
				productDetailsList.put(productID,productDetailsObject);
			}
			return productDetailsList;
		}catch(IOException e) {
			e.printStackTrace();
			return productDetailsList;
		}
		finally{
			try {
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		}	
	}
	
	
	/*
	 * method to write product details after any updation to the file.
	 */
	public void writeToFile(HashMap<Integer,ProductDetails> productDetailsList){
		BufferedWriter writer=null;
		try{
			writer= new BufferedWriter(new FileWriter(new File("C:\\D\\GET2017\\Assigments\\SubmittedAssigments\\src\\DesignPattern2\\ProductDetails.txt")));
			for(Map.Entry<Integer,ProductDetails> mapSet :productDetailsList.entrySet()){
				String productDetails= mapSet.getValue().getProductID()+","+
									   mapSet.getValue().getProductType()+","+
									   mapSet.getValue().getProductName();
				productPriceInMemory.writeToFile(productsPrice);
				writer.write(productDetails);
				writer.newLine();
	        }
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try {
				writer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
