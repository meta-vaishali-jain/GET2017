package assignment5;
import org.junit.*;

public class TestAssignment {
	CheckArray classify;
	
	@Before
	public void setUp(){
		classify = new CheckArray();
	}
	
	@Test
	public void testAscSort(){
		int[] input = {1, 2, 3, 4, 5, 5, 89, 400};
		
		int output= classify.checkSortArray(input);
		Assert.assertEquals("Array in ascending sorted order", 1, output);
	}
	
	@Test
	public void testDscSort(){
		int[] input = {90, 89, 88, 88, 78, 67, 56};
		
		int output= classify.checkSortArray(input);
		Assert.assertEquals("Array in decending sorted order", 2, output);
	}
	
	@Test
	public void testUnsort(){
		int[] input = {8, 9, 0, 3, 7, 7, 14, 45, 9};
		
		int output= classify.checkSortArray(input);
		Assert.assertEquals("Array is unsorted", 0, output);
	}
	
	@Test
	public void testNull(){
		int[] input = {};
		
		int output= classify.checkSortArray(input);
		Assert.assertEquals("Array in ascending sorted order", 1, output);
	}
	
	@Test
	public void testSameElement(){
		int[] input = {5,5,5,5,5,5,5,5,5,5,5,5,5,5};
		
		int output= classify.checkSortArray(input);
		Assert.assertEquals("Array in ascending sorted order", 1, output);
	}
}
