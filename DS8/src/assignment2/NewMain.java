package assignment2;

import java.util.Scanner;

public class NewMain {
	/**
	 * ClassName : Main
	 * @author    : Vaishali Jain
	 * Description: Controller of the program
	 */
	Scanner inputScanner = new Scanner(System.in);

	/**
	 * method to display menu
	 */
	public static void menu() {
		System.out.println("\nEnter what you want to do");
		System.out.println("1 Add  Number : insertData()");
		System.out.println("2 Sort Numbers :Sort()");
		System.out.println("3 Exit  : return()");
	}
	
	public static void sortmenu() {
		System.out.println("\nEnter what you want to do");
		System.out.println("1 Comparision Sort");
		System.out.println("2 Linear Sort");
		System.out.println("3 Exit  : return()");
	}

	/**
	 * method to check input is in number format only
	 * 
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
	 * 
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

	// main method
	public static void main(String args[]) {
		Scanner inputScanner = new Scanner(System.in);
		Controller controller = new Controller();

		while (true) {
			menu();
			String function = inputScanner.next();
			switch (function.toUpperCase()) {
			//to insert element
			case "1":
			case "INSERT()":
			case "INSERT":
				System.out.println("Enter element to be inserted");
				int element = new NewMain().getElementInNumberFormat();
				controller.insert(element);
				break;
				//to sort the elements
			case "2":
			case "SORT()":
			case "SORT":
				Integer[] array;
				sortmenu();
				int choice = new NewMain().getElementInNumberFormat();
				//to check choice is correct or not
				while(choice<=0||choice>2){
					System.out.println("Enter correct choice");
					choice = new NewMain().getElementInNumberFormat();
				}
				int sortType=controller.sort(choice);
				if(choice==1){
					if(sortType==0)
						System.out.println("Element sorted using bubble sort");
					else
						System.out.println("Element sorted using quick sort");
				}else{
					if(sortType==0)
						System.out.println("Element sorted using counting sort");
					else
						System.out.println("Element sorted using  radix sort");
				}
				//print sorted array
				array=controller.getArray();
				for(int i=0;i<array.length;i++){
					System.out.println(array[i]);
				}
				break;
				//exit
			case "3":
			case "RETURN()":
			case "RETURN":
				return;
			default:
				System.out.println("Wrong choice\n Enter again");
				break;
			}
		}

}
}
