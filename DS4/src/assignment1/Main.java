package assignment1;

import java.util.Scanner;

public class Main {
	Scanner inputScanner=new Scanner(System.in);
	/**
	 * method to perform if choice enterd by user is valid or not
	 * @param choice
	 * @param limit describes limit of the choice i.e 1-limit
	 * @return
	 */
	public static boolean isValidChoice(String choice,int limit){
		try{
			int parsedChoice=Integer.parseInt(choice);
			if(parsedChoice<0||parsedChoice>limit){
				return false;
			}
			return true;
		}catch(Exception errorHandler){
			return false;
		}
	}
	
	/**
	 * method to display menu
	 */
	public static void menu(){
		System.out.println("\nEnter function to perform what you want to do");
		System.out.println("1 InsertJob : insert()");
		System.out.println("2 PrintJob  : print()");
		System.out.println("3 Exit      :return()");
	}
	
	/**
	 * method to display type of User select menu
	 */
	public static void typeOfUserMenu(){
		System.out.println("\nEnter type of user 1/2/3/4");
		System.out.println("1 UnderGraduates");
		System.out.println("2 Graduates");
		System.out.println("3 Professors");
		System.out.println("4 Chair");
	}
	
	/**
	 * method to get type of the user
	 * @return
	 */
	public String getUserType(){
		typeOfUserMenu();
		String userType;
		String choice=inputScanner.next();
		while(!isValidChoice(choice,4)){
			System.out.println("\nWrong choice Enter again");
			typeOfUserMenu();
			choice=inputScanner.next();
		}
		if(Integer.parseInt(choice)==1){
			userType="UnderGraduates";
		}else if(Integer.parseInt(choice)==2){
			userType="Graduates";
		}else if(Integer.parseInt(choice)==3){
			userType="Professors";
		}else{
			userType="Chair";
		}
		return userType;
	}
	
	/**
	 * method to get input from the user of document
	 * @return
	 */
	public  String getInputDocument(){
		System.out.println("\nEnter document to be printed");
		return(inputScanner.next());
	}
	
	/**
	 * method to compute job priority based on the user type
	 * @param userType
	 * @return
	 */
	public int getUserPriority(String userType){
		int priority;
		if(userType.equals("UnderGraduates")){
			priority=1;
		}else if(userType.equals("Graduates")){
			priority=2;
		}else if(userType.equals("Professors")){
			priority=3;
		}else{
			priority=4;
		}
		return priority;
	}
	
	/**
	 * main method
	 * @param args
	 */
	public static void main(String args[]){
		PriorityQueue queue=new PriorityQueue();
		Scanner inputScanner=new Scanner(System.in);
		while(true){
			menu();
			String function=inputScanner.next();
			if(function.equals("1") || function.toUpperCase().equals("INSERT()")||function.toUpperCase().equals("INSERT")){
				String jobDocument=new Main().getInputDocument();
				String userType=new Main().getUserType();
				int userPriority=new Main().getUserPriority(userType);
				if(queue.insert(jobDocument, userPriority, userType)){
					System.out.println("\nJob inserted successfully");
				}else{
					System.out.println("\nJob not inserted");
				}
			}else if(function.equals("2") || function.toUpperCase().equals("PRINT()")||function.toUpperCase().equals("PRINT")){
				Job[] printedJobs=queue.print();
				if(printedJobs==null){
					System.out.println("\nNo job to be printed");
				}else{
					System.out.println("\nJob Document\t\t\t\t\t\tJob Arrival Number\t\tPriority Of Job\t\tType Of User");
					for(int i=0;i<printedJobs.length;i++){
						System.out.println(printedJobs[i].getJobDocument()+"\t\t\t\t\t"+printedJobs[i].getJobNo()+"\t\t"+printedJobs[i].getPriority()+"\t\t"+printedJobs[i].getUserType());
					}
				}
			}else if(function.equals("3") || function.toUpperCase().equals("RETURN()") || function.toUpperCase().equals("RETURN")){
				return;
			}else{
				System.out.println("\nWrong choice Enter again");
			}
			
		}
	}
}
