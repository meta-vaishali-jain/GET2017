package assignment4;

/**
 * ClassName  : Node
 * @author    : Vaishali Jain
 * @param     : <T>
 * Description: generic class providing description of each node having generic nodeData and pointer pointing to next element
 */
public class Node<T extends Comparable<T>> {
	private T nodeData;
	private Node<T> nextElement;
	private Node<T> previousElement;
	
	//default constructor
	public Node() {
	}
	
	//parameterize constructor
	public Node(T nodeData) {
		this.nodeData = nodeData;
		this.nextElement = null;
		this.previousElement=null;
	}
	
	//getter to get node value
	public T getNodeData() {
		return nodeData;
	}
	
	//setter to set node value
	public void setNodeData(T nodeData) {
		this.nodeData = nodeData;
	}
	
	//getter to get pointer to next element
	public Node<T> getNextElement() {
		return nextElement;
	}
	
	//setter to set pointer to next element
	public void setNextElement(Node<T> nextElement) {
		this.nextElement = nextElement;
	}
	
	//getter to get pointer to previous element
	public Node<T> getPreviousElement() {
		return previousElement;
	}
	
	//setter to set pointer to previous element
	public void setPreviousElement(Node<T> previousElement) {
		this.previousElement = previousElement;
	}
	
	

}