package assignment1;

import java.io.*;
import java.util.*;
import java.util.Map.Entry;
import javax.swing.plaf.synth.SynthSeparatorUI;

/**
 * @Class     :	Graph
 * @author    : Vaishali Jain
 * Description: establishes connections between two entities
 *              maintains mapping of connection of each to other user
 */

public class Graph {
	private static BufferedReader reader;
	
	//Map of all entity profiles
	private static Map<Integer, Node> userProfiles = new HashMap<Integer, Node>();	
	//Map of all connections of each node
	public static Map<Node, Connection> userConnections = new HashMap<Node, Connection>();
	
	/**
	 * @method	getProfileByName()
	 * search an entity from a map of entities
	 * when duplicate names are found,
	 * their unique ids are compared by user input
	 * @return	Node: current user's profile details 
	 * */
	public static Node getProfileByName() {
		Scanner input = new Scanner(System.in);
		System.out.println("\n\nEnter you name to login");
		String userName = input.nextLine();
		
		/**To remove upper limit on number of possible matches
		 * iterating a list of duplicate names lists
		 * **/
		List<Node> matchedNodes = new ArrayList<Node>();
		Set<Entry<Integer, Node>> set = userProfiles.entrySet(); 
		Iterator<Entry<Integer, Node>> iterator = set.iterator();
		
		while(iterator.hasNext()) {
			Map.Entry<Integer, Node> me = (Map.Entry<Integer, Node>) iterator.next();
			
			if( userName != null && me.getValue().getEntity().getUserName().trim().equals(userName.trim())) {
				matchedNodes.add(me.getValue());
			}
		}
		
		/**
		 * if no matched node found, then incorrect user id
		 * When multiple matches of same name
		 * */
		if(matchedNodes != null && matchedNodes.size() > 0) {
			if(matchedNodes.size() == 1) {
				return matchedNodes.get(0);
			}
			System.out.println("Enter your user id: ");
			int id = input.nextInt();
			
			for(int j =0; j< matchedNodes.size(); j++) {
				if(matchedNodes.get(j).getEntity().getId() == id) {
					return matchedNodes.get(j);
				}
			}
			return null;
		}
		input.close();
		return null;
	}
	
	/**@Method	readuserProfiles(filename)
	 * reads all user profile and details from UserProfile.csv
	 * @return	mapping of unique id codes and other profile details
	 * **/
	public static Map<Integer, Node> readUserProfiles(String filename){
		try {
			reader = new BufferedReader(new FileReader(new File(filename)));
			
			String userDetails;
			
			while((userDetails = reader.readLine()) != null) {	
				Entity u = new Entity().setValues(userDetails);
				userProfiles.put(u.getId(), new Node(u));
			}			
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		return userProfiles;
	}
	
	/**
	 * @Method	readUserConnections(filename)
	 * read connect of each user to other users in user profile
	 * determines relationship between users
	 * @return	type = Map<Node, Node[]> each node connected to array of nodes
	 * */
	public static Map<Node, Connection> readUserConnections(String filename){
		try {
			reader = new BufferedReader(new FileReader(new File(filename)));
			
			String connection;
			while((connection = reader.readLine()) != null) {
				addAConnection(connection);
			}
			
		}catch(IOException e) {
			e.printStackTrace();
		}
		return userConnections;
	}

	/**
	 * @Method	addAConnection(String line)
	 * read user connections from file
	 * creating and updating nodes by creating a connection between them
	 * **/
	public static void addAConnection(String line) {
		String[] s = line.trim().split(":");

		Node n1, n2;
		if (line != null && s.length > 0 && (n1 = isValidNode(s[0])) != null) {
			String[] s1 = s[1].trim().split(",");

			if (s[1] != null && s1.length > 0) {
				for (String connection : s1) {
					if ((n2 = isValidNode(connection)) != null) {						
						n1.addAConnection(n2);
					}
				}
				userConnections.put(n1, n1.connectedTo);
			}
		}
	}
	
	/**
	 * @method	isValidNode(String id)
	 * validate a user input product id that is mapped to appropriate user entity
	 * @return	type = Node, if null, invalid product code
	 * 						else valid node reference
	 * */
	public static Node isValidNode(String id) {
		int userID = Integer.parseInt(id.trim());
		if ( userID != -1 && userProfiles.size() >0 && userProfiles.containsKey(userID) ) {
			return userProfiles.get(userID);
		}
		return null;		
	}
}
