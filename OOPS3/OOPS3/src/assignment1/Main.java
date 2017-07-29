package assignment1;

import java.util.Arrays;

public class Main {
	public static void main(String args[]){
		readProductFile file=new readProductFile();
	
		ProductDetails product[]= file.readProduct("ProductDetails.txt");
	
		System.out.println("ProductID \t\t\t ProductName \t\t\t ProductPrice");
		for(int index=0;index<product.length;index++){
			System.out.println(product[index].getProductID()+"\t\t\t"+product[index].getProductName()+"\t\t\t"+product[index].getProductPrice());
		}
	
		ProductPromo productPromo[]=file.readProductPromo("ProductPromotions.txt");
		
		
		
		System.out.println("PromotionType \t\t\t Discount \t\t\t ProductsApplicable");
		for(int indexo=0;indexo<productPromo.length;indexo++){
			System.out.println(productPromo[indexo].getPromotionType()+"\t\t\t"+productPromo[indexo].getDiscount()+"\t\t\t"+ Arrays.toString(productPromo[indexo].getProductId()));	 
		}
	}
}

