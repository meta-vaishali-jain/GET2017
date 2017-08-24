package assignment2;

import java.util.Scanner;

public class MainC {
	public static void main(String args[]){
		Scanner inputScanner=new Scanner(System.in);
		System.out.println("Enetr number of candidates for councelling");
		int noOfCandidates=inputScanner.nextInt();
		Controller controller=new Controller();
		//taking input rank from the candidates
		controller.getCnadidateRank(noOfCandidates);
		//sorting the queue in increasing rank format
				
		//initialise all the colleges with seats and available seats
		controller.initialiseColleges();
				//getting total no of seats in all the colleges
		controller.getTotalNumberOfSeats();
		controller.assignCollege();
		controller.displayCandidateWithColleges();
	}
}
