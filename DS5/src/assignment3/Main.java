package assignment3;

import java.util.Scanner;

/**
 * ClassName  : Main
 * @author    : Vaishali Jain
 * Description: Controller class of the project
 */
public class Main {

	Scanner inputScanner = new Scanner(System.in);

	/**
	 * method to perform if choice entered by user is valid or not
	 * 
	 * @param choice
	 * @param limit
	 *            describes limit of the choice i.e 1-limit
	 * @return
	 */
	public boolean isValidChoice(String choice, int limit) {
		if (isNumber(choice)) {
			if (Integer.parseInt(choice) < 0
					|| Integer.parseInt(choice) > limit) {
				return false;
			} else {
				return false;
			}
		}
		return false;
	}
	
	/**
	 * method to check parameter value is in number format or not
	 * @param choice
	 * @return
	 */
	public boolean isNumber(String choice) {
		try {
			int parsedChoice = Integer.parseInt(choice);
		} catch (NumberFormatException e) {
			return false;
		}
		return true;
	}

	/**
	 * method to display menu
	 */
	public static void menu() {
		System.out.println("\nEnter what you want to do");
		System.out.println("1 Add : add()");
		System.out.println("2 Get First Element : getFirst()");
		System.out.println("3 Get Last Element : getLast()");
		System.out.println("4 Get Element At Particular Index : get()");
		System.out.println("5 Exit  : return()");
	}
	
	/**
	 * method to get element from user to be added in linked list
	 * @return
	 */
	public int getElement() {
		System.out.println("\nEnter element ");
		String element = inputScanner.next();
		//to check element is in number format only
		while (!isNumber(element)) {
			System.out.println("\nWrong element format Please enter in correct format");
			element = inputScanner.next();
		}
		return Integer.parseInt(element);
	}
    
	/**
	 * main to call function on the basis of user choice
	 * @param args
	 */
	public static void main(String args[]) {
		Scanner inputScanner = new Scanner(System.in);
		SortedLinkedList<Integer> sortedLinkedList = new SortedLinkedList<Integer>();
		while (true) {
			menu();
			String function = inputScanner.next();
			Object element;
			switch (function.toUpperCase()) {
			//to add element in linked list in sorted form
			case "1":
			case "ADD()":
			case "ADD":
				element = new Main().getElement();
				sortedLinkedList.add(element);
				System.out.println("\nElement added successfully");
				break;
			//to get first element of the linked list
			case "2":
			case "GETFIRST()":
			case "GETFIRST":
				element = sortedLinkedList.getFirst();
				if (element == null) {
					System.out.println("List is empty");
				} else {
					System.out.println(element);
				}
				break;
			//to get last element of the linked list
			case "3":
			case "GETLAST()":
			case "GETLAST":
				element = sortedLinkedList.getLast();
				if (element == null) {
					System.out.println("List is empty");
				} else {
					System.out.println(element);
				}
				break;
			//to get element of linked list at particular index
			case "4":
			case "GET()":
			case "GET":
				int index = new Main().getElement();
				element = sortedLinkedList.get(index);
				if (element == null) {
					System.out.println("Index position not exist");
				} else {
					System.out.println(element);
				}
				break;
			//to exit
			case "5":
			case "RETURN()":
			case "RETURN":
				return;
			default:
				System.out.println("Wrong choice Please enter correct one");
				break;

			}
		}
	}
}
