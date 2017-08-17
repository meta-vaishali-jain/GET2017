package view;

import java.util.Scanner;
import controller.Controller;

/**
 * ClassName   : GetInput
 * @author     : Vaishali Jain
 * Description : class containing methods to get input from user.
 */
public class GetInput {
	private static GetInput getInput;
	Scanner inputScanner=new Scanner(System.in);
	private GetInput(){	
	}
	//make class singleton
	public static GetInput getInstance(){
		if (getInput == null){
		//synchronized(Controller.class){
				if(getInput == null){
					getInput = new GetInput();
				}
			}
		//}
		return getInput;
	}
	
	//get choice of menu from user
	public String getChoice(){
		System.out.println("Enter your choice");
		String choice=inputScanner.next();
		
		return choice;
	}
	
	//get productID from user
	public String getProductID(){
		System.out.println("Enter Product ID: ");
		String productID=inputScanner.next();
		return productID;
	}
    
	//get quantity from user
	public String getProductQuantity(){
		System.out.println("Enter Product Quantity: ");
		String productQuantity=inputScanner.next();
		return productQuantity;
	}
	
	
}
