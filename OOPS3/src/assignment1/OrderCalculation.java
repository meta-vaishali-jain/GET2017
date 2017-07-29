package assignment1;

import java.util.Scanner;
/**
 * Class Name:MainNewMenu
 * @author : Vaishali Jain
 * Description: 
 */
public class OrderCalculation implements Action {
	//variables to generate bills
	private static double subTotal=0;
	private static double productLevelDiscount=0;
	private static double finalPrice=0;
	private static double orderLevelDiscount=0;
	private static int  numberOfProducts=0;
	
	
	//to get noOfProducts user want to enter
	public static void noOfProducts(){
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter number of products");
		OrderCalculation.numberOfProducts=scanner.nextInt();
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
		noOfProducts();
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

	@Override
	public void performAction() {
		ProductPromo[] productPromoDetails=ReadFile.readProductPromo("ProductPromo.csv");
		ProductDetails[] productDetails=ReadFile.readProductList("ProductDetails.csv");
		OrderPromo[] orderPromoDetails=ReadFile.readOrderPromo("OrderPromo.csv");
		OrderProductDetails[] orderProductDetails=Input(productDetails);
		printCustomerOrder(orderProductDetails);
		printProductDiscounts(orderProductDetails, productPromoDetails);
		printOrderDiscount(orderPromoDetails);
		printTotalBill();
		
	}
}
