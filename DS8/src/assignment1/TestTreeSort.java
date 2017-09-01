package assignment1;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * ClassName    : TestTreeSort
 * @author      : Vaishali Jain
 *	Description : Test class to test TreeSort class
 */
public class TestTreeSort {
	
	TreeSort<Integer> treeSorting;
	
	@Before
	public void setup(){
		treeSorting=new TreeSort<Integer>();
	}
	
	//Test method to check insert method
	@Test
	public void testInsertData(){
		Assert.assertTrue(treeSorting.insertData(10));
		Assert.assertTrue(treeSorting.insertData(5));
		Assert.assertTrue(treeSorting.insertData(15));
		Assert.assertEquals(3,treeSorting.getElements());
	}
	
	//Test case to check insert if null data is inserted
	@Test
	public void testInsertNullData(){
		Assert.assertFalse(treeSorting.insertData(null));
		Assert.assertEquals(0,treeSorting.getElements());
	}
	
	//Test check to check sort method with different elements
	@Test
	public void testSortWithDifferentElements(){
		Assert.assertTrue(treeSorting.insertData(10));
		Assert.assertTrue(treeSorting.insertData(5));
		Assert.assertTrue(treeSorting.insertData(15));
		Object[] sortedArray=treeSorting.treeSort();
		Assert.assertEquals(5, sortedArray[0]);
		Assert.assertEquals(10, sortedArray[1]);
		Assert.assertEquals(15, sortedArray[2]);
	}
	
	//Test case to check sort method with same elements
	@Test
	public void testSortWithSameElement(){
		Assert.assertTrue(treeSorting.insertData(10));
		Assert.assertTrue(treeSorting.insertData(5));
		Assert.assertTrue(treeSorting.insertData(15));
		Assert.assertTrue(treeSorting.insertData(5));
		Object[] sortedArray=treeSorting.treeSort();
		Assert.assertEquals(5, sortedArray[0]);
		Assert.assertEquals(5, sortedArray[1]);
		Assert.assertEquals(10, sortedArray[2]);
		Assert.assertEquals(15, sortedArray[3]);
	}
	
	//Test case to check sort if zero element is there
	@Test
	public void testSortWithZeroElement(){
		Assert.assertEquals((Integer)null, treeSorting.treeSort());
	}
	
}
