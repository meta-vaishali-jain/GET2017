package assignment2;

/**
 * ClassName  :CountingSort
 * @author    :Vaishali Jain
 * Description: Implementation of  the counting sort
 */
public class CountingSort {
	/**
	 * member function implementing counting sort 
	 * @param array
	 * @return
	 */
	public Integer[] countingSort(Integer[] array) {
		// if array size is 0 i.e. no element to sort return null
		if (array.length == 0) {
			return null;
		}
		//calculate maximum and minimum element in the array
		int maxElement = array[0];
		int minElement=array[0];
		for (int i = 1; i < array.length; i++) {
			if (array[i] > maxElement) {
				maxElement = array[i];
			}
			if(array[i]<minElement){
				minElement=array[i];
			}
		}
		int[] indexSort ;
		//if any number is negative in array than increase the whole array with that element
		if(minElement<0){
		for(int i=0;i<array.length;i++){
			array[i]+=-1*minElement;
		}
		indexSort = new int[maxElement+1+(-1)*minElement];
		}else{
			indexSort = new int[maxElement+1];
		}
		//array containing input array in sorted form
		Integer[] sortedArray = new Integer[array.length];
		//array to keep the count of digits
		
		//initializing the indexSort array initially to zero
		for (int i = 0; i < indexSort.length; i++) {
			indexSort[i] = 0;
		}
		//updating the indexSort array based on the occurence of element in array
		for (int i = 0; i < array.length; i++) {
			indexSort[(int) array[i]] = indexSort[(int) array[i]]
					+ (Integer) 1;
		}
		//update indexSort[i] by the sum of all the previous indexes
		for (int i = 1; i < indexSort.length; i++) {
			indexSort[i] = indexSort[i] + indexSort[i - 1];
		}
		
		//put the element at the correct position in the sorted array 
		for (int i = 0; i < array.length; i++) {
			sortedArray[indexSort[(int) array[i]]-1] = array[i];
			//decreasing the count
			indexSort[(int) array[i]]--;
		}
		if(minElement<0){
		for(int i=0;i<array.length;i++){
			sortedArray[i]+=minElement;
		}
		}
		return sortedArray;
	}

}
