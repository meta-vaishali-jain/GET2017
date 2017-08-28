package assignment3;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * ClassName : TestSortedLinkedList
 * @author   : Vaishali Jain
 * Description: Test class to test SortedLinkedList
 */
public class TestSortedLinkedList {
		SortedLinkedList<Integer> integerLinkedList;
		SortedLinkedList<String> stringLinkedList;
		@Before
		public void setup(){
			integerLinkedList=new SortedLinkedList<Integer>();
			stringLinkedList=new SortedLinkedList<String>();
		}
		
		//method to test add element function
		@Test
		public void testAdd(){
			integerLinkedList.add(20);
			integerLinkedList.add(10);
			stringLinkedList.add("vaishali");
			stringLinkedList.add("naina");
			Assert.assertEquals(10,integerLinkedList.getFirst());
			Assert.assertEquals("naina",stringLinkedList.getFirst());
		}
		
		//method to test if element passed is null
		@Test
		public void testAddIfElementNull(){
			Assert.assertFalse(integerLinkedList.add(null));
			Assert.assertFalse(stringLinkedList.add(null));
		}
		
		//method to test get element by index method
		@Test
		public void testGetElementByIndex(){
			integerLinkedList.add(20);
			integerLinkedList.add(10);
			stringLinkedList.add("vaishali");
			stringLinkedList.add("naina");
			Assert.assertEquals(20,integerLinkedList.get(1));
			Assert.assertEquals("vaishali",stringLinkedList.get(1));
		}
		
		//method to test if invalid index is passed
		@Test
		public void testGetElementByInvalidIndex(){
			integerLinkedList.add(20);
			integerLinkedList.add(10);
			stringLinkedList.add("vaishali");
			stringLinkedList.add("naina");
			Assert.assertEquals(null,integerLinkedList.get(3));
			Assert.assertEquals(null,stringLinkedList.get(3));
		}
		
		
		//method to test if list is empty
		@Test
		public void testGetFirstIfListEmpty(){
			Assert.assertEquals(null,integerLinkedList.getFirst());
			Assert.assertEquals(null,stringLinkedList.getFirst());
		}
}
