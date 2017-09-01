package assignment1;

/**
 * ClassName  : Node
 * @author    : Vaishali Jain
 * Description: Class used for creating node of the binary search tree
 * @param <T>
 */
public class Node<T> {
	//data part of the node
	private T nodeData;
	//left pointer pointing to the left subtree
	private Node<T> leftPointer;
	//right pointer pointing to the right subtree
	private Node<T> rightPointer;
	
	//parameterize constructor
	public Node(T data){
		this.nodeData=data;
		leftPointer=null;
		rightPointer=null;
	}
	
	//getter to get node data
	public T getNodeData() {
		return nodeData;
	}
	
	//setter to set node data
	public void setNodeData(T nodeData) {
		this.nodeData = nodeData;
	}
	
	//getter to get left pointer of the node
	public Node<T> getLeftPointer() {
		return leftPointer;
	}
	
	//setter to set left pointer of the node
	public void setLeftPointer(Node<T> leftPointer) {
		this.leftPointer = leftPointer;
	}
	
	//getter to get right pointer of the node
	public Node<T> getRightPointer() {
		return rightPointer;
	}
	
	//setter to set right pointer of the node
	public void setRightPointer(Node<T> rightPointer) {
		this.rightPointer = rightPointer;
	}
	
	
}
