package assignment2;
import org.junit.*;

public class TestAssignment {
    RemoveDuplicate duplicate_element;

	@Before
	public void setUp(){
		duplicate_element = new RemoveDuplicate();
	}
	
	@Test
	public void testAllDifferent(){
		int[] input = {2,80,4,6,8,-1,10,1,17,13,21};
		int[] expected = {2,80,4,6,8,-1,10,1,17,13,21};
		int[] actual   = duplicate_element.removeDuplicate(input);
		
		Assert.assertArrayEquals(expected, actual);
	}
	
	@Test
	public void testAllSame(){
		int[] input = {2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2};
		int[] expected = {2};
		int[] actual   = duplicate_element.removeDuplicate(input);
		
		Assert.assertArrayEquals(expected, actual);
	}
	
	@Test
	public void testNull(){
		int[] input = {};
		int[] expected = {};
		int[] actual   = duplicate_element.removeDuplicate(input);
		
		Assert.assertArrayEquals(expected, actual);
	}
	
	@Test
	public void testGiven(){
		int[] input = {1, 2, 3, 4, 5, 6, 7, 8, 9, 9, 8, 7, 6, 5, 4, 3, 2, 1};
		int[] expected = {1,2,3,4,5,6,7,8,9};
		int[] actual   = duplicate_element.removeDuplicate(input);
		
		Assert.assertArrayEquals(expected, actual);
	}
}
