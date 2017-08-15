package Dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import Model.ProductPrice;

/**
 * ClassName   : ProductPriceDao
 * @author     : Vaishali Jain
 * Description : Dao class to perform read and write operations on productPrice file.
 */
public class ProductPriceDao {
	private  HashMap<Integer,ProductPrice>  productsPriceDetails=new HashMap<Integer,ProductPrice>();
	
	//getter method to get HashMap value
	public HashMap<Integer, ProductPrice> getProductPriceDetails() {
		return productsPriceDetails;
	}
	
	/*
	 * method to read productPrice an split the details on the basis of ',' from the file and return hashMap
	 */
	public   HashMap<Integer,ProductPrice> readProductCosts(String fileName){
		BufferedReader reader=null;
		try {
			reader = new BufferedReader(new FileReader(new File(fileName)));
			String productCosts;			
			while((productCosts = reader.readLine()) != null) {
				String[] splitedProductCostDetails=productCosts.split("\\,");
				int productID=Integer.parseInt(splitedProductCostDetails[0]);
				double productCost=Double.parseDouble(splitedProductCostDetails[1]);
				
				ProductPrice productPriceObject=new ProductPrice(productID, productCost);
				productsPriceDetails.put(productID,productPriceObject);
				
			}
			return productsPriceDetails;
		}catch(IOException e) {
			e.printStackTrace();
			return productsPriceDetails;
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
	 * method to write productPrice details to file after any updation to the file.
	 */
	public void writeToFile(HashMap<Integer,ProductPrice>  productsPriceDetails){
		BufferedWriter writer=null;
		try{
			writer= new BufferedWriter(new FileWriter(new File("ProductPrice.txt")));
			for(Map.Entry<Integer,ProductPrice> mapSet :productsPriceDetails.entrySet()){
				String productPriceDetails= mapSet.getValue().getProductID()+","+
									        mapSet.getValue().getProductPrice();
				writer.write(productPriceDetails);
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
