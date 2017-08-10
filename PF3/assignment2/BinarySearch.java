package assignment2;
import java.util.*;
/**
 * Class Name : BinarySearch
 * @author    : Vaishali Jain
 * Description: Search element in array using linear searching
 */
public class BinarySearch {
	/**
	 * method for searching using binary search possible only for sorted array
	 * @param array
	 * @param target
	 * @return
	 */
	public int binarySearch(int[] array, int searchElement) {
		////Here we are using method overriding for user convienience and to decrease chances of wrong input
	   return binarySearch(array, 0, array.length-1, searchElement);
	}

	public int binarySearch(int[] array, int start, int end, int target) {
		//only for ascending order
		//throw exception if size is negative
		if(array.length<=0)
			throw new NegativeArraySizeException();
		if(array[0]>array[1]){
			throw new InputMismatchException();
		}
		//compute middle index
	   int middle = (start + end) / 2;
	   if(end < start) {
	       return -1;
	   }
      if(target==array[middle]) {
	       return middle+1;
	   } else if(target<array[middle]) {
	       return binarySearch(array, start, middle - 1, target);
	   } else {
	       return binarySearch(array, middle + 1, end, target);
	   }
	}
}

