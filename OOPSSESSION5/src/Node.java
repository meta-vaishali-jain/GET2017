/**
 * ClassName  : Node
 * @author    : Vaishali Jain
 * Description: Node class containing complete details of each node.
 */
public class Node {
	Entity entity;
	Connection connectedTo;
	//default constructor
	public Node(Entity newUser) {
		this.entity = newUser;
		connectedTo = new Connection();
	}
	
	//getter to get entity
	public Entity getEntity() {
		return this.entity;
	}
	
	//getter to get connection list corresponding to that entity
	public Connection getConnectionTo() {
		return connectedTo;
	}
	
}
