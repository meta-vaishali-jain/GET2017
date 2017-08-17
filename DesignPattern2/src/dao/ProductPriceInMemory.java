package dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import model.ProductPrice;

/**
 * ClassName   : ProductPriceInMemory
 * @author     : Vaishali Jain
 * Description : This class is performing read and write operation on ProductPrice file
 * 			   : while reading returning ArayList of ProductPrice
 */
public class ProductPriceInMemory {
	ArrayList<ProductPrice> productsPrice=new ArrayList<ProductPrice>();
	
	//getter and setter for arrayList
	public ArrayList<ProductPrice> getProductsPrice() {
		return productsPrice;
	}

	public void setProductsPrice(ArrayList<ProductPrice> productsPrice) {
		this.productsPrice = productsPrice;
	}
	
	/*
	 * method to read productPrice details from file.
	 */
	public  ArrayList<ProductPrice>  readProductCosts(String fileName){
		BufferedReader reader=null;
		try {
			reader = new BufferedReader(new FileReader(new File(fileName)));
			String productCosts;			
			while((productCosts = reader.readLine()) != null) {
				
				ProductPrice productPriceObject=new ProductPrice(Double.parseDouble(productCosts));
				productsPrice.add(productPriceObject);
				
			}
			return productsPrice;
		}catch(IOException e) {
			e.printStackTrace();
			return productsPrice;
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
	public void writeToFile(ArrayList<ProductPrice>  productsPrice){
		BufferedWriter writer=null;
		try{
			writer= new BufferedWriter(new FileWriter(new File("ProductPrice.txt")));
			for(int i=0;i<productsPrice.size();i++){
				writer.write(productsPrice.get(i).getProductCost()+"");
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
