package Dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import Model.ProductDetails;

/**
 * ClassName  : ProductDetailsDao
 * @author    : Vaishali Jain
 * Description: Dao class to perform read and write operations on product Details file.
 */
public class ProductDetailsDao {
	private HashMap<Integer,ProductDetails> productDetailsList=new HashMap<Integer,ProductDetails>();
	
	//getter method to get hashMap value containing key as productID and ProductDetails class object.
	public HashMap<Integer, ProductDetails> getProductList() {
		return productDetailsList;
	}
    
	/*
	 * function to read product details an split the details on the basis of ',' from the file and return hashMap 
	 */
	public  HashMap<Integer,ProductDetails> readProductDetails(){
		BufferedReader reader=null;
		try {
			reader = new BufferedReader(new FileReader(new File("ProductDetails.txt")));
			String productDetails;
			while((productDetails = reader.readLine()) != null) {
				String[] splitedProductDetails=productDetails.split("\\,");
				int productID=Integer.parseInt(splitedProductDetails[0]);
				String productType=splitedProductDetails[1];
				String productName=splitedProductDetails[2];
				ProductDetails productDetailsObject=new ProductDetails(productID,productType,productName);
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
	
	
	/*
	 * method to write product details after any updation to the file.
	 */
	public void writeToFile(HashMap<Integer,ProductDetails> productDetailsList){
		BufferedWriter writer=null;
		try{
			writer= new BufferedWriter(new FileWriter(new File("ProductDetails.txt")));
			for(Map.Entry<Integer,ProductDetails> mapSet :productDetailsList.entrySet()){
				String productDetails= mapSet.getValue().getProductCode()+","+
									   mapSet.getValue().getProductType()+","+
									   mapSet.getValue().getProductName();
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
