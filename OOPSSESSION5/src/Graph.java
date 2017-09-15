
import java.util.Iterator;
import java.util.Map;

/**
 * ClassName : Graph
 * @author   : Vaishali Jain
 * Description: class to print network of connections using 2D matrix.
 */
public class Graph {
	//connection matrix store connection
	private int[][] connectionMatrix;
	
	/**
	 * method to generate connection matrix on the basis of node and its list of connection
	 * @param nodeList
	 * @return
	 */
	public int[][] generateAdjacencyMatrix(Map<Integer, Node>nodeList){
		//2d matrix of size equals to number of nodes+1
		connectionMatrix=new int[nodeList.size()+1][nodeList.size()+1];
		int i=1;
		//initializing firat row nd first column as the entity ID only
		for (Map.Entry<Integer,Node> entry : nodeList.entrySet()){
			connectionMatrix[i][0]=entry.getKey();
			connectionMatrix[0][i]=entry.getKey();
			i++;
		}
		i=1;
		//from row 1 column 1 if connection exist then set that value to 1 otherwise set that value to 0
		for (Map.Entry<Integer,Node> entry : nodeList.entrySet()){
			Iterator<Entity> iter = entry.getValue().connectedTo.getConnections().iterator();
			
			while (iter.hasNext()) {
				int a=iter.next().getEntityId();
				for(int j=0;j<connectionMatrix.length;j++){
					if(connectionMatrix[0][j]==a){
						connectionMatrix[i][j]=1;
					}
				}
				
			}
			i++;
		}
		//return connection matrix
		return connectionMatrix;
	}
	
	
}
