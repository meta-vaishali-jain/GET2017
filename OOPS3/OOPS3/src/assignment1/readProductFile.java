package assignment1;

import java.io.*;
import java.util.Arrays;

public class readProductFile {
	 ProductDetails product[];
	 
		FileInputStream fstream = null;
		BufferedReader bufferedReader = null;

	 
    //method to split string into string array 
	String[] splitLine(String textString){
		String productData[]=textString.split(",");
		return productData;
		
	}
	//method to read number of lines in file
	int getNoOfLines(String filepath){
		int noOfLines=0;
		try{
			 fstream = new FileInputStream(filepath);
			 bufferedReader = new BufferedReader(new InputStreamReader(fstream));
			  String str = "";
			  while ((str = bufferedReader.readLine()) != null) {
				  noOfLines++;
			  }
		}catch(Exception e){
			System.out.println(e.getMessage());
		}finally{
			try{
			 fstream.close();
			  bufferedReader.close();
			}catch(IOException e){
				e.printStackTrace();
			}
		}
		return noOfLines;
	}
	
	//to read file
    public String[] readFile(String filepath){
    	  String fileData[]=new String[getNoOfLines(filepath)];
		try{
			fstream = new FileInputStream(filepath);
			bufferedReader = new BufferedReader(new InputStreamReader(fstream));
			String str="";
			
			int index=0;
			while ( (str = bufferedReader.readLine() ) != null) {
				fileData[index++]=new String(str);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				 fstream.close();
				  bufferedReader.close();
				}catch(IOException e){
					e.printStackTrace();
				}
			}
		return fileData;
	}
	
	//read product list from product detail file
	ProductDetails[] readProduct(String filepath){
     String listOfProduct[]=readFile(filepath); 
     ProductDetails[] productDetails=new ProductDetails[listOfProduct.length];
     for(int index=0;index<listOfProduct.length;index++){
    	String productData[]= splitLine(listOfProduct[index]);
        productDetails[index]=new ProductDetails(productData);
     }
     
     return productDetails;	
}
	
	//read productpromo list from product detail file
	public	ProductPromo[] readProductPromo(String filepath){
	     String listOfProductPromo[] = readFile(filepath); 
	     
	     ProductPromo[] productPromoDetails=new ProductPromo[listOfProductPromo.length];
	     
	     for(int index=0; index < listOfProductPromo.length; index++){
	    	String[] productPromoData = splitLine(listOfProductPromo[index]);
	        
	    	
	    	
	    	productPromoDetails[index]= new ProductPromo(productPromoData);
	    	
	     }
	     
	     return productPromoDetails;	
	}
		
	//read orderPromo list from product detail file
		public OrderPromo[] readOrderPromo(String filepath){
	     String listOfOrderPromo[]=readFile(filepath); 
	     OrderPromo[] orderPromoDetails=new OrderPromo[listOfOrderPromo.length];
	     for(int index=0;index<listOfOrderPromo.length;index++){
	    	String orderPromoData[]= splitLine(listOfOrderPromo[index]);
	        orderPromoDetails[index]=new OrderPromo(orderPromoData);
	     }
	     
	     return orderPromoDetails;	
	}
}