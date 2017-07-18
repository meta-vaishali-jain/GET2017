package assignment3;
/**
 *
 * Name 		:	QuickSort
 * Author		:	Vaishali Jain
 * Description	:	QuickSort is used to sort a given array in ascending order
 */

public class QuickSort {
	
	/**
	 * @param input	:	input array
	 */
	public void quickSort(int[] input) {
		if (input.length <= 0)
			throw new NegativeArraySizeException();
		quickSort(input, 0, input.length - 1);
	}

	/**
	 * @param input	:	input array
	 * @param startindex	:	starting index of input array
	 * @param endindex	:	ending index of input array
	 */
	public void quickSort(int[] input, int startIndex, int endIndex) {
		if (startIndex < endIndex) {
			int partitionPoint = arrayPartition(input, startIndex, endIndex);
			
			//recursive call to quickSort for both partition 
			quickSort(input, startIndex, partitionPoint - 1);
			quickSort(input, partitionPoint, endIndex);

		}
	}

	/**
	 * function calculate the index value from where the array is to be partitiond
	 * @param input	:	input array
	 * @param startindex	:	starting index of input array
	 * @param endindex	:	ending index of input array
	 * @return position of partition point
	 */
	public int arrayPartition(int[] input, int startIndex, int endIndex) {
		int pivotElement = input[endIndex];
		int i = startIndex - 1;
		for (int j = startIndex; j < endIndex; j++) {
			if (input[j] <= pivotElement) {
				i++;
				int temp;//temporary element
				temp = input[i];
				input[i] = input[j];
				input[j] = temp;
			}
		}
		int temp;
		temp = input[i + 1];
		input[i + 1] = input[endIndex];
		input[endIndex] = temp;
		return i + 1;
	}
}

	


