
import java.util.HashSet;

/**
 * ClassName  : Connection
 * @author    : Vaishali Jain
 * Description: Connection class containing list of connections for each entity.
 */
public class Connection {
	//Hash set containig connections
	private HashSet<Entity> connections;
	
	//default constructor
	public Connection(){
		connections = new HashSet<Entity>();
	}
	
	//getter to get connections
	public HashSet<Entity> getConnections() {
		return connections;
	}
	
	//setter to set connections
	public void setConnections(HashSet<Entity> connections) {
		this.connections = connections;
	}
	
	
}
