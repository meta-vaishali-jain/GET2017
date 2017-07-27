package assignment1;

import java.io.*;
/**
 * ClassName ReadFile
 * @author   Vaishali Jain
 * Description class to read data from file
 */

public class ReadFile {
	/**
	 * Description : to count number of lines in the file
	 * @param filepath : Describes path of the file
	 * @return
	 */
	public static int getNoOfLines(String filepath){
		 
		FileInputStream fstream = null;
		BufferedReader bufferedReader = null;
	int numberOfLines=0;
	try{
		 fstream = new FileInputStream(filepath);
		 bufferedReader = new BufferedReader(new InputStreamReader(fstream));
		 
		  while ((bufferedReader.readLine() != null)) {
			  numberOfLines++;
		  }
	}catch(IOException e){
		e.printStackTrace();
	}finally{
		try{
		    fstream.close();
		    bufferedReader.close();
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	return numberOfLines;
}
	/**
	 * Description:this method split the string into string array on the basis of given splitting character
	 * @param textString
	 * @return
	 */
	public static String[] splitLine(String textString){
		String splittedString[]=textString.split(",");
		return splittedString;
		
	}
	
	/**
	 * method to read file and return the array of string containing all the lines of file
	 * @param filepath
	 * @return
	 */
	public static String[] readFile(String filepath){
		FileInputStream fstream = null;
		BufferedReader bufferedReader = null;
		//String to store line of file for iteration of full file
		String fileLine="";
		//fileData is the array of string to store all the lines of the file
	    String fileData[]=new String[getNoOfLines(filepath)];
		try{
			fstream = new FileInputStream(filepath);
			bufferedReader = new BufferedReader(new InputStreamReader(fstream));
			int index=0;
			while ( (fileLine = bufferedReader.readLine() ) != null) {
				fileData[index++]=new String(fileLine);
			}
		}catch(IOException e){
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
	
	/**
	 * Method to read productlist file and return array of ProductDetails
	 * @param filepath
	 * @return
	 */
	public static ProductDetails[] readProductList(String filepath){
        String listOfProduct[]=readFile(filepath); 
        ProductDetails[] productDetails=new ProductDetails[listOfProduct.length];

        //index is for iterating no of lines in file
        for(int index=0;index<listOfProduct.length;index++){
              String productData[]= splitLine(listOfProduct[index]);
              productDetails[index]=new ProductDetails(productData);
        }

        return productDetails;	
    }
	
	/**
	 * method to read productPromotion file and return array of promotion details
	 * @param filepath
	 * @return
	 */
	public static	ProductPromo[] readProductPromo(String filepath){
	     String listOfProductPromo[] = readFile(filepath);	     
	     ProductPromo[] productPromoDetails=new ProductPromo[listOfProductPromo.length];
	     
	     for(int index=0; index < listOfProductPromo.length; index++){
	    	String[] productPromoData = splitLine(listOfProductPromo[index]);	
	    	productPromoDetails[index]= new ProductPromo(productPromoData);    	
	     }
	     
	     return productPromoDetails;	
	}
	
	/**
	 * method to read orderPRomotion file and return array of promotion details
	 * @param filepath
	 * @return
	 */
	public static OrderPromo[] readOrderPromo(String filepath){
	     String listOfOrderPromo[]=readFile(filepath); 
	     OrderPromo[] orderPromoDetails=new OrderPromo[listOfOrderPromo.length];
	     for(int index=0;index<listOfOrderPromo.length;index++){
	    	String orderPromoData[]= splitLine(listOfOrderPromo[index]);
	        orderPromoDetails[index]=new OrderPromo(orderPromoData);
	     }
	     
	     return orderPromoDetails;	
	}
}