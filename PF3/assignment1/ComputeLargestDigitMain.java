package assignment1;
import java.util.Scanner;
/**
 * Class Name : ComputeGCDMain
 * @author    : Vaishali Jain
 * Description : Main Class
 */
   public class ComputeLargestDigitMain {
	   int numberOne;
	   /**
	   * Method to get input from user
	   */
	  void getInputFromUser(){
		 System.out.println("Enter Number");
		 Scanner sc=new Scanner(System.in);
		 numberOne=sc.nextInt();
	   }
	public static void main(String args[]){
	   ComputeLargestDigitMain mainObject=new ComputeLargestDigitMain();
	   ComputeLargestDigit digit=new ComputeLargestDigit();
	   mainObject.getInputFromUser();
	   System.out.println(digit.getLargestDigit(mainObject.numberOne));
	   ComputeLargestDigitTestRunner runner=new ComputeLargestDigitTestRunner();
		runner.TestRunner();
		}
	}



