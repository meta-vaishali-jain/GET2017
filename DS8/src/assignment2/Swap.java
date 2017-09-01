package assignment2;

/**
 * ClassName  : Swap
 * @author    : Vaishali Jain
 * Description: Class to perform swapping function on the index element of the array and return the swapped array
 * @param <T>
 */
public class Swap<T> {
	public T[] swap(int dataOne,int dataTwo ,T array[]){
		T temporary;
		temporary=array[dataOne];
		array[dataOne]=array[dataTwo];
		array[dataTwo]=temporary;
		return array;
	}
}
