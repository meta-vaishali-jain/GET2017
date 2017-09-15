import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

/**
 * ClassName   : Record
 * @author     : Vaishali Jain
 * Description : Record class containg full record
 * 				 read data from file and write data to file
 */
public class Record {
	//Hash map containing details of all entites and their connections
	private Map<Integer, Node> profile;
	
	//getter to get profile
	public Map<Integer, Node> getProfile() {
		return profile;
	}
	
	private static BufferedReader reader;
	BufferedWriter bw;
	
	//default constructor
	public Record() {
		profile = new HashMap<Integer, Node>();
	}
	
	/**
	 * method to readProfiles of user from .csv file
	 * @param fileName
	 * @return
	 */
	public Map<Integer, Node> readProfiles(String fileName) {
		try {
			reader = new BufferedReader(new FileReader(new File(fileName)));
			String entityDetails;
			while ((entityDetails = reader.readLine()) != null) {
				Entity entity;
				String[] splittedEntityDetails = entityDetails.split(",");
				if (splittedEntityDetails[1].equals("user")) {
					entity = new User(
							Integer.parseInt(splittedEntityDetails[0]),
							splittedEntityDetails[2],
							Integer.parseInt(splittedEntityDetails[3]),
							splittedEntityDetails[4]);
				} else {
					entity = new Organisation(
							Integer.parseInt(splittedEntityDetails[0]),
							splittedEntityDetails[2], splittedEntityDetails[3]);
				}
				profile.put(Integer.parseInt(splittedEntityDetails[0]),
						new Node(entity));
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				reader.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return profile;
	}
	
	/**
	 * method to read entity connections from .csv file
	 * @param fileName
	 */
	public void getConnection(String fileName) {
		try {
			reader = new BufferedReader(new FileReader(new File(fileName)));
			String connectionDetails;
			while ((connectionDetails = reader.readLine()) != null) {
				String[] splittedDetails = connectionDetails.split(":");
				if (!(splittedDetails.length == 1)) {
					String[] connections = splittedDetails[1].split(",");
					HashSet<Entity> connectionList = profile.get(Integer
							.parseInt(splittedDetails[0])).connectedTo
							.getConnections();
					for (int i = 0; i < connections.length; i++) {
						connectionList.add(profile.get(
								Integer.parseInt(connections[i])).getEntity());
					}
					profile.get(Integer.parseInt(splittedDetails[0])).connectedTo
							.setConnections(connectionList);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}
	
	/**
	 * method to write connections to .csv file
	 * @param nodeList
	 */
	public void writeConnectionToFile(Map<Integer, Node> nodeList) {
		try {
			bw = new BufferedWriter(new FileWriter(new File("Connections.csv")));
			String entityConnection;
			for (Map.Entry<Integer, Node> entry : nodeList.entrySet()) {
				entityConnection = entry.getKey() + ":";
				HashSet<Entity> connections = entry.getValue()
						.getConnectionTo().getConnections();
				Iterator<Entity> iter = connections.iterator();

				while (iter.hasNext()) {
					entityConnection += (iter.next().getEntityId()) + ",";
				}
				System.out.println(entityConnection);
				bw.write(entityConnection);
				bw.newLine();
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				bw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}
}
