package facade;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import controller.Controller;
import dao.ProductDetailsInMemory;
import dao.ProductPriceInMemory;
import model.OrderedProductDetails;
import model.*;
import model.UserCart;

/**
 * ClassName   : CartOperations
 * @author     : Vaishali Jain
 * Description : Class Performing all the operations on the cart like add , delete,update amd view cart i.e performing all business logics.
 */
public class CartOperations {
	
	private static CartOperations cartOperationsObject=null;
	private static HashMap<ProductDetails,OrderedProductDetails> selectedProducts;
	private HashMap<Integer,ProductDetails> productDetails;
	ProductDetailsInMemory productDetailsInMemory=new ProductDetailsInMemory();
	ProductPriceInMemory productPriceInMemory=new ProductPriceInMemory();
	Controller controller;
	UserCart userCart=new UserCart();
	
	private CartOperations(){
		
		
		productDetails=productDetailsInMemory.readProductDetails("ProductDetails.txt");
		selectedProducts=userCart.getSelectedProducts();
		
		
	}
	
	/*
	 * getter of the constructor to get the instance of the object,to make singleton class
	 */
	public static CartOperations getInstance(){
		if(cartOperationsObject==null){
			//synchronized(CartOperations.class){
				if(cartOperationsObject==null){
					cartOperationsObject=new CartOperations();
				}
			}
		//}
		return cartOperationsObject;
	}
	
	//getters and setters
	public static HashMap<ProductDetails, OrderedProductDetails> getSelectedProducts() {
		return selectedProducts;
	}

	public static void setSelectedProducts(HashMap<ProductDetails, OrderedProductDetails> selectedProducts) {
		CartOperations.selectedProducts = selectedProducts;
	}

	
	public HashMap<Integer, ProductDetails> getProductDetails() {
		return productDetails;
	}

	public void setProductDetails(HashMap<Integer, ProductDetails> productDetails) {
		this.productDetails = productDetails;
	}
    
	/**
	 * method to display product list
	 * it return productDetails list to the displayOutput class function
	 * @return
	 */
	public 	HashMap<Integer,ProductDetails> displayProductList(){
		return productDetails;
	}
	
	/**
	 * method to check is enter productID exist in ptoductDetails list or not
	 * @param productID
	 * @return
	 */
	public boolean isProductInProductDetails(int productID){
		if(productDetails.containsKey(productID)){
			return true;
		}
		return false;
	}
	
	/**
	 * method to check is enter productID exist in UserCart or not
	 * @param productDetails
	 * @return
	 */
	public boolean isProductInCart(ProductDetails productDetails){
		if(selectedProducts.containsKey(productDetails)){
			return true;
		}
		return false;
	}
	
	/**
	 * method to check if cart is empty or not
	 * @return
	 */
	public boolean isCartEmpty(){
		if(selectedProducts.size()==0)
			return true;
		else
			return false;
	}
	
	/**
	 * method to add product to the cart on the basis of user input product id and quantity to be added
	 * @param productID
	 * @param productQuantity
	 */
	public void addProductToCart(int productID,int productQuantity ){
		//check product exist or not
		controller= Controller.getInstance();
		if(isProductInProductDetails(productID)){
			double totalProductCost=(productDetails.get(productID).getProductPrice().getProductCost())*productQuantity;
			OrderedProductDetails orderedProductDetails=new OrderedProductDetails(productID, productQuantity, totalProductCost);
			//check if product is already in cart then it will increase the quantity of product by the entered quantity
			if(isProductInCart(productDetails.get(productID))){
				int quantity=selectedProducts.get(productDetails.get(productID)).getProductQuantity();
				quantity+=productQuantity;
				selectedProducts.get(productDetails.get(productID)).setProductQuantity(quantity);	
			}
			//if product is not already in cart then add that to cart
			else{	
				selectedProducts.put(productDetails.get(productID), orderedProductDetails);
				userCart.setSelectedProducts(selectedProducts);
			}
			controller.messageHandler("Product Added successfully in cart");
		}
		else{
			System.out.println("Product not exist");
			return;
		}
	}
	
	/**
	 * method to delete product from cart
	 * @param productID
	 */
	public void deleteProductFromCart(int productID){
		//check if cart is already empty
		controller= Controller.getInstance();
		if(isCartEmpty()){
			controller.messageHandler("Cart Empty nothing to delete");
			return;
		}
		//check if product in product list or not
		if(isProductInProductDetails(productID)){
			//to check if product to be deleted is in list or not
			if(isProductInCart(productDetails.get(productID))){
				selectedProducts.remove(productDetails.get(productID));
				controller.messageHandler(productID+"deleted successfully");
			}
			else{
				controller.messageHandler("Product Not In Cart");
			}
		}
		else{
			controller.messageHandler("Product Does Not Exist");
		}
	}
	
	/**
	 * Method to get cart of the user
	 * @return
	 */
	public HashMap<ProductDetails, OrderedProductDetails> getCart(){
		controller= Controller.getInstance();
		if(isCartEmpty()){
			controller.messageHandler("Cart is Empty");
		}
		return selectedProducts;
	}
	
	/**
	 * Method to update the cart
	 * @param productID
	 * @param productQuantity
	 */
	public void updateProductCart(int productID,int productQuantity){
		//check product exist or not
		controller= Controller.getInstance();
		if(isProductInProductDetails(productID)){
			//check product is in cart or not ,if exist then update it
			if(isProductInCart(productDetails.get(productID))){
				selectedProducts.get(productDetails.get(productID)).setProductQuantity(productQuantity);
				controller.messageHandler(productID+" Updated Successfully with Quantity "+productQuantity);
			}
			else{
				controller.messageHandler("Product Not In Cart");
			}
		}
		else{
			controller.messageHandler("Product Does Not Exist");
		}
	}
	
	/**
	 * method to get bill and return the list of bill
	 * @return
	 */
	public ArrayList<String> getBill(){
		ArrayList<String> bill =new ArrayList<String>();
		bill.add("#########################################################################################");
		bill.add("                                        Your Bill                                        ");
		bill.add("#########################################################################################");
		bill.add("Product ID      Product Type      Product Name       Quantity");
		double finalCost=0;
		for(Map.Entry<ProductDetails, OrderedProductDetails> mapSet:selectedProducts.entrySet()){
			finalCost+=mapSet.getValue().getTotalCost();
			bill.add(mapSet.getKey().getProductID()+"\t\t"+mapSet.getKey().getProductType()+"\t"+mapSet.getKey().getProductName()+"\t\t"+mapSet.getValue().getProductQuantity());
		}
		bill.add("###########################################################################################");
		bill.add("                                   Individual Product Cost                                 ");
		bill.add("Product ID          Product Name       Total Cost");
		for(Map.Entry<ProductDetails, OrderedProductDetails> mapSet:selectedProducts.entrySet()){
			bill.add(mapSet.getKey().getProductID()+"\t"+mapSet.getKey().getProductName()+"\t\t"+mapSet.getValue().getTotalCost());
		}
		bill.add("############################################################################################");
		bill.add("                                     Total Cost                                             ");
		bill.add("############################################################################################");
		bill.add("Total Price: "+ finalCost);
		return bill;
		
	}
}
