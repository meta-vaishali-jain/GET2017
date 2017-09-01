package assignment2;

import java.util.Arrays;

/**
 * ClassName : Controller
 * @author   : Vaishali Jain
 * Description: controls which sort to be called based on the input array
 */
public class Controller {
		private Integer[] arrayToSort;
		private final static int DEFAULT_SIZE=10;
		private int arraySize;
		private Integer array[];
		
		//getter to get array
		public Integer[] getArray() {
			return array;
		}
		
		//setter to set array
		public void setArray(Integer[] array) {
			this.array = array;
		}
		
		//default constructor
		public Controller(){
			arrayToSort=new Integer[DEFAULT_SIZE];
			arraySize=0;
		}
		
		//to insert element in the array
		public boolean insert(int data){
			if(arraySize<DEFAULT_SIZE){
				arrayToSort[arraySize++]=data;
			}else{
				arrayToSort=Arrays.copyOf(arrayToSort, arrayToSort.length*2);
				arrayToSort[arraySize++]=data;
			}
			return true;
		}
		
		/**
		 * member function to sort the array based on the user choice
		 * @param choice
		 * @return
		 */
		public int sort(int choice){
			 array=new Integer[arraySize];
			for(int i=0;i<arraySize;i++){
				array[i]=arrayToSort[i];
			}
			switch(choice){
			//if choice is 1 than comparison sort
			case 1:
				//if array size is less than 10 than bubble sort
				if(arraySize<=10){
				BubbleSort<Integer> bubbleSort=new BubbleSort<Integer>();
				array=bubbleSort.bubbleSort(array);
					return 0;
				}
				//otherwise quick sort
				else{
					QuickSort<Integer> quickSort=new QuickSort<Integer>();
					array=(Integer[]) quickSort.quickSort(array);
					return 1;
				}
				//if choice is of linear sort
			case 2: int maxElement=array[0];
					int countDigits=0;
					for(int i=1;i<array.length;i++){
						if(array[i]>maxElement){
							maxElement=array[i];
						}
					}
					while(maxElement > 0) {
						maxElement = maxElement/ 10;
						countDigits = countDigits + 1; 
					}
					//if less than or equals to 2 digits than counting sort
					if(countDigits<=2){
						CountingSort countingSort=new CountingSort();
						array= countingSort.countingSort(array);
						return 0;
					}
					//otherwise radix sort
					else{
						RadixSort radixSort=new RadixSort();
						array= radixSort.radixSort(array);
						return 1;
					}
			}
			
			return 0;
		}
}
