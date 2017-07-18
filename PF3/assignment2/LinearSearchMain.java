package assignment2;
import java.util.Scanner;

import assignment1.ComputeLargestDigit;
import assignment1.ComputeLargestDigitMain;
/**
 * Class Name : LinearSearchMain
 * @author    : Vaishali Jain
 * Description : Main Class
 */
public class LinearSearchMain {
	   int lengthOfArray;
	   int array[];
	   int elementSearch;
	   /**
	   * Method to get input from user
	   */
	  void getInputFromUser(){
		  //length of array
		 System.out.println("Enter Length of array");
		 Scanner sc=new Scanner(System.in);
		 lengthOfArray=sc.nextInt();
		 array =new int[lengthOfArray];
		 //array
		 System.out.println("Enter Array");
		 for(int i=0;i<lengthOfArray;i++){
			 array[i]=sc.nextInt();
		 }
		 //search element
		 System.out.println("Enter Element to be search");
		 elementSearch=sc.nextInt();
	  }
	public static void main(String args[]){
	   LinearSearchMain mainObject=new LinearSearchMain();
	   LinearSearch searchElement=new LinearSearch();
	   mainObject.getInputFromUser();
	   System.out.println(searchElement.linearArraySearch(mainObject.array,mainObject.elementSearch));
	   LinearSearchTestRunner runner=new LinearSearchTestRunner();
	   runner.TestRunner();
		}
	}


