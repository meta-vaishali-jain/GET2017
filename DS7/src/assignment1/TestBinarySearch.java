package assignment1;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * ClassName  : TestBinarySearch
 * @author    : Vaishali Jain
 * Description: Test class to check the performance of Binary Search Tree class
 */
public class TestBinarySearch {
	BinarySearchTree<Integer> binarySearchTree;
	
	@Before
	public void setup(){
		binarySearchTree = new BinarySearchTree<Integer>();
	}
	
	//Test case to test add element method
	@Test
	public void testAddElement(){
		Assert.assertEquals(0,binarySearchTree.addElement(10));
		Assert.assertEquals(2,binarySearchTree.addElement(20));
		Assert.assertEquals(1,binarySearchTree.addElement(5));
	}
	
	//Test case to add if same elements are added in tree
	@Test
	public void testAddIfSameElement(){
		Assert.assertEquals(0,binarySearchTree.addElement(10));
		Assert.assertEquals(1,binarySearchTree.addElement(10));
		Assert.assertEquals(3,binarySearchTree.addElement(10));
	}
	
	//Test cases to check if null element is added
	@Test
	public void testAddIfNullElement(){
		Assert.assertEquals(-1,binarySearchTree.addElement(null));
	}
	
	//Test cases to check search if element found in array
	@Test
	public void testSearchIfElementFound(){
		Assert.assertEquals(0,binarySearchTree.addElement(10));
		Assert.assertEquals(2,binarySearchTree.addElement(20));
		Assert.assertEquals(1,binarySearchTree.addElement(5));
		Assert.assertEquals(2,binarySearchTree.searchElement(20));
		Assert.assertEquals(0,binarySearchTree.searchElement(10));
		Assert.assertEquals(1,binarySearchTree.searchElement(5));
	}
	
	//Test cases to check search if element not found in array
	@Test
	public void testSearchIfElementNotFound(){
		Assert.assertEquals(0,binarySearchTree.addElement(10));
		Assert.assertEquals(2,binarySearchTree.addElement(20));
		Assert.assertEquals(1,binarySearchTree.addElement(5));
		Assert.assertEquals(-1,binarySearchTree.searchElement(40));	
	}
	
	//Test cases to check search if array has same searching element more than one
	@Test
	public void testSearchIfArrayHasSameElements(){
		Assert.assertEquals(0,binarySearchTree.addElement(10));
		Assert.assertEquals(1,binarySearchTree.addElement(10));
		Assert.assertEquals(3,binarySearchTree.addElement(10));
		Assert.assertEquals(0,binarySearchTree.searchElement(10));	
	}
	
	//Test cases to check if null element is to be search
	@Test
	public void testSearchIfNullElement(){
		Assert.assertEquals(-1,binarySearchTree.searchElement(null));
	}
}
