package assignment2;

import java.util.InputMismatchException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
/**
 * Class Name : TestBinarySearch
 * @author    : Vaishali Jain
 * Description : Describes Test cases for BinarySearch class
 */
public class TestBinarySearch {
BinarySearch search;
	
	@Before
	public void setUp() {
		search = new BinarySearch();
	}
	//Test when element is in array
	@Test
	public void testWhenElementInArray() {
		int[] input = {1, 6, 9, 12, 15, 17, 23, 89};
		
		Assert.assertEquals(4, search.binarySearch(input, 12));
	}
	//Test when element is not in array
	@Test
	public void testWhenElementNotInArray() {
		int[] input = {1, 6, 9, 12, 15, 17, 23, 89};
		
		Assert.assertEquals(-1, search.binarySearch(input, 16));
	}
	//Test when there is duplicate element
	@Test
	public void testWhenDuplicateElementInArray() {
		int[] input = {1, 6, 9, 12, 12, 12, 12, 15, 17, 23, 89};
		
		Assert.assertEquals(6, search.binarySearch(input, 12));
	}
    //Negative Test Cases
	@Test(expected = NullPointerException.class)
	public void testNullArray() {
		int[] input = null;
		search.binarySearch(input, 0);
	}
	
	@Test(expected = NegativeArraySizeException.class)
	public void testBlankArray() {
		int[] input = {};
		search.binarySearch(input, 10);
	}
	
	@Test(expected = NegativeArraySizeException.class)
	public void testNegativeSizeArray() {
		int[] input = new int[-2];
		search.binarySearch(input, 7);
	}
		
	@Test(expected = InputMismatchException.class)
	public void testUnsortedArray() {
		int[] input = {8,7,9,4,3};
		search.binarySearch(input, 7);
	}
	
}


