package assignment1;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	Scanner inputScanner = new Scanner(System.in);

	/**
	 * method to perform if choice entered by user is valid or not
	 * @param choice
	 * @param limit  describes limit of the choice i.e 1-limit
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
	 * method to check choic is in number format only
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
	 * method to check element is in string format only
	 * @param element
	 * @return
	 */
	public boolean isString(String element){
		if(element.chars().allMatch(Character::isLetter)){
			return true;
		}
		return false;
	}

	/**
	 * method to display menu
	 */
	public static void menu() {
		System.out.println("\nEnter what you want to do");
		System.out.println("1 Add : addEmployee()");
		System.out.println("2 NaturalOrderSorting : naturalOrderSorting()");
		System.out.println("3 Sorting based on name : nameBasedSorting()");
		System.out.println("4 Exit  : return()");
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
	
	/**
	 * method to get input in string
	 * @return
	 */
	public String getElementInString(){
		String stringElement= inputScanner.next();
		while(!isString(stringElement)){
			System.out.println("Please enter element in correct format");
			stringElement= inputScanner.next();
		}
		return stringElement;
	}
	
	/**
	 * method to print the employee list
	 * @param listOfEmployees
	 */
	public void printEmployeeList(ArrayList<Employee> listOfEmployees){
		for(Employee employee:listOfEmployees){  
			System.out.println(employee.getEmployeeID()+" "+employee.getEmployeeName()+" "+employee.getEmployeeAddress());  
			}  
	}
	
	/**
	 * main method
	 * @param args
	 */
	public static void main(String args[]){
		Scanner inputScanner=new Scanner(System.in);
		EmployeeOperations employeeOperations=new EmployeeOperations();
		while(true){
			menu();
			String function=inputScanner.next();
			switch(function.toUpperCase()){
			//to add employee in list
			case "1":
			case "ADDEMPLOYEE()":
			case "ADDEMPLOYEE":
				System.out.println("Enter employeeID");
				int employeeID=new Main().getElementInNumberFormat();
				System.out.println("Enter employee name");
				String employeeName=new Main().getElementInString();
				System.out.println("Enter employee address");
				String employeeAddress=inputScanner.next();
				if(!employeeOperations.addEmployee(employeeID, employeeName, employeeAddress)){
					System.out.println("Employee with this id already exist");
				}else{
					System.out.println("Employee added successfully");
				}
				break;
			//to sort list of employees on the basis of natural order
			case "2":
			case "NATURALORDERSORTING()":
			case "NATURALORDERSORTING":
				if(employeeOperations.naturalOrderSorting()==null){
					System.out.println("Collection is empty no element to sort");
				}else{
					System.out.println("Employee list on the basis of natural order sorting");
					new Main().printEmployeeList(employeeOperations.naturalOrderSorting());
				}
				break;
			//to sort list of employees on the basis of employee name
			case "3":
			case "NAMEBASEDSORTING()":
			case "NAMEBASEDSORTING":
				if(employeeOperations.naturalOrderSorting()==null){
					System.out.println("Collection is empty no element to sort");
				}else{
					System.out.println("Employee list on the basis of neme based sorting");
					new Main().printEmployeeList(employeeOperations.nameBasedSorting());
				}
				break;
			//to exit
			case "4":
			case "RETURN()":
			case "RETURN":
				return;
			//in case of wrong choice
			default:
				System.out.println("Wrong choice Please enter correct one");
				break;
			}
		}
	}
}
