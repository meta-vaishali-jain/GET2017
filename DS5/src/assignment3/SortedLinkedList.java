package assignment3;

import java.util.LinkedList;

/**
 * ClassName  : SortedLinkedList
 * @author    : Vaishali Jain
 * Description: class having add method to insert a number in sorted order in linked list using recursive approach. 
 * @param <T>
 */
public class SortedLinkedList<T> {
	//inbuilt linked list class object
	LinkedList<Object> sortedLinkedList;
	
	//default constructor 
	public SortedLinkedList(){
		sortedLinkedList=new LinkedList<Object>();
	}
	
	/**
	 * add method to add element in the sorted linked list
	 * @param element
	 */
	public boolean add(Object element){
		if(element==null){
			return false;
		}
		//initially counter is 0 sorting starts from head pointer
		int counter=0;
		add(element,counter);
		return true;
	}
	
	//getter to get sorted linked list
	public LinkedList<Object> getSortedLinkedList() {
		return sortedLinkedList;
	}

	//setter to set sorted linked list
	public void setSortedLinkedList(LinkedList<Object> sortedLinkedList) {
		this.sortedLinkedList = sortedLinkedList;
	}

	/**
	 * overloaded method
	 * add element in linked list using recursive approach
	 * @param element
	 * @param counter
	 */
	public void add(Object element,int counter){
		//if linked list is empty add at beginning
		if(sortedLinkedList.size()==0){
			sortedLinkedList.add(element);
		}
		//if element is largest element from all element in linked list
		else if(sortedLinkedList.size()==counter){
			sortedLinkedList.addLast(element);
		}else{
			if(element.toString().compareTo(sortedLinkedList.get(counter).toString())>0){
				add(element,counter+1);
			}else{
				sortedLinkedList.add(counter, element);
			}
		}
	}
	
	//method to get first element of linked list
	public Object getFirst(){
		if(sortedLinkedList.size()==0){
			return null;
		}
		return sortedLinkedList.getFirst();
	}
	
	//method to get last element of linked list
	public Object getLast(){
		if(sortedLinkedList.size()==0){
			return null;
		}
		return sortedLinkedList.getLast();
	}
	
	//method to get particular index value
	public Object get(int index){
		if(index<0||index>=sortedLinkedList.size()){
			return null;
		}
		return sortedLinkedList.get(index);
	}
}
