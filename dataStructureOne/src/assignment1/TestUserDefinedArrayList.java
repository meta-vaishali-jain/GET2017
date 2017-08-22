package assignment1;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class TestUserDefinedArrayList {
	UserDefinedArrayList<Integer> integerArrayList;
	UserDefinedArrayList<String> stringArrayList;
	
	@Before
	public void setup(){
		integerArrayList=new UserDefinedArrayList<Integer>();
		stringArrayList=new UserDefinedArrayList<String>();
	}
	
	//test case to check initial size of array list
	@Test
	public void testInitialSize(){
		Assert.assertEquals(0,integerArrayList.getArraySize());
		Assert.assertEquals(0,stringArrayList.getArraySize());
		
	}
	
	//test case to add item in the linked list
	@Test
	public void testAddItem(){
		integerArrayList.addItem(10);
		integerArrayList.addItem(20);
		stringArrayList.addItem("naina");
		stringArrayList.addItem("vaishali");
		Assert.assertEquals(2,integerArrayList.getArraySize());
		Assert.assertEquals(2,stringArrayList.getArraySize());
	}
	
	//test case to check resizing of array
	@Test
	public void testResizeArray(){
		integerArrayList.addItem(10);
		integerArrayList.addItem(20);
		integerArrayList.addItem(30);
		integerArrayList.addItem(40);
		stringArrayList.addItem("naina");
		stringArrayList.addItem("vaishali");
		stringArrayList.addItem("shreya");
		stringArrayList.addItem("anushtha");
		Assert.assertEquals(4,integerArrayList.getArraySize());
		Assert.assertEquals(4,stringArrayList.getArraySize());
		Assert.assertEquals(6, integerArrayList.getArray().length);
		Assert.assertEquals(6, stringArrayList.getArray().length);
	}
	
	//test case to check addition of element at particular valid position
	@Test
	public void testAtParticularValidPosition(){
		integerArrayList.addItem(10);
		integerArrayList.addItem(20);
		integerArrayList.addItem(30);
		stringArrayList.addItem("naina");
		stringArrayList.addItem("vaishali");
		stringArrayList.addItem("anushtha");
		integerArrayList.addAtParticularPosition(15,2);
		Assert.assertEquals(4,integerArrayList.getArraySize());
		stringArrayList.addAtParticularPosition("shreya",2);
		Assert.assertEquals(4,stringArrayList.getArraySize());
		Assert.assertEquals(15,integerArrayList.getArray()[1]);
		Assert.assertEquals("shreya",stringArrayList.getArray()[1]);
	}
	
	//test case to check addition of element at invalid very small position
	@Test
	public void testAtParticularInvalidPosition(){
		integerArrayList.addItem(10);
		integerArrayList.addItem(20);
		stringArrayList.addItem("naina");
		stringArrayList.addItem("vaishali");
		Assert.assertFalse(integerArrayList.addAtParticularPosition(15,0));
		Assert.assertFalse(stringArrayList.addAtParticularPosition("shreya",0));
	}
	
	//test case to check addition of element at invalid very large position
	@Test
	public void testAtParticularInvalidLargePosition(){
		integerArrayList.addItem(10);
		integerArrayList.addItem(20);
		stringArrayList.addItem("naina");
		stringArrayList.addItem("vaishali");
		Assert.assertFalse(integerArrayList.addAtParticularPosition(15,4));
		Assert.assertFalse(stringArrayList.addAtParticularPosition("shreya",4));
	}
	
	//test case to get position of the  element if element is in list
	@Test
	public void testGetValidElementPosition(){
		integerArrayList.addItem(10);
		integerArrayList.addItem(20);
		stringArrayList.addItem("naina");
		stringArrayList.addItem("vaishali");
		Assert.assertEquals(2,integerArrayList.getElementPosition(20));
		Assert.assertEquals(2,stringArrayList.getElementPosition("vaishali"));
	}
	
	//test case to get position of the  element if element is not in list
	@Test
	public void testGetInvalidElementPosition(){
		integerArrayList.addItem(10);
		integerArrayList.addItem(20);
		stringArrayList.addItem("naina");
		stringArrayList.addItem("vaishali");
		Assert.assertEquals(0,integerArrayList.getElementPosition(30));
		Assert.assertEquals(0,stringArrayList.getElementPosition("aishali"));
	}
	
	//test case to get element value based on valid position
	@Test
	public void testGetElementBasedOnValidPosition(){
		integerArrayList.addItem(10);
		integerArrayList.addItem(20);
		stringArrayList.addItem("naina");
		stringArrayList.addItem("vaishali");
		Assert.assertEquals(20,integerArrayList.getElementBasedOnPosition(2));
		Assert.assertEquals("vaishali",stringArrayList.getElementBasedOnPosition(2));
	}
	
	//test case to get element value based on invalid small position
	@Test
	public void testGetElementBasedOnInValidSmallPosition() {
		integerArrayList.addItem(10);
		integerArrayList.addItem(20);
		stringArrayList.addItem("naina");
		stringArrayList.addItem("vaishali");
		Assert.assertEquals(null, integerArrayList.getElementBasedOnPosition(0));
		Assert.assertEquals(null, stringArrayList.getElementBasedOnPosition(0));
	}
	
	//test case to get element value based on invalid large position
	@Test
	public void testGetElementBasedOnInValidLargePosition() {
		integerArrayList.addItem(10);
		integerArrayList.addItem(20);
		stringArrayList.addItem("naina");
		stringArrayList.addItem("vaishali");
		Assert.assertEquals(null, integerArrayList.getElementBasedOnPosition(4));
		Assert.assertEquals(null, stringArrayList.getElementBasedOnPosition(4));
	}
	
	//test case to remove element from list based on position
	@Test
	public void testRemoveElementBasedOnPosition(){
		integerArrayList.addItem(10);
		integerArrayList.addItem(20);
		stringArrayList.addItem("naina");
		stringArrayList.addItem("vaishali");
		Assert.assertEquals(10, integerArrayList.getElementBasedOnPosition(1));
		Assert.assertEquals(2,integerArrayList.getArraySize());
		integerArrayList.removeElementBasedOnPosition(1);
		Assert.assertEquals(20, integerArrayList.getElementBasedOnPosition(1));
		Assert.assertEquals(1,integerArrayList.getArraySize());
		Assert.assertEquals("naina", stringArrayList.getElementBasedOnPosition(1));
		Assert.assertEquals(2,stringArrayList.getArraySize());
		stringArrayList.removeElementBasedOnPosition(1);
		Assert.assertEquals("vaishali", stringArrayList.getElementBasedOnPosition(1));
		Assert.assertEquals(1,stringArrayList.getArraySize());
	}
	
	//test case to remove elements from list based on its value
	@Test
	public void testRemoveParticularElement(){
		integerArrayList.addItem(10);
		integerArrayList.addItem(20);
		integerArrayList.addItem(10);
		stringArrayList.addItem("naina");
		stringArrayList.addItem("vaishali");
		stringArrayList.addItem("naina");
		Assert.assertEquals(3,integerArrayList.getArraySize());
		Assert.assertEquals(3,stringArrayList.getArraySize());
		integerArrayList.removeParticularElement(10);
		stringArrayList.removeParticularElement("naina");
		Assert.assertEquals(1,integerArrayList.getArraySize());
		Assert.assertEquals(1,stringArrayList.getArraySize());
	}
	
	//test case to remove invalid elements from list based on its value
	@Test
	public void testRemoveParticularInvalidElement() {
		integerArrayList.addItem(10);
		integerArrayList.addItem(20);
		integerArrayList.addItem(10);
		stringArrayList.addItem("naina");
		stringArrayList.addItem("vaishali");
		stringArrayList.addItem("naina");
		Assert.assertEquals(3, integerArrayList.getArraySize());
		Assert.assertEquals(3, stringArrayList.getArraySize());
		Assert.assertFalse(integerArrayList.removeParticularElement(40));
		Assert.assertFalse(stringArrayList.removeParticularElement("nain"));
	}
	
	//test case to check clear list
	@Test
	public void testClearList(){
		integerArrayList.addItem(10);
		integerArrayList.addItem(20);
		stringArrayList.addItem("naina");
		stringArrayList.addItem("vaishali");
		Assert.assertEquals(2,integerArrayList.getArraySize());
		Assert.assertEquals(2,stringArrayList.getArraySize());
		integerArrayList.clearList();
		stringArrayList.clearList();
		Assert.assertEquals(0,integerArrayList.getArraySize());
		Assert.assertEquals(0,stringArrayList.getArraySize());
	}
	
	//test case to check sort method
	@Test
	public void testSort(){
		integerArrayList.addItem(50);
		integerArrayList.addItem(10);
		integerArrayList.addItem(20);
		stringArrayList.addItem("shreya");
		stringArrayList.addItem("naina");
		stringArrayList.addItem("vaishali");
		integerArrayList.sort();
		stringArrayList.sort();
		Assert.assertEquals(10, integerArrayList.getElementBasedOnPosition(1));
		Assert.assertEquals(20, integerArrayList.getElementBasedOnPosition(2));
		Assert.assertEquals(50, integerArrayList.getElementBasedOnPosition(3));
		Assert.assertEquals("naina", stringArrayList.getElementBasedOnPosition(1));
		Assert.assertEquals("shreya", stringArrayList.getElementBasedOnPosition(2));
		Assert.assertEquals("vaishali", stringArrayList.getElementBasedOnPosition(3));
	}
	
	//test case to check reverse method
	@Test
	public void testReverseList(){
		integerArrayList.addItem(50);
		integerArrayList.addItem(10);
		integerArrayList.addItem(20);
		stringArrayList.addItem("shreya");
		stringArrayList.addItem("naina");
		stringArrayList.addItem("vaishali");
		integerArrayList.reverseArray();
		stringArrayList.reverseArray();
		Assert.assertEquals(20, integerArrayList.getElementBasedOnPosition(1));
		Assert.assertEquals(10, integerArrayList.getElementBasedOnPosition(2));
		Assert.assertEquals(50, integerArrayList.getElementBasedOnPosition(3));
		Assert.assertEquals("vaishali", stringArrayList.getElementBasedOnPosition(1));
		Assert.assertEquals("naina", stringArrayList.getElementBasedOnPosition(2));
		Assert.assertEquals("shreya", stringArrayList.getElementBasedOnPosition(3));
	}
}
