package assignment1;

import java.util.Scanner;
/**
 * Class Name:MainNewMenu
 * @author : Vaishali Jain
 * Description: 
 */
public class MainNewMenu {
	//variables to generate bills
	private static double subTotal=0;
	private static double productLevelDiscount=0;
	private static double finalPrice=0;
	private static double orderLevelDiscount=0;
	private static int  numberOfProducts=0;
	//menu of actions to be taken
	void menu(){
		System.out.println("Enter what you want to do\n"
	            +"1. To see Product list\n"
	            +"2. To see Product based Promotion\n"
	            +"3. To see Order based Promotion\n"
	            +"4. To place Order\n"
	            +"5. To see our Order\n"
	            +"6. To see Applicable Discount on order\n"
	            +"7. To generate bill\n"
	            
	            );
	}
	
	//to get noOfProducts user want to enter
	public static void noOfProducts(){
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter number of products");
		MainNewMenu.numberOfProducts=scanner.nextInt();
		//for validation
		while(!Validation.checkOrderSize(numberOfProducts)){
			System.out.println("Wrong input");
			System.out.println("Enter again");
			numberOfProducts=scanner.nextInt();
		}
	}
	
	/**
	 * Method to get product id from user
	 * @param productDetails
	 * @return
	 */
	public static int enterProductID(ProductDetails[] productDetails){
		
		System.out.println("Enter ProductID");
		int id=scannerInputInt();
		while(!Validation.checkProductID(id,productDetails)){
			System.out.println("Wrong input");
			System.out.println("Enter again");
			id=scannerInputInt();
		}
		return id;
	}
	
	/**
	 * Method to get product quantity from user
	 * @return
	 */
    public static int enterProductQuantity(){
		
		System.out.println("Enter Product Quantity");
		int quantity=scannerInputInt();
		while(!Validation.checkQuantitySize(quantity)){
			System.out.println("Wrong input");
			System.out.println("Enter again");
			quantity=scannerInputInt();
		}
		return quantity;
	}
	
	/**
	 * method to get order from user  and store that in orderProductDetails array
	 * @param productDetails
	 * @return
	 */
	
	public static OrderProductDetails[] Input(ProductDetails[] productDetails){
		Scanner scanner=new Scanner(System.in);
		
		OrderDetails userOrderDetails[]=new OrderDetails[numberOfProducts];
		OrderProductDetails userOrderProductDetails[]=new OrderProductDetails[numberOfProducts];
		
		for(int index=0;index<numberOfProducts;index++){
			userOrderDetails[index]=new OrderDetails();
			int productID=enterProductID(productDetails);
			userOrderDetails[index].setOrderProductId(productID);
			
			int quantity=enterProductQuantity();
			userOrderDetails[index].setOrderProductQuantity(quantity);
			
			userOrderProductDetails[index]=new OrderProductDetails();
			userOrderProductDetails[index].setValues(userOrderDetails[index], productDetails);
			
		}
		return userOrderProductDetails;
		
	}
	
	/**
	 * method to print available discounts on user order
	 * @param userOrderProductDetails
	 * @param productPromo
	 */
	public static void printProductDiscounts(OrderProductDetails[] userOrderProductDetails,ProductPromo[] productPromo){
		System.out.println("\nAPPLIED PROMOTIONS/DISCOUNTS :\n");
		for(OrderProductDetails orderNo : userOrderProductDetails) {
			if(orderNo.isApplicableForProductPromotion(productPromo)) {
				double discount = orderNo.getDiscount(productPromo);
				double discountAmount = orderNo.calculateDiscount(productPromo);

				System.out.println("Promotion: "+ discount + " off on "+ orderNo.getProductName() + " [Code: " + orderNo.getProductID()+"]");
				System.out.println("Discount : "+ discountAmount + "\n");
				
				productLevelDiscount+=discountAmount;
			}
		}
		finalPrice=subTotal-productLevelDiscount;
	}
	/**
	 * Method to print order based discount value based on user order
	 * @param orderPromo
	 */
	public static void printOrderDiscount(OrderPromo[] orderPromo){
		
		
		double maxDiscount=0;
		OrderPromo temporary=new OrderPromo();
		for(OrderPromo productIndex:orderPromo){
			if(productIndex.getThreshHoldValue()<finalPrice){
				double discount = productIndex.getDiscount();
				double currentDiscount=Promotion.isPercentPromotion(productIndex) ? finalPrice*discount/100.0 : discount;
				if(maxDiscount<currentDiscount){
					maxDiscount=currentDiscount;
					temporary=productIndex;
				}
			}
		}	
		System.out.println("Promotion: "+ temporary.getDiscount()+ " off on orders above"+ temporary.getThreshHoldValue()+")");
		System.out.println("Discount : "+ maxDiscount + "\n");
		orderLevelDiscount=maxDiscount;
		finalPrice-=maxDiscount;	
		}
	
	/**
	 * ClassName: to print customer order
	 * @param userOrder
	 */
	public static void printCustomerOrder(OrderProductDetails[] userOrder){
		System.out.println("\n\n\n");
		System.out.println("#################################################");
		System.out.println("Your Order");
		System.out.println("#################################################");
		System.out.println("\n\n");
		System.out.println("Purchased Products");
		
		for(OrderProductDetails orderNo : userOrder){
			System.out.println("Product:"+orderNo.getProductID()+"-"+orderNo.getProductName());
			System.out.println("Cost :" + orderNo.getOrderTotalPrice()+"("+orderNo.getProductQuantity()+"*"+orderNo.getCostPrice()+")");
			subTotal+=orderNo.getOrderTotalPrice();
		}
	}
	
static	int scannerInputInt(){
		Scanner scInput=new Scanner(System.in);
		return scInput.nextInt();
	}
	
	char scannerInputChar(){
 		Scanner scInput=new Scanner(System.in);
 		return scInput.next().charAt(0);
 	}
	
	public static void printTotalBill() {
		System.out.println("Sub Total:\t\t"				+ subTotal + "\n"
						 + "Product Level Discounts:\t" + productLevelDiscount +"\n"
						 + "Order Level Discounts:\t"   + orderLevelDiscount + "\n"
						 + "Total Discounts: \t"		+ (productLevelDiscount+orderLevelDiscount) + "\n"	
						 + "Total: \t\t"					+ finalPrice);
	}
		
	
	public static void main(String args[]){
	  MainNewMenu mainObject=new MainNewMenu();
	  ReadFile file=new ReadFile();
	  ProductDetails[] productDetails=new ProductDetails[ReadFile.getNoOfLines("ProductDetails.csv")];
	  ProductPromo[] productPromoDetails=new ProductPromo[ReadFile.getNoOfLines("ProductPromo.csv")];
	  OrderPromo[] orderPromoDetails=new OrderPromo[ReadFile.getNoOfLines("OrderPromo.csv")];
	  OrderProductDetails orderProductDetails[]=null;
	                                                                   
	  int choiceOfUser;
	  char choice=0;
	  do{
			
			mainObject.menu();
			choiceOfUser=mainObject.scannerInputInt();
			while(choiceOfUser<=0 || choiceOfUser>8){
				System.out.println("Wrong input");
				mainObject.menu();
			}
			switch(choiceOfUser){
			case 1:
			    productDetails=PrintProductDetails.printProductDetails(file);
			      break;
			case 2:
				 productPromoDetails=PrintProductDetails.printProductPromoDetails(file);
			      break;
			case 3:
				 orderPromoDetails=PrintProductDetails.printOrderPromoDetails(file);
				 break;
			case 4:
				noOfProducts();
				orderProductDetails=new OrderProductDetails[numberOfProducts];
				orderProductDetails=MainNewMenu.Input(productDetails);
				break;
			case 5:
				
				MainNewMenu.printCustomerOrder(orderProductDetails);
				break;
			case 6:
			   MainNewMenu.printProductDiscounts(orderProductDetails,productPromoDetails);
			   MainNewMenu.printOrderDiscount(orderPromoDetails);
				break;
			case 7:
				MainNewMenu.printTotalBill();
				break;
			/*case 8:
				int i;
				int productID=MainNew.enterProductID(productDetails);
				int productID=MainNew.enterProductID(productDetails);
				OrderDetails userOrder[]=new OrderDetails[numberOfProducts++];
				
				for( i=0;i<userOrder.length-1;i++){
					userOrder[i]=new OrderDetails();
					userOrder[i].setOrderProductId(orderProductDetails[i].getProductID());
					userOrder[i].setOrderProductQuantity(orderProductDetails[i].getProductQuantity());
				}
				orderProductDetails=new OrderProductDetails[numberOfProducts];
				userOrder[i]=new OrderDetails();
				userOrder[i].setOrderProductId(productID);
				userOrder[i].setOrderProductQuantity(productQuantity);
				for( i=0;i<userOrder.length;i++){
					orderProductDetails[i]=new OrderProductDetails();
					orderProductDetails[i].setProductID(userOrder[i].getOrderProductId());
					orderProductDetails[i].setProductQuantity(userOrder[i].getOrderProductQuantity());
				}
				break;*/
			}
			System.out.println("Want to go to menu");
			choice=mainObject.scannerInputChar();		
}while(choice=='Y'||choice=='y');
}
}
