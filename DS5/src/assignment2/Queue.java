package assignment2;

import java.util.LinkedList;
import java.util.NoSuchElementException;

/**
 * ClassName  : Queue
 * @author    : Vaishali Jain
 * Description: UserDefined class Queue using inbuilt LinkedList class
 *
 */
public class Queue<T> {
	LinkedList<Object> linkedList;
	
	//default constructor
	public Queue(){
		linkedList=new LinkedList<Object>();
	}
	
	/**
	 * method to add element in the queue
	 * @param element
	 * @return
	 */
	public boolean add(Object element){
		if(element==null){
			return false;
		}
		linkedList.addLast(element);
		return true;
	}
	
	/**
	 * method to check if queue is empty
	 * @return
	 */
	public boolean isEmpty(){
		if(linkedList.size()==0){
			return true;
		}
		return false;
	}
	
	/**
	 * method to remove element from the queue if queue empty throw exception
	 * @return
	 */
	public Object remove(){
		if(!isEmpty()){
			return linkedList.removeFirst();
		}
		else{
			throw new NoSuchElementException();
		}
	}
	
	/**
	 * method to remove element from queue but if queue empty return null
	 * @return
	 */
	public Object poll(){
		if(!isEmpty()){
			return linkedList.removeFirst();
		}
		else{
			return null;
		}
	}
	
	/**
	 * method to get element from queue and throws exception if queue is empty
	 * @return
	 */
	public Object element(){
		if(!isEmpty()){
			return linkedList.getFirst();
		}
		else{
			throw new NoSuchElementException();
		}
	}
	
	/**
	 * method to get element from queue and return null if queue is empty
	 * @return
	 */
	public Object peek(){
		if(!isEmpty()){
			return linkedList.getFirst();
		}
		else{
			return null;
		}
	}
	
	/**
	 * method to get size of queue
	 * @return
	 */
	public int size(){
		return linkedList.size();
	}
	
	/**
	 * method to clear queue
	 */
	public void clear(){
		linkedList.clear();
	}
}
