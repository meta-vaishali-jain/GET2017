package BinaryTree;

/**
 * ClassName  : Node
 * @author    : Vaishali Jain
 * Description: creating node of the binary tree with a pointer to both the child node
 * @param <T>
 */
public class Node<E> {
	private E nodeData;
	private Node<E> leftPointer;
	private Node<E> rightPointer;
	
	//default constructor
	public Node() {
		this.nodeData = null;
		leftPointer = null;
		rightPointer = null;
	}
	
	//parameterize constructor initializing node with node Data
	public Node(E nodeData){
		this.nodeData=nodeData;
		leftPointer=null;
		rightPointer=null;
	}
	
	//getter to get node value
	public E getNodeData() {
		return nodeData;
	}
	
	//setter to set node value
	public void setNodeData(E nodeData) {
		this.nodeData = nodeData;
	}
	
	//getter to get left pointer of node
	public Node<E> getLeftPointer() {
		return leftPointer;
	}
	
	//setter to set left pointer of node
	public void setLeftPointer(Node<E> leftPointer) {
		this.leftPointer = leftPointer;
	}
	
	//getter to get right pointer of node
	public Node<E> getRightPointer() {
		return rightPointer;
	}
	
	//setter to set right pointer of node
	public void setRightPointer(Node<E> rightPointer) {
		this.rightPointer = rightPointer;
	}
	
}
