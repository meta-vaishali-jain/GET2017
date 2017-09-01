package assignment2;

/**
 * ClassName  : QuickSort
 * @author    : Vaishali Jain
 * Description: Class performing sorting on array by using Quick sort algorithm.
 * 				It picks last element as pivotElement and partitions the given array around the picked pivotPoint 
 * 				and perform sorting.
 * @param <T>
 */
public class QuickSort<T extends Comparable<T>> {
	
	/**
	 * Method performing main functioning of quick sort
	 * @param arrayToSort
	 * @return sorted array
	 */
	public Object[] quickSort(T[] arrayToSort){
		// if array size is 0 i.e. no element to sort return null
		if (arrayToSort.length == 0) {
			return null;
		}
		return quickSort(arrayToSort,0,arrayToSort.length-1);
	}
	
	/**
	 * overloaded method
	 * recursively call quicksort function for further partioning of rray and then sort them
	 * @param arrayToSort
	 * @param startIndex
	 * @param endIndex
	 * @return
	 */
	private Object[] quickSort(T[] arrayToSort,int startIndex,int endIndex){
		if(startIndex<endIndex){
			int partitionIndex=partition(arrayToSort,startIndex,endIndex);
			quickSort(arrayToSort,startIndex,partitionIndex-1);
			quickSort(arrayToSort,partitionIndex+1,endIndex);
		}
		return arrayToSort;
	}
	
	/**
	 * This method takes the pivot element as the rightmost index element and
	 * then move that pivot element to its current position by iterating and swapping the nodes
	 * @param arrayToSort
	 * @param startIndex
	 * @param endIndex
	 * @return
	 */
	private int partition(T[] arrayToSort,int startIndex,int endIndex){
		//pivot element as last element
		T pivotElement=arrayToSort[endIndex];
		int i=startIndex-1;
		for(int j=startIndex;j<endIndex;j++){
			//if number is samller than then the pivot element than swap
			if(arrayToSort[j].compareTo(pivotElement)<=0){
				i++;
				arrayToSort= new Swap<T>().swap(i, j, arrayToSort);
			}	
		}
		//place pivot element to its correct position
		arrayToSort=new Swap<T>().swap(i+1,endIndex,arrayToSort);
		return i+1;
		
	}
	
}
