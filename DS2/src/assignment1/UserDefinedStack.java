package assignment1;

import linkedList.SinglyLinkedList;

/**
 * ClassName  : UserDefinedStack
 * @author 	  : Vaishali Jain
 * Description: implementing user defined stack using userDefined Linked list
 * @param <T>
 */
public class UserDefinedStack<T extends Comparable<T>> {
	
	//creating generic object of singly Linked list class 
	SinglyLinkedList<T> linkedList = new SinglyLinkedList<T>(); 
	
	/**
	 * method to push data at top of the stack
	 * @param data
	 * @return
	 */
	public boolean push(T data){
		return(linkedList.addAtBeginning(data));
		
	}
	
	public T peek(){
		T topData;
		topData=linkedList.getParticularPositionElement(1);
		return topData;
	}
	
	/**
	 * method to pop data from the top of the stack
	 * @return
	 */
	public T pop(){
		T poppedData;
		poppedData=linkedList.removeFirstElement();
		return poppedData;
	}
	
	/**
	 * method to get the size of the array
	 * @return
	 */
	public int getStackSize(){
		return linkedList.getListSize();
	}
}
