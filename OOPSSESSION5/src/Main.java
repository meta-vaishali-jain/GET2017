import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
	Scanner inputScanner = new Scanner(System.in);

	/**
	 * method to display menu
	 */
	public static void menu() {
		System.out.println("\nEnter what you want to do");
		System.out.println("1 Want to add Connection");
		System.out.println("2 Want to see social network");
		System.out.println("3 To get summaries of all entites");
		System.out.println("4 Search entities based on name");
		System.out.println("5 Exit  : return()");
	}

	public static void typeOfSummaryMenu() {
		System.out.println("Summary of User Or Organisation");
		System.out.println("1 : User");
		System.out.println("2 : Organisation");
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
			System.out
					.println("\nWrong element format Please enter in correct format");
			element = inputScanner.next();
		}
		return Integer.parseInt(element);
	}

	/**
	 * method to check for valid choice that is choice entered in particular
	 * boundary condition
	 * 
	 * @param choice
	 * @param maxChoice
	 * @return
	 */
	public static boolean isValidChoice(int choice, int maxChoice) {

		if (choice < 0 || choice > maxChoice) {
			return false;
		}
		return true;
	}

	/**
	 * METHOD TO GET Name in correct format
	 * 
	 * @return
	 */
	public String getElementInStringFormat() {
		Scanner inputScanner = new Scanner(System.in);
		String element;
		element = inputScanner.nextLine();
		// name matches with this pattern or not
		Pattern pattern = Pattern.compile("^[ A-Za-z ]+$");
		Matcher match = pattern.matcher(element);
		boolean flag = match.matches();
		while (!flag) {
			System.out.println("Please enter name in correct format");
			element = inputScanner.nextLine();
		}
		return element;
	}

	// main method
	public static void main(String args[]) throws SQLException {
		Scanner inputScanner = new Scanner(System.in);
		SocialNetwork socialNetwork = new SocialNetwork();

		while (true) {
			menu();
			int choice = new Main().getElementInNumberFormat();
			while (!isValidChoice(choice, 5)) {
				System.out.println("Wrong choice\nEnter again");
				choice = new Main().getElementInNumberFormat();
			}
			switch (choice) {
			//method to add connection
			case 1:
				System.out.println("Enter your ID");
				int requestingID = new Main().getElementInNumberFormat();
				//To check requesting id exist or not
				if (!socialNetwork.ifIDExist(requestingID)) {
					System.out.println("ID not exist");
					break;
				}
				System.out.println("Enter ID to add connection");
				//to check connecting id exist or not
				int connectingID = new Main().getElementInNumberFormat();
				if (!socialNetwork.ifIDExist(connectingID)) {
					System.out.println("ID not exist");
					break;
				}
				//to check if connection alfready exist or not
				if (!socialNetwork.addConnection(requestingID, connectingID)) {
					System.out.println("Connection Already Exist");
				} else {
					System.out.println("Connected successfully");
				}
				break;
				//To print full social network
			case 2:int[][] matrix=socialNetwork.displaySocialNetwork();
				   for(int i=0;i<matrix.length;i++){
					   for(int j=0;j<matrix.length;j++){
						   if(i==0||j==0){
							   System.out.print(matrix[i][j]+"    " );
						   }
						   else{
							   System.out.print(matrix[i][j]+"       " );
						   }
					   }
					   
					   System.out.println();
				   }
				break;
				//To print user and organisation summary
			case 3:
				typeOfSummaryMenu();
				choice = new Main().getElementInNumberFormat();
				while (!isValidChoice(choice, 2)) {
					System.out.println("Wrong choice\nEnter again");
					choice = new Main().getElementInNumberFormat();
				}
				//to print details of all entities of type user
				if (choice == 1) {
					ArrayList<User> userList = socialNetwork
							.printUsersSummary();
					System.out
							.println("*******************************************USER DETAILS*******************************************");

					for (int i = 0; i < userList.size(); i++) {
						System.out.println("UserName  "
								+ userList.get(i).getEntityName());
						System.out.println("UserAge  "
								+ userList.get(i).getUserAge());
						System.out.println("UserHobbies "
								+ userList.get(i).getUserHobbies() + "\n\n");
					}
				}
				//to print details of all entities of type organisation
				else {
					System.out
							.println("*******************************************ORGANISATION DETAILS*******************************************");

					ArrayList<Organisation> organisationList = socialNetwork
							.printOrganisationsummary();
					for (int i = 0; i < organisationList.size(); i++) {
						System.out.println("OrganisationName  "
								+ organisationList.get(i).getEntityName());
						System.out.println("OrganisationDomain  "
								+ organisationList.get(i).getDomain() + "\n\n");
					}
				}
				break;
			//to search entity on the basis of name
			case 4:
				System.out.println("Enter name of entity");
				String name = new Main().getElementInStringFormat();
				ArrayList<Node> entityList = socialNetwork
						.getEntityByName(name);
				//if no entity exist with this name
				if (entityList.size() == 0) {
					System.out.println("No entity with this name");
				} else {
					for (int i = 0; i < entityList.size(); i++) {

						if (entityList.get(i).getEntity() instanceof User) {
							User user = (User) entityList.get(i).getEntity();
							System.out.println("UserName "
									+ user.getEntityName());
							System.out.println("UserAge " + user.getUserAge());
							System.out.println("UserHobbies "
									+ user.getUserHobbies() + "\n\n");
						} else {
							Organisation organisation = (Organisation) entityList
									.get(i).getEntity();
							System.out.println("OrganisationName "
									+ organisation.getEntityName());
							System.out.println("OrganisationDomain "
									+ organisation.getDomain() + "\n\n");

						}
					}
				}
				break;
				//to return
			case 5:
				return;

			}
		}

	}
}
