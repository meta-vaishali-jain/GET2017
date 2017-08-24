package arrayList;
import java.util.Arrays;

/**
 * ClassName  : UserDefinedArrayList
 * @author    : Vaishali Jain
 * Description: describing all operation on generic list describing ArrayList class
 * @param <E>
 */
public class UserDefinedArrayList<E>  {
	private Object[] array;
	private int arraySize = 0;
	private static final int DEFAULT_SIZE = 3;
	
	//default constructor initializing object array with default size
	public UserDefinedArrayList() {
		array = new Object[DEFAULT_SIZE];
	}
	
	/**
	 * getters and setters
	 * @return
	 */
	public Object[] getArray() {
		return array;
	}

	public void setArray(Object[] array) {
		this.array = array;
	}

	public int getArraySize() {
		return arraySize;
	}

	public void setArraySize(int arraySize) {
		this.arraySize = arraySize;
	}

	public static int getDefaultSize() {
		return DEFAULT_SIZE;
	}
	
	/**
	 * method to add item in the array list and resizing the arraylist
	 * @param element
	 */
	public void addItem(Object element) {
		if (arraySize < array.length) {
			array[arraySize++] = element;
			//System.out.println(arraySize);
		} else {
			array = Arrays.copyOf(array, array.length * 2);
			array[arraySize++] = element;

		}
	}
	
	/**
	 * method to add an element at the particular position
	 * @param element
	 * @param position
	 */
	public boolean addAtParticularPosition(Object element, int position) {
		if(arraySize==array.length){
			array = Arrays.copyOf(array, array.length * 2);
		}
		if (--position > arraySize) {
			//DisplayOutput.messageHandler("Position greater than array length");
			return false;
		}
		if(position<1){
			//DisplayOutput.messageHandler("Invalid Position");
			return false;
		}
		for (int i = arraySize-1; i > position; i--) {
			array[i + 1] = array[i];
		}
		array[position] = element;
		arraySize++;
		return true;
	}
	
	/**
	 * method to get element position based on its value
	 * @param element
	 */
	public int getElementPosition(Object element) {
		for (int i = 0; i < arraySize; i++) {
			System.out.println(array[i]);
			if (array[i].equals(element)) {
				//DisplayOutput.messageHandler("Element found at position " + ++i);
				return i;
			}
		}

		//DisplayOutput.messageHandler("Element not found");
		return 0;
	}
	
	/**
	 * method to remove element based on position
	 * @param position
	 */
	public Object removeElementBasedOnPosition(int position) {
		if (position > arraySize||position<1) {
			//DisplayOutput.messageHandler("Position not exist");
			return null;
		}
		Object deletedNode=array[position-1];
		for (int i = position; i < arraySize; i++) {
			array[i - 1] = array[i];
		}
		//DisplayOutput.messageHandler("Element deleted successfully");
		array[arraySize - 1] = 0;
		arraySize--;
		return deletedNode;
	}
	
	/**
	 * method to remove elemnts based on its value ,list may contain more than one value
	 * @param element
	 * @return
	 */
	public boolean removeParticularElement(Object element) {
		int elementFound=0;
		boolean flag;
		for (int i = 0; i < arraySize; i++) {
			if (array[i].equals(element)) {
				for (int j = i+1; j < arraySize; j++) {
					array[j-1] = array[j];
				}
				arraySize--;
				elementFound++;
				//DisplayOutput.messageHandler("Element removed successfully");
			}
		}
		if(elementFound==0){
			flag=false;
			//DisplayOutput.messageHandler("Element not found");
		}else
			flag=true;
		return flag;
	}
	
	/**
	 * method to clear list
	 */
	public void clearList() {
		array = null;
		arraySize = 0;
		//DisplayOutput.messageHandler("List cleared");

	}
	
	/**
	 * method to reverse the array by copying array revrse into another array
	 */
	public void reverseArray() {
		UserDefinedArrayList<Object> array1 = new UserDefinedArrayList<Object>();
		int j = 0;
		for (int i = arraySize - 1; i >= 0; i--) {
			array1.array[j++] = array[i];
		}
		array = array1.array.clone();
	}
	
	// method to get element based on position
	public Object getElementBasedOnPosition(int position) {
		//if position is invalid
		if (position > arraySize) {
			//DisplayOutput.messageHandler("Position is greater than array size");
			return null;
		}
		if(position<1){
			//DisplayOutput.messageHandler("Invalid position");
			return null;
		}
		return array[position - 1];
	}
	
	//method performing swapping function on array between tow positions
	private <E> void swap(E[] array,int i,int j){
		if(i!=j){
			E temp=array[i];
			array[i]=array[j];
			array[j]=temp;
		}
	}

	/**
	 * method performing sorting by extending Comparable interface and using selection sort 
	 */
	public <E extends Comparable<E>> void sort(){
		for(int i=0;i<arraySize-1;i++){
			int smallest=i;
			for(int j=i+1;j<arraySize;j++){
				if(array[j].toString().compareTo(array[smallest].toString())<=0){
					smallest=j;
				}
			}
			swap(array,i,smallest);
		}
	}
}
