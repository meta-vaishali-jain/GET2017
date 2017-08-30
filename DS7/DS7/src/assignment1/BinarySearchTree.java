package assignment1;

import java.util.Arrays;

/**
 * ClassName  : BinarySearchTree
 * @author    : Vaishali Jain
 * Description: Class to implement the binary search function and to return the leftmost occurence of the elemnt if found 
 * 				and if not found return -1
 * @param <T>
 */
public class BinarySearchTree<T extends Comparable<T>> {
	//node type array containing elements in bst format
	private Node<T>[] elementsInBST;
	//default size of array is 5
	private final static int DEFAULT_SIZE=5;
	//maintaining the id of th node i.e number at which user enter the node
	private int nodeID;
	
	//default constructor
	public BinarySearchTree(){
		elementsInBST=new Node[DEFAULT_SIZE];
		nodeID=0;
	}
	
	/**
	 * method to add element in the array by maintaining binary search tree
	 * @param data
	 * @return
	 */
	public int addElement(T data){
		if(data==""||data==null){
			return -1;
		}
		//calculate position at which the element is to be added
		int position= addElement(data,0);
		//insert element at that position
		elementsInBST[position]=new Node<T>(data,++nodeID);
		return position;
	}
	
	/**
	 * overloaded method
	 * calculate position where the element is to be inserted
	 * maintaining binary search tree
	 * searching for position starts from the index 0 and recursively iterate sub trees
	 * @param data
	 * @param index
	 * @return
	 */
	@SuppressWarnings("unchecked")
	private int addElement(T data,int index){
		//if index is greater than the array size then resize the array
		while(index>=elementsInBST.length){
			elementsInBST=Arrays.copyOf(elementsInBST,elementsInBST.length*2);
		}
		if(elementsInBST[index]!=null){
			//if data to be added is greater than the indexed data then move to right subtree
			if(data.compareTo((T) elementsInBST[index].getNodeData())>0){
				return addElement(data,2*index+2);
			}
			//else move to the left subtree
			else{
				return addElement(data,2*index+1);
			}
		}
		//return index position where element is to be added
		return index;
	}
	
	/**
	 * method to search element in the binary search tree using binary search algorithm
	 * calls overloaded searchElement method with index as 0
	 * @param data
	 * @return
	 */
	public int searchElement(T data){
		if(data==""||data==null){
			return -1;
		}
		 return searchElement(data,0);
	}
	
	/**
	 * overloaded method
	 * searching starts from the 0 index i.e root of the tree
	 * if data is less than the o index than move to left subtree
	 * if data is greater than move to the right sub tree
	 * if equal to the index than return
	 * @param data
	 * @param index
	 * @return
	 */
	private int searchElement(T data,int index){
		if(index>=elementsInBST.length){
			return -1;
		}

		//if element not found 
		if(elementsInBST[index]==null){
			return -1;
		}
		// if data is greater than index data move to the right sub tree
		else if(data.compareTo((T) elementsInBST[index].getNodeData())>0){
			return searchElement(data,2*index+2);
		}
		// if data is greater than index data move to the left sub tree
		else if(data.compareTo((T) elementsInBST[index].getNodeData())<0){
			return searchElement(data,2*index+1);
		}
		//if equal than return node number
		else if(data.compareTo((T) elementsInBST[index].getNodeData())==0){
			return elementsInBST[index].getNodeNumber();
		}
		//if not found return -1
		return -1;
	}
	
}
