package assignment1;

import java.awt.Button;
/**
 * ClassName calculatorButton
 * @author Vaishali Jain
 * creates buttons
 */

public class calculatorButton extends Button{
	protected int height, width;
	
	public calculatorButton() {
		height =100;
		width = 100;
	}
	
	/**
	 * Define height and width of what a button should have
	 * */
	public calculatorButton(int height,int width){
		this.height = height;
		this.width = width;
	}
	
	/**
	 * set Button position onto screen
	 * */
	public void setButton(int position) {
		
	}
	
	/**
	 * whether button is available or not
	 * */
	public void enableButton() {
		
	}
	
	/** find operator label on button
	 * */
	public void getLabelOnButton() {
		
	}
	
}
