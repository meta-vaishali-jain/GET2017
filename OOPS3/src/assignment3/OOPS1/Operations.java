package assignment3.OOPS1;

/**
 * ClassName    : Operations
 * @author      : Vaishali Jain
 * Description  : perform different functioning of calculator
 */
public class Operations {

	/**
	 * method performiong function depending upon the input
	 * @param firstNum
	 * @param secondNum
	 * @param operator
	 * @return result for further calculation if any
	 */
	public int evaluate(int firstNum, int secondNum, char operator)
	{
		switch(operator)
		{
			case '+':
				return firstNum + secondNum;
			case '-':
				return firstNum - secondNum;
			case '*':
				return firstNum * secondNum;
			case '/':
				return firstNum / secondNum;
			/*
			 *  other operators 
			 *  logarithmic 
			 *  percentage etc. 
			 *  other functionalities can be extended
			 */
			default:	
				return firstNum;
		}
	}
}
