package assignment1;

/**
 * ClassName   : Node
 * @author     : Vaishali Jain
 * Description : Describing the node with its data and the ID at which node is inserted
 * @param <T>
 */
public class Node<T> {
	private T nodeData;
	private int nodeID;
	
	//parameterize constructor
	public Node(T data,int nodeNumber){
		this.nodeData=data;
		this.nodeID=nodeNumber;
	}
	
	//getter to get node data
	public T getNodeData() {
		return nodeData;
	}
	
	//setter to set node data
	public int getNodeNumber() {
		return nodeID;
	}
	
}
