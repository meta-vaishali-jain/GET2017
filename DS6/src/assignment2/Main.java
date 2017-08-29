package assignment2;

import java.util.Scanner;

/**
 * ClassName  : Main
 * @author    : Vaishali Jain
 * Description : Controller class
 */
public class Main {
	/**
	 * display menu
	 */
	public static void menu(){
		System.out.println("\nEnter what you want to do");
		System.out.println("1 Find Unique Characters : countUniqueCharacters()");
		System.out.println("2 Exit : return()");
	}
	
	/**
	 * main class
	 * @param args
	 */
	public static void main(String args[]){
		Scanner inputScanner=new Scanner(System.in);
		CountUniqueCharacters counttUniqueCharacters=new CountUniqueCharacters();
		while(true){
			menu();
			String function=inputScanner.next();
			//count unique characters
			switch(function){
			case "1" : 
			case "COUNTUNIQUECHARACTERS()":
			case "COUNTUNIQUECHARACTERS":
				String inputString=inputScanner.next();
				counttUniqueCharacters.countUniqueCharacters(inputString);
				break;
			case "2" :
			case "RETURN()":
			case "RETURN":
				return;
			default : 
				System.out.println("Wrong input enter again");
			}
		}
	}
}
