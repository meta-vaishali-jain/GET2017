package assignment2;

import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * ClassName  : Main
 * @author    : Vaishali Jain
 * Description: Controller class of the project
 */
public class Main {
Scanner inputScanner=new Scanner(System.in);
	
	/**
	 * method to perform if choice entered by user is valid or not
	 * @param choice
	 * @param limit describes limit of the choice i.e 1-limit
	 * @return
	 */
	public  boolean isValidChoice(String choice,int limit){
		if(isNumber(choice)){
			if(Integer.parseInt(choice)<0||Integer.parseInt(choice)>limit){
				return false;
			}else{
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
	public boolean isNumber(String choice){
		try{
		int parsedChoice=Integer.parseInt(choice);
		}catch(NumberFormatException e){
		return false;
		}
		return true;
		}
	
	/**
	 * method to display menu
	 */
	public static void menu(){
		System.out.println("\nEnter what you want to do");
		System.out.println("1 Add : add()");
		System.out.println("2 QueueEmpty : isEmpty()");
		System.out.println("3 Remove : remove()");
		System.out.println("4 Poll : poll()");
		System.out.println("5 Peek : peek()");
		System.out.println("6 GetElement : element()");
		System.out.println("7 Size : size()");
		System.out.println("8 Clear : clear()");
		System.out.println("9 Exit  : return()");
	}
	
	/**
	 * method to get element from user to be added in queue
	 * @return
	 */
	public int getElement(){
		System.out.println("\nEnter element to be added in queue");
		String element=inputScanner.next();
		while(!isNumber(element)){
			System.out.println("\nWrong element format Please enter in correct format");
			element=inputScanner.next();
		}
		return Integer.parseInt(element);
	}

	/**
	 * main to call function on the basis of user choice
	 * @param args
	 */
	public static void main(String args[]){
		Scanner inputScanner=new Scanner(System.in);
		Queue<Integer> queue=new Queue<Integer>();
		while(true){
			menu();
			String function=inputScanner.next();
			Object element;
			switch(function.toUpperCase()){
			//to add element to queue
			case "1":
			case "ADD()":
			case "ADD":
				 element=new Main().getElement();
				queue.add(element);
				System.out.println("\nElement added successfully");
				break;
			//to check if queue is empty
			case "2":
			case "ISEMPTY()":
			case "ISEMPTY":
				if(queue.isEmpty()){
					System.out.println("Queue is empty");
				}else{
					System.out.println("Queue is not empty");
				}
				break;
			//to remove element from queue
			case "3":
			case "REMOVE()":
			case "REMOVE":
				try{
					System.out.println("Element removed from queue"+queue.remove());
				}catch(NoSuchElementException error){
					System.out.println("Queue is empty");
				}
				break;
			//to remove element from queue
			case "4":
			case "POLL()":
			case "POLL":
				if((element=queue.poll())==null){
					System.out.println("Queue is empty No element to remove");
				}else{
					System.out.println("Element removed from queue "+ element);
				}
				break;
			//to get element from queue
			case "5":
			case "PEEK()":
			case "PEEK":
				if((element=queue.peek())==null){
					System.out.println("Queue is empty No element to get");
				}else{
					System.out.println("Element at first position "+ element);
				}
				break;
			//to get element from queue
			case "6":
			case "ELEMENT()":
			case "ELEMENT":
				try{
					System.out.println("Element at the first in queue"+queue.element());
				}catch(NoSuchElementException error){
					System.out.println("Queue is empty");
				}
				break;
			// to get size of queue
			case "7":
			case "SIZE()":
			case "SIZE":
				System.out.println(queue.size());
				break;
			//to clear queue
			case "8":
			case "CLEAR()":
			case "CLEAR":
				queue.clear();
				System.out.println("Queue cleared");
				break;
			//to exit
			case "9":
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
