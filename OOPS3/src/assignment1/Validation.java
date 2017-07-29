package assignment1;
/**
 * ClassName:Validation
 * @author : Vaishali Jain
 * Description:To check validation
 */
public class Validation {
	public static boolean checkProductID(int productID,ProductDetails productDetails[]){
		boolean flag=false;
		for(int i=0;i<productDetails.length;i++){
			if(productDetails[i].getProductID()==productID){
				flag=true;
			}
		}
		return flag;	
}
	
	public static boolean checkOrderSize(int noOfProducts){
		
		boolean flag=true;
		if(noOfProducts<=0){
			flag=false;
		}
		
		return flag;
	}
	
	public static boolean checkQuantitySize(int quantity){
		boolean flag=true;
		if(quantity<=0){
			flag=false;
		}
		return flag;
	}

}
