package BinaryTree;

import java.util.Scanner;

/**
 * ClassName   :BinaryTree 
 * @author     :Vaishali Jain
 * Description : perform operations on the normal binary tree that is insertion and the traversing 
 * @param <E>
 */
public class BinaryTree<E> {
	private Node<E> root;
	private String inOrderedString="";
	private String postOrderedString="";
	private String preOrderedString="";
	
	//default constructor
	public BinaryTree() {
		root = null;
	}
	
	//parameterize constructor initialising node with data
	public BinaryTree(E data) {
		root = new Node<E>(data);
	}
	
	
	public String getInOrderedString() {
		return inOrderedString;
	}

	public void setInOrderedString(String inOrderedString) {
		this.inOrderedString = inOrderedString;
	}

	public String getPostOrderedString() {
		return postOrderedString;
	}

	public void setPostOrderedString(String postOrderedString) {
		this.postOrderedString = postOrderedString;
	}

	public String getPreOrderedString() {
		return preOrderedString;
	}

	public void setPreOrderedString(String preOrderedString) {
		this.preOrderedString = preOrderedString;
	}

	//getter to get root of tree
	public Node<E> getRoot() {
		return root;
	}
	
	//setter to set root of node
	public void setRoot(Node<E> root) {
		this.root = root;
	}
	
	/**
	 * method to display choice to user that is where to insert data from the current node
	 */
	public void displayChoice() {
		System.out.println("Enter where you want to insert data");
		System.out.println("1.Left\n2.Right");
	}
	
	/**
	 * method to perform insertion operations for the binary tree insert data depending on the user input
	 * @param data
	 */
	public void insert(E data) {
		Node<E> currentNode;
		if (root == null) {
			currentNode = new Node<E>(data);
			root = currentNode;
		} else {
			insert(data, root);
		}
	}

	/**
	 * overloaded method of the insert method
	 * @param data
	 * @param root
	 */
	private void insert(E data, Node<E> root) {
		Node<E> currentNode = new Node<E>(data);
		Scanner inputScanner = new Scanner(System.in);
		displayChoice();
		int choice = inputScanner.nextInt();
		//if user choice is left
		if (choice == 1) {
			if (root.getLeftPointer() == null) {
				root.setLeftPointer(currentNode);
			} else {
				insert(data, root.getLeftPointer());
			}
		}
		//if user choice is right
		else {
			if (root.getRightPointer() == null) {
				root.setRightPointer(currentNode);
			} else {
				insert(data, root.getRightPointer());
			}
		}
	}
	
	/**
	 * method to display inorder traversal of the tree
	 */
	public void inorder() {
		inorder(this.getRoot());
	}
	
	//overloaded method
	public void inorder(Node<E> root) {
		if (root == null) {
			return;
		} else {
			inorder(root.getLeftPointer());
			
			System.out.println(root.getNodeData());
			inOrderedString+=root.getNodeData();
			inorder(root.getRightPointer());
		}
	}
	
	/**
	 * method to display postorder traversal of the tree
	 */
	public void postOrder() {
		postOrder(this.getRoot());
	}
	
	//overloaded method
	void postOrder(Node<E> root) {
		if (root == null) {
			return;
		} else {

			postOrder(root.getLeftPointer());
			postOrder(root.getRightPointer());
			postOrderedString+=root.getNodeData();
			System.out.println(root.getNodeData());
		}
	}
	
	/**
	 * method to display preorder traversal of tree
	 */
	public void preOrder() {
		preOrder(this.getRoot());
	}
	
	//overloaded method
	public void preOrder(Node<E> root) {
		if (root == null) {
			return;
		} else {
			preOrderedString+=root.getNodeData();
			System.out.println(root.getNodeData());
			preOrder(root.getLeftPointer());
			preOrder(root.getRightPointer());
		}
	}
	
	//method to find if the two trees are mirror to each other
	public boolean isMirror(Node<E> root1,Node<E> root2){
		if (root1 == null && root2 == null)
            return true;
 
        // If only one is empty
        if (root1 == null || root2 == null) 
            return false;
        if(root1.getNodeData()!=root2.getNodeData())
        	return false;
        
        else
        	return isMirror(root1.getLeftPointer(),root2.getRightPointer()) && isMirror(root1.getRightPointer(),root2.getLeftPointer());
	}

}
