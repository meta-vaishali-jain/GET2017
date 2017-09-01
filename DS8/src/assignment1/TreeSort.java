package assignment1;

/**
 * ClassName : TreeSort
 * @author   : Vaishali Jain
 * Description: Class to implement TreeSort by adding elements in the form of binary search tree
 * 				and then find out the inorder traversal
 * @param <T>
 */
public class TreeSort<T extends Comparable<T>> {
	//describe root of the tree
	private Node<T> root;
	//describe number of elements in tree
	private int elements;
	//array of nodes in the sorted form
	private Object[] nodes;
	//index of the array initially as 0
	private int index;
	
	//default constructor
	public TreeSort(){
		root=null;
		index=0;
	}
	
	/**
	 * member function to insert data in the binary search tree by comparing it with its root value
	 * @param data
	 */
	public boolean insertData(T data){
		if(data==""||data==null){
			return false;
		}
		elements++;
		//calls overloaded method
		root=insertData(data,root);
		return true;
	}
	
	/**
	 * overloaded member function
	 * recursively calls insert data on the root till the position is determined to insert new data in tree
	 * @param data  describes data to be inserted
	 * @param root  describes root of the tree
	 * @return
	 */
	private Node<T> insertData(T data, Node<T> root){
		//if found node as null than add new node at tha position
		if(root==null){
			return new Node<T>(data);
		}
		if(contains(data)){
			return null;
		}
		//if data is large than root node than move to right subtree
		else if(data.compareTo((T) root.getNodeData())>0){
			root.setRightPointer(insertData(data,root.getRightPointer()));
		}
		//if data is less than root than move to left subtree
		else{
			root.setLeftPointer(insertData(data,root.getLeftPointer()));
		}
		return root;
	}
	
	/**
	 * to check if roll number already exist
	 * @param data
	 * @return
	 */
	public boolean contains(T data){
		 if (root != null) {
	            treeSort(root.getLeftPointer());
	            if(data.compareTo(root.getNodeData())==0){
	            	return true;
	            }
	            treeSort(root.getRightPointer());
	        }
		return false;
	}
	
	/**
	 * member function to sort the binary search tree by recursively iterating the tree as inorder traversal 
	 * @return
	 */
	public Object[] treeSort(){
		if(root==null){
			return null;
		}
		nodes=new Object[elements];
		nodes=treeSort(root);
		return nodes;
	}
	
	/**
	 * overloaded method
	 * inorder traversal of binary search tree to sort the input
	 * @param root
	 * @return
	 */
	private Object[] treeSort(Node<T> root) {
		 if (root != null) {
	            treeSort(root.getLeftPointer());
	            nodes[index++]=root.getNodeData();
	            treeSort(root.getRightPointer());
	        }
		return nodes;
	}
	
	

	public int getElements() {
		return elements;
	}

}