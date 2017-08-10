package assignment1;

import java.awt.TextField;
/**
 * ClassName calculatorDisplay
 * @author user11
 * Display of calculator
 */

public class calculatorDisplay {
	/**
	 * clear display TextField
	 * */
	public void clear() {
		
	}
	
	/**
	 * when result is calculated, display onto TextField value computed
	 * Insert result onto text field and layout displays it onto screen
	 * */
	public void displayOutput(Number result) {

		// output = result
		//pass output to layout
		
		calculatorLayout layout = new calculatorLayout();
		TextField output = new TextField(result.toString());		
	}
}
