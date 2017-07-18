package assignment1;
/**
 * Class Name : ComputeGCD
 * @author    : Vaishali Jain
 * Description: Computes greatest common divisor for two numbers
 */

public class ComputeGCD {
	/**
	 * Method which returns greatest common divisor for two numbers using recursion and also use 
	 * getRemainder() method of class ComputeRemainder
	 * @param firstNumber
	 * @param secondNumber
	 * @return
	 */
   public int greatestCommonDivisor(int firstNumber,int secondNumber){
	   ComputeRemainder remainder=new ComputeRemainder();
	   //Throws exception if number is negative
	   if(firstNumber<0 | secondNumber<0){
		throw new IllegalArgumentException();	
	   }
	   //If second number is 0 then return first number
	   if(secondNumber==0){
	   return firstNumber;
	   }
	   return((firstNumber==0)? secondNumber:greatestCommonDivisor(secondNumber,remainder.getRemainder(firstNumber,secondNumber)));
 }
}
	


