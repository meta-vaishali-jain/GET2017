package assignment2;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
/**
 * Class Name : TestLinearSearch
 * @author    : Vaishali Jain
 * Description : Describes Test cases for LinearSearch class
 */
public class TestLinearSearch {
	LinearSearch search=new LinearSearch();
	@Before
	public void setUp() {
		search = new LinearSearch();
	}
	//Test when element is in array
	@Test
	public void testWhenElementInArray() {
		int[] input = {1, 6, 9, 12, 15, 17, 23, 89};
		Assert.assertEquals(4, search.linearArraySearch(input, 12));
	}
	//Test when element is not in array
	@Test
	public void testWhenElementNotInArray() {
		int[] input = {1, 6, 9, 12, 15, 17, 23, 89};
		Assert.assertEquals(-1, search.linearArraySearch(input, 16));
	}
	//Test when duplicate element is in array
	@Test
	public void testWhenDuplicateElementInArray() {
		int[] input = {1, 6, 9, 12, 12, 12, 12, 15, 17, 23, 89};
		Assert.assertEquals(4, search.linearArraySearch(input, 12));
	}
    //Test when input array is null
	@Test(expected = NullPointerException.class)
	public void testNullArray() {
		int[] input = null;
		search.linearArraySearch(input,0);
	}
	@Test(expected = NegativeArraySizeException.class)
	public void testBlankArray() {
		int[] input = {};
		search.linearArraySearch(input,10);
	}
	@Test(expected = NegativeArraySizeException.class)
	public void testNegativeSizeArray() {
		int[] input = new int[-2];
		search.linearArraySearch(input,7);
	}

}
