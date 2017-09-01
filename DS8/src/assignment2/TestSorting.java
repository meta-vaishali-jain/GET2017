package assignment2;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * ClassName  : TestSorting
 * @author    : Vaishali Jain
 * Description: Test class to test all sorting
 */
public class TestSorting {
	BubbleSort<Integer> bubbleSorting;
	QuickSort<Integer> quickSorting;
	CountingSort countingSort;
	RadixSort radixSort;
	
	@Before
	public void setup(){
		bubbleSorting=new BubbleSort<Integer>();
		quickSorting=new QuickSort<Integer>();
		countingSort=new CountingSort();
		radixSort=new RadixSort();
	}
	
	//Test case to check bubble sort
	@Test
	public void testBubbleSort(){
		Integer arrayToSort[]={78,45,99,66,11,22,75};
		arrayToSort=bubbleSorting.bubbleSort(arrayToSort);
		Assert.assertEquals((Integer)11,arrayToSort[0]);
		Assert.assertEquals((Integer)22,arrayToSort[1]);
		Assert.assertEquals((Integer)45,arrayToSort[2]);
		Assert.assertEquals((Integer)66,arrayToSort[3]);
		Assert.assertEquals((Integer)75,arrayToSort[4]);
		Assert.assertEquals((Integer)78,arrayToSort[5]);
		Assert.assertEquals((Integer)99,arrayToSort[6]);
	}
	
	//test case to check bubble sort if null array is passed
	@Test
	public void testBubbleSortIfNullArray(){
		Integer arrayToSort[]={};
		arrayToSort=bubbleSorting.bubbleSort(arrayToSort);
		Assert.assertEquals((Integer)null,arrayToSort);
	}
	
	//test case to check bubble sort for negative numbers
	@Test
	public void testBubbleSortForNegativeNumber(){
		Integer arrayToSort[]={-78,-45,-99,-66,-11,-22,-75};
		arrayToSort=bubbleSorting.bubbleSort( arrayToSort);
		Assert.assertEquals((Integer)(-11) ,(Integer)arrayToSort[6]);
		Assert.assertEquals((Integer)( -22) ,(Integer)arrayToSort[5]);
		Assert.assertEquals((Integer)( -45) ,(Integer)arrayToSort[4]);
		Assert.assertEquals((Integer)( -66) ,(Integer)arrayToSort[3]);
		Assert.assertEquals((Integer)( -75),(Integer)arrayToSort[2]);
		Assert.assertEquals((Integer)( -78),(Integer)arrayToSort[1]);
		Assert.assertEquals((Integer)( -99),(Integer)arrayToSort[0]);
	}
	
	//test case to test counting sort
	@Test
	public void testCountingSort(){
		Integer[] arrayToSort={78,45,99,66,11,22,75};
		arrayToSort=countingSort.countingSort(arrayToSort);
		Assert.assertEquals((Integer)11,arrayToSort[0]);
		Assert.assertEquals((Integer)22,arrayToSort[1]);
		Assert.assertEquals((Integer)45,arrayToSort[2]);
		Assert.assertEquals((Integer)66,arrayToSort[3]);
		Assert.assertEquals((Integer)75,arrayToSort[4]);
		Assert.assertEquals((Integer)78,arrayToSort[5]);
		Assert.assertEquals((Integer)99,arrayToSort[6]);
	}
	
	//test case to test counting sort
	@Test
	public void testCountingSortForSameElements(){
		Integer[] arrayToSort={1,2,1,6,1,22,75};
		arrayToSort=countingSort.countingSort(arrayToSort);
		Assert.assertEquals((Integer)1,arrayToSort[0]);
		Assert.assertEquals((Integer)1,arrayToSort[1]);
		Assert.assertEquals((Integer)1,arrayToSort[2]);
		Assert.assertEquals((Integer)2,arrayToSort[3]);
		Assert.assertEquals((Integer)6,arrayToSort[4]);
		Assert.assertEquals((Integer)22,arrayToSort[5]);
		Assert.assertEquals((Integer)75,arrayToSort[6]);
	}
	
	//test case to test counting sort if null array is passed
	@Test
	public void testCountingSortIfNullArray(){
		Integer[] arrayToSort={};
		arrayToSort=countingSort.countingSort(arrayToSort);
		Assert.assertEquals((Integer)null,arrayToSort);
	}
	
	//test case to test counting sort for negative numbers
	@Test
	public void testCountingSortForNegativeNumbers(){
		Integer[] arrayToSort={1,-2,1,-6,1,-22,75};
		arrayToSort=countingSort.countingSort(arrayToSort);
		Assert.assertEquals((Integer)(-22),arrayToSort[0]);
		Assert.assertEquals((Integer)(-6),arrayToSort[1]);
		Assert.assertEquals((Integer)(-2),arrayToSort[2]);
		Assert.assertEquals((Integer)(1),arrayToSort[3]);
		Assert.assertEquals((Integer)(1),arrayToSort[4]);
		Assert.assertEquals((Integer)(1),arrayToSort[5]);
		Assert.assertEquals((Integer)(75),arrayToSort[6]);
	}
	
	//test case to check quick sort
	@Test
	public void testQuickSort(){
		Integer arrayToSort[]={78,45,99,66,11,22,75};
		arrayToSort=(Integer[]) quickSorting.quickSort(arrayToSort);
		Assert.assertEquals((Integer)11,arrayToSort[0]);
		Assert.assertEquals((Integer)22,arrayToSort[1]);
		Assert.assertEquals((Integer)45,arrayToSort[2]);
		Assert.assertEquals((Integer)66,arrayToSort[3]);
		Assert.assertEquals((Integer)75,arrayToSort[4]);
		Assert.assertEquals((Integer)78,arrayToSort[5]);
		Assert.assertEquals((Integer)99,arrayToSort[6]);
	}
	
	//Test case to check quick sort if null array is passed
	@Test
	public void testQuickSortIfNullArray(){
		Integer arrayToSort[]={};
		arrayToSort=(Integer[]) quickSorting.quickSort(arrayToSort);
		Assert.assertEquals((Integer)null,arrayToSort);
	}
	
	//test case to check quick sort for negative numbers
	@Test
	public void testQuickSortForNegativeNumbers(){
		Integer arrayToSort[]={1,-2,1,-6,1,-22,75};
		arrayToSort=(Integer[]) quickSorting.quickSort(arrayToSort);
		Assert.assertEquals((Integer)(-22) ,(Integer)arrayToSort[0]);
		Assert.assertEquals((Integer)( -6) ,(Integer)arrayToSort[1]);
		Assert.assertEquals((Integer)( -2) ,(Integer)arrayToSort[2]);
		Assert.assertEquals((Integer)( 1) ,(Integer)arrayToSort[3]);
		Assert.assertEquals((Integer)( 1),(Integer)arrayToSort[4]);
		Assert.assertEquals((Integer)( 1),(Integer)arrayToSort[5]);
		Assert.assertEquals((Integer)( 75),(Integer)arrayToSort[6]);
	}
	
	//test case to check radix sort
	@Test
	public void testRadixSort(){
		Integer[] arrayToSort={78,45,99,66,11,22,75};
		arrayToSort=radixSort.radixSort(arrayToSort);
		Assert.assertEquals((Integer)11,arrayToSort[0]);
		Assert.assertEquals((Integer)22,arrayToSort[1]);
		Assert.assertEquals((Integer)45,arrayToSort[2]);
		Assert.assertEquals((Integer)66,arrayToSort[3]);
		Assert.assertEquals((Integer)75,arrayToSort[4]);
		Assert.assertEquals((Integer)78,arrayToSort[5]);
		Assert.assertEquals((Integer)99,arrayToSort[6]);
	}
	
	//test case to check radix sort if null array is passed
	@Test
	public void testRadixSortIfNullArray(){
		Integer[] arrayToSort={};
		arrayToSort=radixSort.radixSort(arrayToSort);
		Assert.assertEquals((Integer)null,arrayToSort);
	}
	
	//test case to check radix sort for negative numbers
	@Test
	public void testRadixSortForNegativeNumbers(){
		Integer[] arrayToSort={-2,-15,19,4,18,-19};
		arrayToSort=countingSort.countingSort(arrayToSort);
		Assert.assertEquals((Integer)(-19),arrayToSort[0]);
		Assert.assertEquals((Integer)(-15),arrayToSort[1]);
		Assert.assertEquals((Integer)(-2),arrayToSort[2]);
		Assert.assertEquals((Integer)(4),arrayToSort[3]);
		Assert.assertEquals((Integer)(18),arrayToSort[4]);
		Assert.assertEquals((Integer)(19),arrayToSort[5]);
		
	}
	
	
	
	
	
}
