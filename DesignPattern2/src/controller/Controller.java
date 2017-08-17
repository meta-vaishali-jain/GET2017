package controller;

import java.util.ArrayList;

import java.util.HashMap;
import view.DisplayOutput;
import view.GetInput;
import model.OrderedProductDetails;
import model.ProductDetails;
import facade.CartOperations;

/**
 * ClassName   : Controller
 * @author     : Vaishali Jain
 * Description : Controller class is selecting action to be performed on the basis of user choice and performing that operation
 * 			   : Provide validations on the user input.
 */
public class Controller {
	
	private static Controller controller;
	DisplayOutput displayOutput=null;
	CartOperations cartOperationsFacade=null;
	GetInput getInput= null;
	
	
	private Controller(){
		//getting instance of singleton class object
		
		 displayOutput=DisplayOutput.getInstance();
		 cartOperationsFacade=CartOperations.getInstance();
		 getInput= GetInput.getInstance();
	    
	}
	
	//to make class singleton
	public static Controller getInstance(){
		if (controller == null){
	//	synchronized(Controller.class){
				if(controller == null){
					controller = new Controller();
				}
			}
		//}
		return controller;
	}
	
	/**
	 * method to select response on the basis of user choice what action to perform
	 * @param choice
	 */
	public void selectResponse(String choice){
		//check entered choice is valid or not
		if(isValidChoice(choice)){
			String productID;
			String productQuantity;
			
			switch(Integer.parseInt(choice)){
			//Display Product List
			case 1:	HashMap<Integer,ProductDetails> productDetailsList=cartOperationsFacade.displayProductList();
					displayOutput.displayProducts(productDetailsList);
					break;
			//Add Product to Cart
			case 2:	 productID=getInput.getProductID();
					while(!isNumber(productID)){
						productID=getInput.getProductID();
					}
					 productQuantity=getInput.getProductQuantity();
					while(!isNumber(productQuantity)){
						productQuantity=getInput.getProductQuantity();
					}
					cartOperationsFacade.addProductToCart(Integer.parseInt(productID),Integer.parseInt(productQuantity));
					break;
			//Delete Product from Cart
			case 3:	productID=getInput.getProductID();
					while(!isNumber(productID)){
						productID=getInput.getProductID();
					}
					cartOperationsFacade.deleteProductFromCart(Integer.parseInt(productID));
					break;
			//Update Product of Cart
			case 4:	productID = getInput.getProductID();
					while (!isNumber(productID)) {
						productID = getInput.getProductID();
					}
					 productQuantity = getInput.getProductQuantity();
					while (!isNumber(productQuantity)) {
					productQuantity = getInput.getProductQuantity();
					}
					cartOperationsFacade.updateProductCart(Integer.parseInt(productID), Integer.parseInt(productQuantity));
					break;
			//Display User Cart
			case 5:	HashMap<ProductDetails, OrderedProductDetails> selectedProducts=cartOperationsFacade.getCart();
					displayOutput.displayUserCart(selectedProducts);
					break;
			//Generate Bill and display it
			case 6: ArrayList<String> bill= cartOperationsFacade.getBill();
			        displayOutput.displayBill(bill);
			//Exit
			case 7:	System.exit(0);
					break;
			
			}
		}
	}
	
	/**
	 * method to check enter input is in number format or not
	 * @param choice
	 * @return
	 */
	public boolean isNumber(String choice){
		try{
			int parsedChoice=Integer.parseInt(choice);
		}catch(NumberFormatException e){
			return false;
		}
		return true;
	}
	
	/**
	 * method to check enter input is correct or not
	 * @param choice
	 * @return
	 */
	public boolean isValidChoice(String choice){
		if(isNumber(choice)){
			if(Integer.parseInt(choice)<0||Integer.parseInt(choice)>7){
				return false;
			}
			return true;
		}
		return false;
	}
	
	/**
	 * method to display any message
	 * @param message
	 */
	public void messageHandler(String message){
		displayOutput.messageHandler(message);
	}
}

