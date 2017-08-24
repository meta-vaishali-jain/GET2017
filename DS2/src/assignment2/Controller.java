package assignment2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import arrayList.DisplayOutput;

/**
 * ClassName  : Controller
 * @author    : Vaishali Jain
 * Description: controller class performing all the task i.e. assigning college
 *
 */
public class Controller {
	//has details of rank of all the candidates
	UserDefinedQueue<Integer> queue = new UserDefinedQueue<Integer>();
	HashMap<Integer,String> collegesAssign=new HashMap<Integer,String>();
	ArrayList<CollegeDetail> collegeDetails = new ArrayList<CollegeDetail>();
	private int totalNumberOfAvailableSeats=0;
	
	//default constructor
	Controller() {
	}
	
	public void getCnadidateRank(int noOfCandidates){
		Scanner inputScanner=new Scanner(System.in);
		for (int i = 0; i<noOfCandidates; i++) {
			System.out.println("Enter rank for candidate"+(i+1));
			int rank=inputScanner.nextInt();
			queue.enqueue(rank);
			
		}
		queue.queueSort();
	}
	
	public int getTotalNumberOfAvailableSeats() {
		return totalNumberOfAvailableSeats;
	}

	public void setTotalNumberOfAvailableSeats(int totalNumberOfAvailableSeats) {
		this.totalNumberOfAvailableSeats = totalNumberOfAvailableSeats;
	}

	/*
	 * method to get total number of seats in all colleges
	 */
	public void getTotalNumberOfSeats(){
	for (int i = 0; i < collegeDetails.size(); i++) {
		totalNumberOfAvailableSeats+=collegeDetails.get(i).getTotalSeats();
	}
	System.out.println(totalNumberOfAvailableSeats);
	}
	
	/**
	 * method assigining colleges to candidate on the basis of seats available in the college and user choice of the college
	 * @param candidateCollegeChoice
	 * @param candidate
	 * @return
	 */
	public boolean assignSeats(int candidateCollegeChoice,int candidate){
		boolean flag;
		int availableSeats;
		//updating available seats in colleges and also total number of seats
		if ((availableSeats = collegeDetails.get(candidateCollegeChoice).getSeatsAvailable()) > 0) {
			collegeDetails.get(candidateCollegeChoice).setSeatsAvailable(--availableSeats);
			collegesAssign.put(candidate,collegeDetails.get(candidateCollegeChoice).getCollegeName());
			totalNumberOfAvailableSeats--;
			flag=true;
		} else {
			DisplayOutput.messageHandler("Seats not available Try in next round");
			//queueOfCollegeName.enqueue("College Not assign");
			flag=false;
		}
		return flag;
	}
	
	//initialise colleges with total seats and available seats
	public void initialiseColleges() {
		collegeDetails.add(new CollegeDetail("ABC", 2, 2, 1));
		collegeDetails.add(new CollegeDetail("DEF", 1, 1, 2));
		collegeDetails.add(new CollegeDetail("GHI", 1, 1, 3));
		collegeDetails.add(new CollegeDetail("JKL", 1, 1, 4));
		collegeDetails.add(new CollegeDetail("MNO", 0, 0, 5));
	}

	/**
	 * method displaying all colleges with the complete details
	 */
	public void displayCollegesWithDetails() {
		System.out.println("College Name \t\t TotalSeats\t\tSeats Available");
		for (int i = 0; i < collegeDetails.size(); i++) {
			System.out.println((i+1)+"\t\t"+collegeDetails.get(i).getCollegeName() + "\t\t"
					+ collegeDetails.get(i).getTotalSeats() + "\t\t"
					+ collegeDetails.get(i).getSeatsAvailable());
		}
	}
	
	/**
	 * method displaying candidates with the college assigned
	 */
	public void displayCandidateWithColleges(){
		for (HashMap.Entry<Integer,String> entry : collegesAssign.entrySet()) {
		    System.out.println(entry.getKey()+" : "+entry.getValue());
		}
	}
	
	public void candidateChoiceCheck(int choice,int candidate){
		switch (choice) {
		case 1:
			if(!assignSeats(0,candidate)){
				queue.enqueue(candidate);
			}
			
			break;
			
		case 2:
			if(!assignSeats(1,candidate)){
				queue.enqueue(candidate);
			}
			break;

		case 3:
			if(!assignSeats(2,candidate)){
				queue.enqueue(candidate);
			}
			break;

		case 4:
			
			if(!assignSeats(3,candidate)){
				queue.enqueue(candidate);
			}
			break;

		case 5:
			if(!assignSeats(4,candidate)){
				queue.enqueue(candidate);
			}
			break;
			default:
				System.out.println("Wrong choice");
				break;
		}

	}
	
	/**
	 * method to assign college to candidate
	 */
	public void assignCollege() {
		int choice;
		Scanner inputScanner = new Scanner(System.in);
		while (queue.getFront() != null) {
			int candidate = (Integer) queue.dequeue();
			System.out.println("Candidate with rank  " + candidate);
			displayCollegesWithDetails();
			if(totalNumberOfAvailableSeats==0){
				System.out.println("No college available to assign");
				collegesAssign.put(candidate, "College not assign");
			}else{
			choice = inputScanner.nextInt();
			//check candidate choice about which college
			candidateChoiceCheck(choice, candidate);
					}
		}
		}
	}

