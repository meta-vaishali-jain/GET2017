package assignment2;

import java.util.Arrays;
import assignment1.UserDefinedArrayList;

/**
 * ClassName   : ConcatenateArrayList
 * @author     : Vaishali Jain
 * Description : Class to join two array list and inherting UserDefinedArrayList
 * @param <E>
 */
public class ConcatenateArrayList<E> extends UserDefinedArrayList<E> {
	
	/**
	 * method to add elements of second array list to first array list and ioncreasing the size of the first array list
	 */
	public  UserDefinedArrayList<E> joinTwoArrayList(UserDefinedArrayList<E> firstList,UserDefinedArrayList<E> secondList) {
		
		firstList.setArray(Arrays.copyOf(firstList.getArray(), firstList.getArraySize() + secondList.getArraySize()));
		for (int i = 0; i < secondList.getArraySize(); i++) {
			firstList.addItem(secondList.getArray()[i]);
		}
		return firstList;
	}
	
}
