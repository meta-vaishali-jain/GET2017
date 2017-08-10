
package assignment1;

import java.awt.*;
import java.awt.event.*;
import java.applet.*;

/**
 * @class	Layout
 *  extends Applet: utility program performing simple functions
 *  implements ActionListener
 * */
public class calculatorLayout extends Applet implements ActionListener{
	/**
	 * Screen components
	 * */
	TextField input;
	
	Button[] buttonDigit = new Button[10];
	Button buttonAdd, subtract, multiply, divide, modulas, squareRoot, power, clear, evaluate;

	char operation_to_perform;
	
	/**@Method	init()
	 * initial layout of calculator application
	 * panels, buttons, text box placement on screen
	 * @return	type = void, create display
	 * */
	public void init() {
		GridLayout grid=new GridLayout();
		setLayout(grid);
		
		add(buttonAdd);
		buttonAdd.addActionListener(this);
	}
	
	/**@Method	 actionPerformed(ActionEvent event)
	 * implementation from ActionListner interface
	 * The ActionEvent parameter is an Event object that represents an event (a button click).
	 * @param	ActionEvent event (event of button click)
	 * add a listener to every button in panel
	 * listener calls Operation class method to execute said operation\
	 * @return	type = void, performs event handling
	 * **/
	public void actionPerformed(ActionEvent event) {
		
		/** call calculator method to perform event handling*/
		Calculator actionToPerform = new Calculator();
		actionToPerform.displayResult();
		
		// display the calculated result in text field
	}
}
