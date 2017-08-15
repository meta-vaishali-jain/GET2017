import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import Facade.ProductFacade;
import Model.ProductDetails;
import Model.ProductPrice;

/**
 * ClassName   :Controller
 * @author     :Vaishali Jain
 * Description :Controller class contains all the methods based on the menu which a program is performing 
 */
public class Controller implements Action  {
	
	// Facade class object
	static ProductFacade productFacadeObject=ProductFacade.getInstance();
	
	/*
	 * method to update the file and inmemory based on the productID
	 */
	public static void updateFile(String productID){
		Scanner inputScanner=new Scanner(System.in);
		System.out.println("Enter product type");
		String productType=inputScanner.next();
		//to check enter value is not null or empty
		while(!productFacadeObject.isNotNull(productType)){
			System.out.println("Enter valid product type");
			productType=inputScanner.next();
		}
		System.out.println("Enter product name");
		String productName=inputScanner.next();
		//to check enter value is not null or empty
		while(!productFacadeObject.isNotNull(productName)){
			System.out.println("Enter valid product name");
			productType=inputScanner.next();
		}
		
		ProductDetails productDetailsObject=new ProductDetails(Integer.parseInt(productID), productType, productName);
		
		System.out.println("Enter the cost to update");
		String cost=inputScanner.next();
		while(!productFacadeObject.isValidEntity(cost)){
			System.out.println("Enter a valid cost");
			cost=inputScanner.next();
		}
		ProductPrice productPriceObject=new ProductPrice(Integer.parseInt(productID),Double.parseDouble(cost));
		productFacadeObject.updateDetails(productDetailsObject,productPriceObject);
		
	}
	
	/*
	 * method to get productID from user
	 */
	public static String getProductIDFromUser(){
		Scanner inputScanner=new Scanner(System.in);
		String productID=inputScanner.next();
		return productID;
	}
	
	/**
	 * method to update existing product in the product list
	 */
	public static void updateValues(){
		System.out.println("Enter Product ID For Details Updation");
		String productID=getProductIDFromUser();
		if(!productFacadeObject.isValidId(productID)){
			System.out.println("No Product id exist for updation ");
			return;
		}
		updateFile(productID);
	}
	
	/**
	 * method to add new product in the product list
	 */
	public static void addProduct(){
		System.out.println("Enter Product ID To add in Product list");
		String productID=getProductIDFromUser();
		while(!productFacadeObject.isValidEntity(productID)){
			System.out.println("Enter id in correct form");
			productID=getProductIDFromUser();
		}
		if(productFacadeObject.isValidId(productID)){
			System.out.println("Product Already in list");
			return;
		}
		else{
			updateFile(productID);
		}
		
	}
	
	/**
	 * method to display all the products and its corresponding details
	 */
	public static void productDetailsDisplay(){
		productFacadeObject.retrieveValues();
		HashMap<Integer,ProductDetails> productDetailsList=productFacadeObject.getProductDetailsList();
		System.out.println("Product ID\tProduct Type\tProduct Name");
		for(Map.Entry<Integer,ProductDetails> mapSet :productDetailsList.entrySet()){
			System.out.println( mapSet.getValue().getProductCode()+"\t\t"+
								   mapSet.getValue().getProductType()+"\t\t"+
								   mapSet.getValue().getProductName());
		}
			HashMap<Integer,ProductPrice> productPriceList=productFacadeObject.getProductPriceList();
			System.out.println("\n");
			System.out.println("Product ID\tProduct Price");
			for(Map.Entry<Integer,ProductPrice> mapSett :productPriceList.entrySet()){
				System.out.println(mapSett.getValue().getProductID()+"\t\t"+
									        mapSett.getValue().getProductPrice());			
	}
			System.out.println("\n");
	}
	
	public void exit() {
		System.exit(0);
	}

	
	//switch case to perform suitable action
	@Override
	public void performAction(int choice) {
		// TODO Auto-generated method stub
		productFacadeObject.retrieveValues();
		 switch(choice){
		 case 1: Controller.productDetailsDisplay();
		         break;
		 case 2: Controller.addProduct();
		 		 break;
		 case 3: Controller.updateValues();
		         break;
		 case 4: exit();
		         break;
		         
		 }		
	}
	}