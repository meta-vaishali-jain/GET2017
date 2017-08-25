package assignment2;

import java.util.Scanner;

public class Main {
	Scanner inputScanner=new Scanner(System.in);
	RoomAllotment roomAllotment=new RoomAllotment();
	
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
	 * method to check choice is in number only
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
	 * method to check rooms are available or not for booking
	 * @param totalGuestAvailable
	 * @return
	 */
	public boolean isRoomAvailable(int totalGuestAvailable){
		if(totalGuestAvailable<roomAllotment.getNumberOfRooms()){
			return true;
		}
		return false;
	}
	
	//method to get guest name from the user
	public String getGuestName(){
		String guestName;
		System.out.println("Enter guest name");
		guestName= inputScanner.next();
		while(!guestName.chars().allMatch(Character::isLetter)){
			System.out.println("Please enter name in correct format");
			guestName= inputScanner.next();
		}
		return guestName;
	}
	
	//method to get guest age from user
	public int getGuestAge(){
		String age;
		System.out.println("Enter age of the guest");
		age=inputScanner.next();
		while(!isNumber(age)){
			System.out.println("Wrong age Please enter in correct format");
			age=inputScanner.next();
		}
		return Integer.parseInt(age);
	}
	
	/**
	 * method to display menu
	 */
	public static void menu(){
		System.out.println("Enter function to perform what you want to do");
		System.out.println("1 Book Room : alloteRoom()");
		System.out.println("2 Exit      : return()");
	}
	//main method
	public static void main(String args[]){
		Scanner inputScanner=new Scanner(System.in);
		RoomAllotment roomsDetails=new RoomAllotment();
		int totalGuestAvailable=0;
		
		while(true){
			menu();
			String function=inputScanner.next();
			if(function.equals("1")||function.toUpperCase().equals("ALLOTEROOM()")||function.toUpperCase().equals("ALLOTEROOM")){
				if(new Main().isRoomAvailable(totalGuestAvailable)){
					String guestName=new Main().getGuestName();
					int age=new Main().getGuestAge();
					int roomNumber=roomsDetails.bookRoom(guestName,age);
					totalGuestAvailable++;
					System.out.println("Room allocated successfully Room Number "+ roomNumber);
				}else{
					System.out.println("Room not available");
				}	
			}else if(function.equals("2")||function.toUpperCase().equals("RETURN()")||function.toUpperCase().equals("RETURN")){
				return;
			}else{
				System.out.println("Wrong choice");
			}
		}
		
		
	}
}
