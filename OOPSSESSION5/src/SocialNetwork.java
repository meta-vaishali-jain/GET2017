import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

/**
 * ClassName  : SocialNetwork
 * @author    : Vaishali Jain
 * Description: Controller class of the social network 
 * 				implementing all tasks
 */
public class SocialNetwork {
	private Record record;
	private Map<Integer, Node> nodeList;
	private ArrayList<User> userList;
	private ArrayList<Organisation> organisationList;
	
	//default Constructor
	public SocialNetwork() {
		record = new Record();
		nodeList = new HashMap<Integer, Node>();
		userList=new ArrayList<User>();
		organisationList=new ArrayList<Organisation>();
		createNodes();
		storeUserAndOrganisation();
	}
	
	/**
	 * method to create node containing full details of each entity with its connection
	 */
	public void createNodes() {
		//read profiles file
		 record.readProfiles("Profiles.csv");
		 //read connection file
		 record.getConnection("Connections.csv");
		 nodeList=record.getProfile();
	}
	
	/**
	 * separate entities on the basis of user and orgainsation type and store that in separate list
	 */
	public void storeUserAndOrganisation(){
		for (Map.Entry<Integer,Node> entry : nodeList.entrySet())
		{
		   if(entry.getValue().getEntity() instanceof User){
			   userList.add((User)entry.getValue().getEntity());
		   }else{
			   organisationList.add((Organisation)entry.getValue().getEntity());
		   }
		}
	}
	
	/**
	 * method to print users summary
	 * @return
	 */
	public ArrayList<User> printUsersSummary(){
		return userList;
	}
	
	/**
	 * method to print orgainsation summary
	 * @return
	 */
	public ArrayList<Organisation> printOrganisationsummary(){
		return organisationList;
	}
	
	/**
	 * method to add connection among entities
	 * @param requestingId
	 * @param connectionId
	 */
	public void add(int requestingId, int connectionId) {
		HashSet<Entity> connectionList = nodeList.get(requestingId).connectedTo.getConnections();
		connectionList.add(nodeList.get(connectionId).getEntity());
		nodeList.get(requestingId).connectedTo.setConnections(connectionList);
	}
	
	/**
	 * method to check if id exist or not
	 * @param ID
	 * @return
	 */
	public boolean ifIDExist(int ID){
		return nodeList.containsKey(ID);
	}
	
	public Map<Integer, Node> getNodeList() {
		return nodeList;
	}

	/**
	 * To add connection in both requestingID list and connectionID list
	 * @param requestingId 
	 * @param connectionId
	 * @return
	 */
	public boolean addConnection(int requestingId, int connectionId) {
		HashSet<Entity>connectionList=nodeList.get(requestingId).getConnectionTo().getConnections();
		Iterator<Entity> iter = connectionList.iterator();
		while (iter.hasNext()) {
		   if(iter.next().getEntityId()==connectionId){
			   return false;
		   }
		}
		add(requestingId, connectionId);
		add(connectionId, requestingId);
		record.writeConnectionToFile(nodeList);
		return true;
	}
	
	/**
	 * method to display full social network containing all connections
	 * @return
	 */
	public int[][] displaySocialNetwork(){
		Graph graph=new Graph();
		return graph.generateAdjacencyMatrix(nodeList);
	}
	
	/**
	 * method to get entity on the basis of name
	 * @param entityName
	 * @return
	 */
	public ArrayList<Node> getEntityByName(String entityName){
		ArrayList<Node> nameBasedEntityList=new ArrayList<Node>();
		for (Map.Entry<Integer,Node> entry : nodeList.entrySet()){
			if(entry.getValue().getEntity().getEntityName().equalsIgnoreCase(entityName)){
				nameBasedEntityList.add(entry.getValue());
			}
		}
		return nameBasedEntityList;	
	}
	
	
}
