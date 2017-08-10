package assignment1;

import java.util.*;
import java.util.Map.Entry;

/**
 * @Class	  : SocialNetwork
 * @author    : Vaishali Jain
 * Description: Controller class for the social network interface
 *              Execution of program starts here
 */
public class SocialNetwork {
	//Files to access//
	private static String readUserProfile   = "UserProfile.csv";
	private static String readUserConnection = "Connection.csv";
	
	//Main menu items covered//
	public static void main(String[] args) {
		showAllUserProfiles();
		showAllConnections();
		Node currentUser = Graph.getProfileByName();
		showProfile(currentUser);
		
		/** 1. Show list of all available users (People and organisation)
		 *  2. Show list of all connections 
		 *  3. Scan user input to view summary details(user details and their connections)
		 *  4. Add a new connection
		 *  5. Print the updated connection list
		 *  6. Search for Nodes by name
		 * **/
	}
	
	/**
	 * Print the list of all valid users existing
	 */
	public static void showAllUserProfiles() {
		System.out.println("\n\nVIEW ALL USERS");
		
		//Iterating the data_file from list of nodes
		Map<Integer, Node> hashMap = Graph.readUserProfiles(readUserProfile);
		Set<Entry<Integer, Node>> set = hashMap.entrySet(); 
		Iterator<Entry<Integer, Node>> i = set.iterator();
		
		while(i.hasNext()) {
			Map.Entry<Integer, Node> me = (Map.Entry<Integer, Node>) i.next();
			System.out.println(me.getValue().getEntity().getType() + " : "+ me.getValue().getEntity().getUserName() );
		}
	}
	
	/**
	 * @Method	showAllConnections()
	 * Print the list of all valid connections for a user
	 * @return	type = void
	 */
	public static void showAllConnections() {
		System.out.println("\n\nVIEW ALL USERS ALL CONNECTIONS");
		Map<Node, Connection> hashMap = Graph.readUserConnections(readUserConnection);
		
		Set<Entry<Node, Connection>> set = hashMap.entrySet(); 
		Iterator<Entry<Node, Connection>> i = set.iterator();
		
		while(i.hasNext()) {
			Map.Entry<Node, Connection> mapEntry = (Map.Entry<Node, Connection>) i.next();
			System.out.println( mapEntry.getKey().getEntity().getUserName() + " is connected to ");
			
			List<Node> connect = mapEntry.getValue().getConnections();
			for(int j=0; j< connect.size(); j++) {
				System.out.println("\t\t" + connect.get(j).getEntity().getUserName());
			}
		}
	}
	/**
	 * method to print connections of particular user
	 * @param currentUser
	 */
	public static void toPrintConnection(Node currentUser){
		System.out.println("Here are your connections: ");
		List<Node> currentUserConnections = new ArrayList<Node>();

		if (Graph.userConnections != null && Graph.userConnections.get(currentUser) != null) {
			currentUserConnections = Graph.userConnections.get(currentUser).getConnections();

			if (currentUserConnections != null && currentUserConnections.size() > 0) {

				for (int i = 0; i < currentUserConnections.size(); i++)
					System.out.println(currentUserConnections.get(i).getEntity().getUserName());
			}
		} else {
			System.out.println("You are not connected to anyone." + "\n Connect now?");
		}
	}
	
	/**
	 * @Method showAllConnections()
	 * calls appropriate sub class that holds sub values
	 * @return type =void, updates connections
	 */
	public static void showProfile(Node currentUser){
		//System.out.println("user"+  ("user".equals(current_user.getEntity().getType())));
		//System.out.println("organisation".equals(current_user.getEntity().getType()));
		
		if(currentUser == null){
			System.out.println("wrong credentials");
		}else if("user".equals(currentUser.getEntity().getType())){
			showSpecificUserProfile(currentUser);
		}else if("organisation".equals(currentUser.getEntity().getType())){
			showSpecifiOrganisationProfile(currentUser);
		}
	}
	
	/**@method		showSpecificUserProfile(Node currentUser)
	 * display result only for people sub type entity
	 *  summaries differ as each type holds different values
	 * **/
	public static void showSpecificUserProfile(Node currentUser){
		System.out.println("Hello, "+ currentUser.getEntity().getUserName() +". Welcome to the social network."
				+ "\nHere are your details:\t"
				+ "\nYour login id is:\t"    + currentUser.getEntity().getId()
				+ "\nYour current age is:\t" + ( (People) currentUser.getEntity()).getAge()
				+ "\nYour hobbies include:\t"+ ( (People)currentUser.getEntity()).getHobbies() );
	
		toPrintConnection(currentUser);
		
	}
	
	/**@method		showSpecificOrganisationProfile(Node current_user)
	 * display result only for organisation sub type entity
	 *  summaries differ as each type holds different values
	 * **/
	public static void showSpecifiOrganisationProfile(Node currentUser){
		System.out.println("Hello, "+ currentUser.getEntity().getUserName() +". Welcome to the social network."
				+ "\nHere are your details: "
				+ "\nYour login id is:\t"+ currentUser.getEntity().getId()
				+ "\nYour Domain is:\t"+ ( (Organisation) currentUser.getEntity()).getDomain()
			);
		
		toPrintConnection(currentUser);
	}

}
