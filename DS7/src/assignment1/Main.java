package assignment1;

import java.util.Scanner;

/**
 * ClassName  : Main
 * @author    : Vaishali Jain
 * Description: Controller of the program
 */
public class Main {
	Scanner inputScanner = new Scanner(System.in);
	/**
	 * method to display menu
	 */
	public static void menu() {
		System.out.println("\nEnter what you want to do");
		System.out.println("1 Add Element : addElement()");
		System.out.println("2 Search Element :searchElement()");
		System.out.println("3 Exit  : return()");
	}
	
	/**
	 * method to check input is in number format only
	 * @param choice
	 * @return
	 */
	public boolean isNumber(String input) {
		try {
			int parsedChoice = Integer.parseInt(input);
		} catch (NumberFormatException e) {
			return false;
		}
		return true;
	}
	
	/**
	 * method to get element in number format
	 * @return
	 */
	public int getElementInNumberFormat() {
		String element = inputScanner.next();
		while (!isNumber(element)) {
			System.out.println("\nWrong element format Please enter in correct format");
			element = inputScanner.next();
		}
		return Integer.parseInt(element);
	}
	
	//main method
	public static void main(String args[]){
		Scanner inputScanner=new Scanner(System.in);
		BinarySearchTree<Integer> binarySearchTree=new BinarySearchTree<Integer>();
		while(true){
			menu();
			String function=inputScanner.next();
			int element;
			switch(function.toUpperCase()){
			//add element in the array
			case "1":
			case "ADDELEMENT()":
			case "ADDELEMENT":
				System.out.println("Enter element to be added");
				element=new Main().getElementInNumberFormat();
				if(binarySearchTree.addElement(element)!=-1){
				System.out.println("Element inserted successfully");
				}else{
					System.out.println("Element not inserted");
				}
				break;
			//to perform searching of element 
			case "2":
			case "SEARCHELEMENT()":
			case "SEARCHELEMENT":
				System.out.println("Enter element to search");
				element=new Main().getElementInNumberFormat();
				int index=binarySearchTree.searchElement(element);
				if(index==-1){
					System.out.println("Element not found");
				}else{
					System.out.println("Element "+element+" found at position "+index);
				}
				break;
			//exit
			case "3":
			case "RETURN()":
			case "RETURN":
				return;
			default:
				System.out.println("Wrong choice Please enter correct one");	
			}
			}
	}
}
