package assignment1;
/**
 * Class Name : ComputeLargestDigit
 * @author    : Vaishali Jain
 * Description: Compute largest digit in any number
 */
public class ComputeLargestDigit {
	/**
	 * This method is to find the maximumm number among two numbers
	 * @param numberOne
	 * @param numberTwo
	 * @return
	 */
	public int maximumNumber(int numberOne,int numberTwo){
		return((numberOne>=numberTwo)?numberOne:numberTwo);
	}
	/**
	 * This method is to get largest digit which use maximumNumbe function for comparison
	 * @param number
	 * @return
	 */
	public int getLargestDigit(int number){
		ComputeRemainder remainder=new ComputeRemainder();
		//throws exception if number is less than zero
		if(number<0)
			throw new IllegalArgumentException();
		/*
		 * computing largest digit using recursion by changing number as number=number/10 and computing 
		 * digit as remainder of number and 10;
		 */
		return((number==0)?0:maximumNumber(remainder.getRemainder(number,10),getLargestDigit(number/10)));
	}
}
	


