package assignment1;

import java.util.Scanner;
/**
 * Class Name : ComputeRemainderMain
 * @author    : Vaishali Jain
 * Description : Main Class
 */

public class ComputeRemainderMain {
	int dividend;
	int divisor;
	/**
	 * Method to get input from user
	 */
	void getInputFromUser(){
		System.out.println("Enter Dividend and Divisor");
		Scanner sc=new Scanner(System.in);
		dividend=sc.nextInt();
		divisor=sc.nextInt();
	}
	public static void main(String args[]){
		ComputeRemainderMain mainObject=new ComputeRemainderMain();
		ComputeRemainder remainder=new ComputeRemainder();
		mainObject.getInputFromUser();
		System.out.println(remainder.getRemainder(mainObject.dividend,mainObject.divisor));
		ComputeRemainderTestRunner runner=new ComputeRemainderTestRunner();
		runner.TestRunner();
	}
}
