package assignment1;

import java.util.Scanner;
/**
 * Class Name : ComputeGCDMain
 * @author    : Vaishali Jain
 * Description : Main Class
 */

public class ComputeGCDMain {
		int numberOne;
		int numberTwo;
		/**
		 * Method to get input from user
		 */
		void getInputFromUser(){
			System.out.println("Enter Two Numbers");
			Scanner sc=new Scanner(System.in);
			numberOne=sc.nextInt();
			numberTwo=sc.nextInt();
		}
		public static void main(String args[]){
			ComputeGCDMain mainObject=new ComputeGCDMain();
			ComputeGCD divisor=new ComputeGCD();
			mainObject.getInputFromUser();
			System.out.println(divisor.greatestCommonDivisor(mainObject.numberOne,mainObject.numberTwo));
			ComputeGCDTestRunner runner=new ComputeGCDTestRunner();
			runner.TestRunner();
		}
	}


