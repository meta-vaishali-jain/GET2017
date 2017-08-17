package view;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import controller.Controller;
import model.OrderedProductDetails;
import model.ProductDetails;

/**
 * ClassName   : DisplayOutput
 * @author     : Vaishali Jain
 * Description : class performing all output display related operations
 */
public class DisplayOutput {
	private static DisplayOutput displayOutput;
	private DisplayOutput(){
		
	}
	//to make class singleton
	public static DisplayOutput getInstance(){
		if (displayOutput == null){
		//synchronized(Controller.class){
				if(displayOutput == null){
					displayOutput = new DisplayOutput();
				}
			}
		//}
		return displayOutput;
	}
	
    //display menu
	public void displayMenu(ArrayList<MenuItem> menu){
		System.out.println("\nchoose from options:\n");
		for(MenuItem menuItem:menu){
			System.out.println(menuItem.getMenuItemOption()+" "+menuItem.getMenuItemName());
		}
	}
	
	//display product List
	public void displayProducts(HashMap<Integer,ProductDetails> productDetailsList){
		System.out.println("\nProduct ID\t  Product Type\t  ProductName\tProductCost");
		for(Map.Entry<Integer,ProductDetails> mapSet :productDetailsList.entrySet()){
			System.out.println( mapSet.getValue().getProductID()+"\t\t "+
								   mapSet.getValue().getProductType()+"\t\t"+
								   mapSet.getValue().getProductName()+"\t\t"+
								   mapSet.getValue().getProductPrice().getProductCost());
		}
	}
	
	//display user Cart
	public void displayUserCart(HashMap<ProductDetails,OrderedProductDetails> selectedProducts){
		System.out.println("\nProduct ID\t  Product Type\t  ProductName\t ProductQuantity\t ProductCost");
		for(Map.Entry<ProductDetails,OrderedProductDetails> mapSet :selectedProducts.entrySet()){
			System.out.println(mapSet.getKey().getProductID()+"\t\t"
								+mapSet.getKey().getProductType()+"\t\t"
								+mapSet.getKey().getProductName()+"\t\t"
								+mapSet.getValue().getProductQuantity()+"\t\t"
								+mapSet.getValue().getTotalCost());
		}
	}
	
	//display bill of user order
	public void displayBill(ArrayList<String> bill){
		for(int i=0;i<bill.size();i++){
			System.out.println("\n"+bill.get(i));
		}
	}
	
	//display message
	public void messageHandler(String message){
		System.out.println("\n"+message);
	}
	
}
