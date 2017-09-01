package assignment1;

import java.util.Scanner;

/**
 * ClassName  : Main
 * @author    : Vaishali Jain
 * Description: Controller of the program
 */
public class Main {
	Scanner inputScanner = new Scanner(System.in);
	TreeSort<Integer> treeSorting = new TreeSort<Integer>();
	
	/**
	 * method to display menu
	 */
	public static void menu() {
		System.out.println("\nEnter what you want to do");
		System.out.println("1 Add Roll Number : insertData()");
		System.out.println("2 Sort Roll Numbers :treeSort()");
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
	public static void main(String args[]) {
		Main mainObject=new Main();
	
		while (true) {
			menu();
			String function = mainObject.inputScanner.next();
			
			switch (function.toUpperCase()) {
			// add roll number in the array
			case "1":
			case "INSERTDATA()":
			case "INSERTDATA":
				System.out.println("Enter roll number to be added");
				int rollNumber = mainObject.getElementInNumberFormat();
				//for negative roll number
				if (rollNumber <= 0) {
					System.out.println("Enter roll number as positive");
				}
				//if roll number already exist
				else if(mainObject.treeSorting.contains(rollNumber)){
					System.out.println("Roll Number already exist");
				}else {
					if (mainObject.treeSorting.insertData(rollNumber)) {
						System.out.println("Roll Number added successfully");
					} else {
						System.out.println("Roll Number not added");
					}
				}
				break;
				//sort the array
			case "2":
			case "TREESORT()":
			case "TREESORT":
				Object[] elements;
				if ((elements = mainObject.treeSorting.treeSort()) == null) {
					System.out.println("No element to sort");
				} else {
					for (int i = 0; i < elements.length; i++) {
						System.out.println(elements[i]);
					}
				}
				break;
			//exit
			case "3":
			case "RETURN()":
			case "RETURN":
				return;
			default:
				System.out.println("Wrong choice\nEnter correct one");
				break;
			}
		}
	}
}
