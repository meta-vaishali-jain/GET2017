package assignment2;

/**
 * ClassName  : BubbleSort
 * @author    : Vaishali Jain
 * Description: Class performing sorting on array by using bubble sort algorithm
 * 				by repeatedly swapping the adjacent elements if they are in wrong order.
 * @param <T>
 */
public class BubbleSort<T extends Comparable<T>> {
	
	/**
	 * bubble sort implementing method
	 * @param arrayToSort
	 * @return sorted array
	 */
	public T[] bubbleSort(T[] arrayToSort){
		//if array size is 0 i.e. no element to sort return null
		if(arrayToSort.length==0){
			return null;
		}
		//repeatedly swapping the adjacent element
		for(int i=0 ;i<arrayToSort.length-1;i++){
			for(int j=0;j<arrayToSort.length-1-i;j++){
				if( arrayToSort[j].compareTo(arrayToSort[j+1])>0){
				//if first element is greater than second element than perform swapping
				arrayToSort=new Swap<T>().swap(j,j+1,arrayToSort);
				}
			}
		}
		return arrayToSort;
	}
}
