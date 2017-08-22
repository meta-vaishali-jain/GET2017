package assignment4;

/**
 * ClassName : DoublyLinkedList
 * 
 * @author : Vaishali Jain
 * @param :  <T>
 * Description: Describe complete Doubly Linked List and all operations on that list
 */
public class DoublyLinkedList<T extends Comparable<T>>  {
	private Node<T> headPointer;
	private Node<T> tailPointer;
	private int listSize;
	
	/*
	 * default constructor it will set at the time of linked list creation its
	 * headpointer and tailPointer to null and size to 0
	 */
	DoublyLinkedList() {
		headPointer = null;
		tailPointer=null;
		listSize = 0;
	}
	
	/**
	 * method to check list is empty or not if the headPointer of the list is
	 * empty than there is no element in list, list is empty
	 * 
	 * @return
	 */
	public boolean isListEmpty() {
		if (headPointer == null ||tailPointer==null)
			return true;
		else
			return false;
	}
	
	/**
	 * method to add the node at the beginning of the linked list
	 * 
	 * @param nodeData value of the node to be added
	 */
	public void addAtBeginning(T nodeData) {
		// creation of node with the given element
		Node<T> element = new Node<T>(nodeData);
		// check if list is empty,if not empty then set nextpointer of element
		// as headpointer
		if (!isListEmpty()) {
			element.setNextElement(headPointer);
			headPointer.setPreviousElement(element);
			headPointer=element;
		}
		// updating headpointer and tailPointer to element if list is empty
		else{
		headPointer = element;
		tailPointer=element;
		}
		// increasing list size
		listSize++;
		DisplayOutput.messageHandler("Element added successfully at begining");
	}
	
	/**
	 * method to add node at the end of the linked list
	 * 
	 * @param nodeData
	 */
	public void addAtLast(T nodeData) {
		// creation of node with the given element
		Node<T> element = new Node<T>(nodeData);
		// check if list is empty,if not empty then set element at last by
		// itreating list to the last
		if (!isListEmpty()) {
			tailPointer.setNextElement(element);
			element.setPreviousElement(tailPointer);
		}
		// if list is empty
		else {
			headPointer = element;
		}
		tailPointer=element;
		// increasing list size
		listSize++;
		DisplayOutput.messageHandler("Element added successfully at last");
	}
	
	/**
	 * method to add node at the particular given position
	 * 
	 * @param position
	 * @param nodeData
	 */
	public boolean addAtParticularPosition(int position, T nodeData) {
		// creation of node with the given element
		Node<T> element = new Node<T>(nodeData);
		// to check if position is greater than list size
		if (position > listSize + 1) {
			DisplayOutput.messageHandler("Position is greater than list size");
			return false;
		}
		// if position is equal to 1 call the addAtBeginning method
		if (position == 1) {
			addAtBeginning(nodeData);
			return true;
		}
		// if position is last than call the addAtLast method
		if (position == listSize + 1) {
			addAtLast(nodeData);
			return true;
		}
		// if position is less than 1 than return with error message
		if (position < 1) {
			DisplayOutput.messageHandler("Invalid Position");
			return false;
		}
		Node<T> previousNode = null;
		Node<T> currentNode = headPointer;
		int nodeCount = 1;
		// loop to iterate list till the position
		while (currentNode != null && nodeCount < position) {
			previousNode = currentNode;
			currentNode = currentNode.getNextElement();
			nodeCount++;
		}
		// updating pointer
		previousNode.setNextElement(element);
		element.setPreviousElement(previousNode);
		currentNode.setPreviousElement(element);
		element.setNextElement(currentNode);
		listSize++;
		DisplayOutput.messageHandler("Element added succefully at position "+ position);
		return true;
	}
	
	/**
	 * method to remove element from list based on its value
	 * 
	 * @param element
	 */
	public boolean removeElementBasedOnValue(T element) {
		boolean flag;
		Node<T> previousNode = null;
		// to store count of number of times element found in list
		int nodeFoundCount = 0;
		Node<T> currentNode = this.headPointer;
		if(headPointer.getNodeData().equals(element)){
			nodeFoundCount++;
			headPointer=headPointer.getNextElement();
			headPointer.setPreviousElement(null);
		}else{
		while (currentNode != null) {
			// iterating list till element not found
			if (!currentNode.getNodeData().equals(element)) {
				previousNode = currentNode;
				currentNode = currentNode.getNextElement();
			}
			// updating pointers if found element
			else {
				Node<T> deletedNode = currentNode;
				previousNode.setNextElement(currentNode.getNextElement());
				currentNode.getNextElement().setPreviousElement(previousNode);
				currentNode = currentNode.getNextElement();
				deletedNode = null;
				listSize--;
				nodeFoundCount++;
			}
		}
		}
		// displaying message
		if (nodeFoundCount == 0) {
			DisplayOutput.messageHandler("Element not found in the list");
			 flag=false;
		} else {
			DisplayOutput.messageHandler("Element deleted successfully from " + nodeFoundCount + " positions");
			flag= true;
		}
		return flag;
	}
	
	/**
	 * method to remove element from list based on position
	 * 
	 * @param position
	 */
	public boolean removeElementBasedOnPosition(int position) {
		Node<T> deletedNode;
		// to check if position is greater than list size
		if (position > listSize) {
			DisplayOutput.messageHandler("Position is greater than list size");
			return false;
		}
		// if position is less than 1 than return with error message
		if (position < 1) {
			DisplayOutput.messageHandler("Invalid Position");
			return false;
		}
		// if position is equal to 1 call then update only headPointer
		if (position == 1) {
			deletedNode = headPointer;
			headPointer = headPointer.getNextElement();
			DisplayOutput.messageHandler("Node "+ deletedNode.getNodeData() + " deleted successfully");
			listSize--;
			return true;
		}
		Node<T> previousNode = null;
		Node<T> currentNode = this.headPointer;
		int nodeCount = 1;
		//iterate to get node at particular position
		while (currentNode != null && nodeCount < position) {
			previousNode=currentNode;
			currentNode = currentNode.getNextElement();
			nodeCount++;
		}
		//update the pointers 
		deletedNode=currentNode;
		previousNode.setNextElement(currentNode.getNextElement());
		currentNode.getNextElement().setPreviousElement(previousNode);
		currentNode = null;
		DisplayOutput.messageHandler("Node "+ deletedNode.getNodeData() + " deleted successfully");
		listSize--;
		return true;
	}
	
	/**
	 * method to get element based on its position
	 * @param position
	 * @return
	 */
	public T getParticularPositionElement(int position) {
		T data = null;
		int nodeCount = 1;
		// to check if position is greater than list size
		if (position > listSize) {
			DisplayOutput.messageHandler("Position is greater than list size");
		}
		// if position is less than 1 than return with error message
		else if (position < 1) {
			DisplayOutput.messageHandler("Invalid Position");
		} 
		//if position is equals 1 then get value of headPointer
		else if (position == 1) {
			data = headPointer.getNodeData();
			DisplayOutput.messageHandler("Element found : " + data);
		} 
		//iterate list till the position and then get the node value
		else {
			Node<T> currentNode = this.headPointer;
			while (currentNode != null && nodeCount < position) {
				currentNode = currentNode.getNextElement();
				nodeCount++;
			}
			data = currentNode.getNodeData();
			DisplayOutput.messageHandler("Element found : " + data);
		}
		return data;
	}
	
	/**
	 * method to reverse the linked list completely
	 */
	public void reverseList(){
		if(listSize==0){
			DisplayOutput.messageHandler("linked list empty");
			return;
		}
		Node<T> temporaryNode=null;
		Node<T> nextNode=null;
		tailPointer=headPointer;
		while(headPointer!=null){
			nextNode=headPointer.getNextElement();
			headPointer.setNextElement(temporaryNode);
			headPointer.setPreviousElement(nextNode);
			temporaryNode=headPointer;
			headPointer=nextNode;	
		}
		headPointer=temporaryNode;
		DisplayOutput.messageHandler("linked list reversed successfully");
	}
	
	/**
	 * method to swap two linked list nodes
	 * @param currentPointer
	 * @param nextPointer
	 */
	public void swap(Node<T> currentPointer,Node<T> nextPointer){
		//updating their data value
		T temporaryData;
		temporaryData=currentPointer.getNodeData();
		currentPointer.setNodeData(nextPointer.getNodeData());
		nextPointer.setNodeData(temporaryData);
	}
	
	/**
	 * method to sort the linked list
	 */
	public void sort() {
		Node<T> currentPointer;
		Node<T> smallestPointer;
		Node<T> nextPointer;
		currentPointer = headPointer;
		while (currentPointer != null) {
			smallestPointer = currentPointer;
			nextPointer = currentPointer.getNextElement();
			while (nextPointer != null) {
				if (nextPointer.getNodeData().compareTo(smallestPointer.getNodeData()) <= 0) {
					smallestPointer = nextPointer;
				}
			nextPointer=nextPointer.getNextElement();
			}
			swap(currentPointer, smallestPointer);
			currentPointer=currentPointer.getNextElement();
		}
	}

}
