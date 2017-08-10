package assignment1;
/**
 * ClassName Calculator
 * @author   Vaishali Jain
 * class takes operator and operand as input and display result
 */

public class Calculator {
	protected int result;
	protected int firstNumber;
	protected int secondNumber;
	protected char operator;

	public Calculator() {
		
	}
	
	
	public Calculator(int firstNumber, int secondNumber, char operator){
		this.firstNumber=firstNumber;
		this.secondNumber=secondNumber;
		this.operator = operator; 
	}
	

	/**@Method	calculate()
	 * Input numbers and operator is passed to Calculator class
	 * by event handling at Layout ActionListner (button click)
	 * When '=' operator is pressed
	 * expression must be evaluated
	 * */
	public Number calculate(){
		return new calculatorOperations().evaluate(firstNumber, secondNumber, operator);
	}
	
	/**@Method displayResult()
	 * Follows the hierarchy of calling Operations to evaluate result
	 * Then to Display result
	 * Then to Layout class
	 * to print onto screen
	 * */
	public void displayResult() {
		calculatorDisplay printResult = new calculatorDisplay();
		
		printResult.displayOutput(calculate());
		
	}
}
