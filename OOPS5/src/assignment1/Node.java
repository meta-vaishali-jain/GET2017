package assignment1;
/**
 * ClassName:Node
 * @author  :to create node of each user
 * 
 */
public class Node {
	Entity entity;
	Connection connectedTo;
	
	public Node(Entity new_user) {
		this.entity = new_user;
		connectedTo = new Connection();
	}
	
	public void addAConnection(Node nodeToAdd) {
		this.connectedTo.addAConnection(nodeToAdd);
	}

	public Entity getEntity() {
		return this.entity;
	}

	public Connection getConnectionTo() {
		return connectedTo;
	}
	
}
