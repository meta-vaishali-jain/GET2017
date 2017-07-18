package assignment1;
/**
 * Class Name  : ComputeRemainder
 * @author     : Vaishali Jain
 * Description : returns remainder and compute it using recursion
 */

public  class ComputeRemainder {
	/**
	 * This method returns remainder where argument is dividend and divisor
	 * @param dividend
	 * @param divisor
	 * @return
	 */
	  public int getRemainder(int dividend,int divisor){
		    //throws exception if dividend is less than 0 or divisor is less than or equal to 0
			if(dividend<0 | divisor<=0){
				throw new IllegalArgumentException();
			}
			//check condition due to problem of stack overflow for large number
			//There is recursion to compute remainder
			return((dividend<=70000) ? ((dividend<divisor) ?  dividend : (getRemainder((dividend-divisor),divisor)))
					                 :((dividend<divisor) ?  dividend :(dividend-divisor)%divisor));
		 }
}
