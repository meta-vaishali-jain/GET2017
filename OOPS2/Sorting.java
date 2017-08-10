/**
 * ClassName Sorting
 * @author Vaishali Jain
 * Description for sorting using quick sort
 */
public class Sorting {
	public static void doQuickSort(Question[] questions, int start, int end) {
		int pivotPoint;

		if (start < end) {
			pivotPoint = partition(questions, start, end);

			doQuickSort(questions, start, pivotPoint - 1);

			doQuickSort(questions, pivotPoint + 1, end);
		}
	}

	    /**
	     * @param questions		:	array of objects
	     * @param start			:	start index
	     * @param end			:	end index
	     * @return				:	position of pivot point
	     * Description			:	calculate the pivot point position
	     */
	private static int partition(Question[] questions, int start, int end) {
		Question pivotQuestion;
		int endOfLeftList;
		int mid = (start + end) / 2;

		swap(questions, start, mid);

		pivotQuestion = questions[start];

		endOfLeftList = start;

		for (int scan = start + 1; scan <= end; scan++) {

			if (questions[scan].compareTo(pivotQuestion) < questions[start]
					.compareTo(pivotQuestion)) {
				endOfLeftList++;
				swap(questions, endOfLeftList, scan);
			}
		}

		swap(questions, start, endOfLeftList);

		return endOfLeftList;
	}

	
	    /**
	     * @param questions		:	array of objects
	     * @param startIndex	:	start index
	     * @param endIndex		:	ending index
	     * Description			:	swapping function
	     */
	private static void swap(Question[] questions, int startIndex, int endIndex) {
		Question temp;

		temp = questions[startIndex];
		questions[startIndex] = questions[endIndex];
		questions[endIndex] = temp;
	}

}
