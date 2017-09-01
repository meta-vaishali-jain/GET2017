package assignment2;

/**
 * ClassName  :RadixSort
 * @author    :Vaishali Jain
 * Description: Implementation of radix sort using the counting sort
 */
public class RadixSort {
	public Integer[] radixSort(Integer[] array){
	
		// if array size is 0 i.e. no element to sort return null
		if (array.length == 0) {
			return null;
		}
		//calculate maximum and minimum element in the array
		int maxElement=array[0];
		int minElement=array[0];
		//calculates
		for(int i=1;i<array.length;i++){
			if(array[i]> maxElement){
				maxElement=array[i];
			}
			if(array[i]<minElement){
				minElement=array[i];
			}
		}
		
		//if any number is negative in array than increase the whole array with that element
		if(minElement<0){
			for(int i=0;i<array.length;i++){
				array[i]+=(-1)*minElement;
			}
		}
		
		// Do counting sort for every digit by passing digit number 
        // where i is current digit number
		for(int i=1;(Integer)maxElement/i>0;i*=10){
			array=countingSort(array,i);
		}
		
		//Again decreasing the array with the same minimum element
		if(minElement<0){
			for(int i=0;i<array.length;i++){
				array[i]+=minElement;
			}
		}
		return array;
	}
	
	private Integer[] countingSort(Integer[] array,int index){
		
		//array to count elements
		int indexSort[]=new int[10];
		//stored array in sorted form
		Integer[] sortedArray=new Integer[array.length];
		
		for(int i=0;i<10;i++){
			indexSort[i]=0;
		}
		
		//updating the indexSort array based on the occurence of element in array
		for(int i=0;i<array.length;i++){
			indexSort[(array[i]/index)%10] = indexSort[((int) array[i]/index)%10]+1;
		}
		
		// update indexSort[i] by the sum of all the previous indexes
		for (int i = 1; i < indexSort.length; i++) {
			indexSort[i] = indexSort[i] + indexSort[i - 1];
		}
		
		// put the element at the correct position in the sorted array
		for (int i = array.length-1; i >=0; i--) {
			sortedArray[indexSort[((int) array[i]/index)%10]-1] = array[i];
			// decreasing the count
			indexSort[((int) array[i]/index)%10]--;
		}
		return sortedArray;
	}
}
