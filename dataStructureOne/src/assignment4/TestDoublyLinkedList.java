package assignment4;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;



public class TestDoublyLinkedList {
	DoublyLinkedList<Integer> integerLinkedList;
	DoublyLinkedList<String> stringLinkedList;
	DoublyLinkedList<Double> doubleLinkedList;
	
	@Before
	public void setUp(){
		integerLinkedList=new DoublyLinkedList<Integer>();
		doubleLinkedList=new DoublyLinkedList<Double>();
		stringLinkedList=new DoublyLinkedList<String>();
	}
	
	//test case to check if list is empty
	@Test
	public void testIsListEmpty(){
		Assert.assertTrue(integerLinkedList.isListEmpty());
		Assert.assertTrue(doubleLinkedList.isListEmpty());
		Assert.assertTrue(stringLinkedList.isListEmpty());
	}
	
	//test case to check if list is not empty
	@Test
	public void testIsListNotEmpty(){
		integerLinkedList.addAtBeginning(10);
		doubleLinkedList.addAtBeginning(10.00);
		stringLinkedList.addAtBeginning("naina");
		Assert.assertFalse(integerLinkedList.isListEmpty());
		Assert.assertFalse(doubleLinkedList.isListEmpty());
		Assert.assertFalse(stringLinkedList.isListEmpty());
	}
	
	//test case to check add at beginning
	@Test
	public void testAddAtBeginning(){
		Integer intExpected = new Integer(20);
		Double  doubleExpected=new Double(20.00);
		String stringExpected=new String("naina");
		integerLinkedList.addAtBeginning(10);
		integerLinkedList.addAtBeginning(20);
		doubleLinkedList.addAtBeginning(10.00);
		doubleLinkedList.addAtBeginning(20.00);
		stringLinkedList.addAtBeginning("Vaishali");
		stringLinkedList.addAtBeginning("naina");
		Assert.assertEquals((Integer)intExpected, (Integer)integerLinkedList.getParticularPositionElement(1));
		Assert.assertEquals((Double)doubleExpected, (Double)doubleLinkedList.getParticularPositionElement(1));
		Assert.assertEquals((String)stringExpected, (String)stringLinkedList.getParticularPositionElement(1));
	}
	
	//test case to check add at last
	@Test
	public void testAddAtLast(){
		Integer intExpected = new Integer(20);
		Double  doubleExpected=new Double(20.00);
		String stringExpected=new String("naina");
		integerLinkedList.addAtLast(10);
		integerLinkedList.addAtLast(20);
		doubleLinkedList.addAtLast(10.00);
		doubleLinkedList.addAtLast(20.00);
		stringLinkedList.addAtLast("Vaishali");
		stringLinkedList.addAtLast("naina");
		Assert.assertEquals((Integer)intExpected, (Integer)integerLinkedList.getParticularPositionElement(2));
		Assert.assertEquals((Double)doubleExpected, (Double)doubleLinkedList.getParticularPositionElement(2));
		Assert.assertEquals((String)stringExpected, (String)stringLinkedList.getParticularPositionElement(2));
	}
	
	//test case to check when add at particular position
	@Test
	public void testAddAtParticularValidPosition(){
		integerLinkedList.addAtLast(10);
		integerLinkedList.addAtLast(20);
		doubleLinkedList.addAtLast(10.00);
		doubleLinkedList.addAtLast(20.00);
		stringLinkedList.addAtLast("Vaishali");
		stringLinkedList.addAtLast("naina");
		Assert.assertTrue(integerLinkedList.addAtParticularPosition(1,5));
		Assert.assertTrue(doubleLinkedList.addAtParticularPosition(1,5.00));
		Assert.assertTrue(stringLinkedList.addAtParticularPosition(1,"Jain"));
	}
	
	//test case to check when add at invalid position
	@Test
	public void testAddAtParticularInvalidPosition(){
		integerLinkedList.addAtLast(10);
		integerLinkedList.addAtLast(20);
		doubleLinkedList.addAtLast(10.00);
		doubleLinkedList.addAtLast(20.00);
		stringLinkedList.addAtLast("Vaishali");
		stringLinkedList.addAtLast("naina");
		Assert.assertFalse(integerLinkedList.addAtParticularPosition(0,5));
		Assert.assertFalse(doubleLinkedList.addAtParticularPosition(0,5.00));
		Assert.assertFalse(stringLinkedList.addAtParticularPosition(0,"Jain"));
	}
	
	//test case to check when add at invalid position
	@Test
	public void testAddIntegerAtParticularInvalid4Position(){
		integerLinkedList.addAtLast(10);
		integerLinkedList.addAtLast(20);
		doubleLinkedList.addAtLast(10.00);
		doubleLinkedList.addAtLast(20.00);
		stringLinkedList.addAtLast("Vaishali");
		stringLinkedList.addAtLast("naina");
		Assert.assertFalse(integerLinkedList.addAtParticularPosition(4,5));
		Assert.assertFalse(doubleLinkedList.addAtParticularPosition(4,5.00));
		Assert.assertFalse(stringLinkedList.addAtParticularPosition(4,"Jain"));
	}
	
	//test check to check remove element based on value
	@Test
	public void testremoveValidElementBasedOnValue(){
		integerLinkedList.addAtLast(10);
		integerLinkedList.addAtLast(20);
		doubleLinkedList.addAtLast(10.00);
		doubleLinkedList.addAtLast(20.00);
		stringLinkedList.addAtLast("Vaishali");
		stringLinkedList.addAtLast("naina");
		Assert.assertTrue(integerLinkedList.removeElementBasedOnValue(10));
		Assert.assertTrue(doubleLinkedList.removeElementBasedOnValue(10.00));
		Assert.assertTrue(stringLinkedList.removeElementBasedOnValue("Vaishali"));
	}
	
	//test check to check remove invalid element based on value
	@Test
	public void testremoveInValidElementBasedOnValue(){
		integerLinkedList.addAtLast(10);
		integerLinkedList.addAtLast(20);
		doubleLinkedList.addAtLast(10.00);
		doubleLinkedList.addAtLast(20.00);
		stringLinkedList.addAtLast("Vaishali");
		stringLinkedList.addAtLast("naina");
		Assert.assertFalse(integerLinkedList.removeElementBasedOnValue(5));
		Assert.assertFalse(doubleLinkedList.removeElementBasedOnValue(5.00));
		Assert.assertFalse(stringLinkedList.removeElementBasedOnValue("Jain"));
	}
	
	// test case for removing element based on position
	@Test
	public void testremoveElementBasedOnValidPosition(){
		integerLinkedList.addAtLast(10);
		integerLinkedList.addAtLast(20);
		doubleLinkedList.addAtLast(10.00);
		doubleLinkedList.addAtLast(20.00);
		stringLinkedList.addAtLast("Vaishali");
		stringLinkedList.addAtLast("naina");
		Assert.assertTrue(integerLinkedList.removeElementBasedOnPosition(1));
		Assert.assertTrue(doubleLinkedList.removeElementBasedOnPosition(1));
		Assert.assertTrue(stringLinkedList.removeElementBasedOnPosition(1));
	}
	
	// test case for removing element based on invalid position
	@Test
	public void testremoveElementBasedOnInValidPosition(){
		integerLinkedList.addAtLast(10);
		integerLinkedList.addAtLast(20);
		doubleLinkedList.addAtLast(10.00);
		doubleLinkedList.addAtLast(20.00);
		stringLinkedList.addAtLast("Vaishali");
		stringLinkedList.addAtLast("naina");
		Assert.assertFalse(integerLinkedList.removeElementBasedOnPosition(0));
		Assert.assertFalse(doubleLinkedList.removeElementBasedOnPosition(0));
		Assert.assertFalse(stringLinkedList.removeElementBasedOnPosition(0));
	}
	
	// test case for removing element based on invalid position
	@Test
	public void testremoveElementBasedOnInValidsPosition(){
		integerLinkedList.addAtLast(10);
		integerLinkedList.addAtLast(20);
		doubleLinkedList.addAtLast(10.00);
		doubleLinkedList.addAtLast(20.00);
		stringLinkedList.addAtLast("Vaishali");
		stringLinkedList.addAtLast("naina");
		Assert.assertFalse(integerLinkedList.removeElementBasedOnPosition(3));
		Assert.assertFalse(doubleLinkedList.removeElementBasedOnPosition(3));
		Assert.assertFalse(stringLinkedList.removeElementBasedOnPosition(3));
	}
	
	//test case to get element based on valid position
	@Test
	public void testGetParticularElementBasedOnPosition(){
		Integer intExpected = new Integer(20);
		Double  doubleExpected=new Double(20.00);
		String stringExpected=new String("naina");
		integerLinkedList.addAtLast(10);
		integerLinkedList.addAtLast(20);
		doubleLinkedList.addAtLast(10.00);
		doubleLinkedList.addAtLast(20.00);
		stringLinkedList.addAtLast("Vaishali");
		stringLinkedList.addAtLast("naina");
		Assert.assertEquals((Integer)intExpected, (Integer)integerLinkedList.getParticularPositionElement(2));
		Assert.assertEquals((Double)doubleExpected, (Double)doubleLinkedList.getParticularPositionElement(2));
		Assert.assertEquals((String)stringExpected, (String)stringLinkedList.getParticularPositionElement(2));		
	}
	
	//test case to get element based on invalid position
	@Test
	public void testGetParticularElementBasedOnInvalidPosition(){
		Integer intExpected=null; 
		Double  doubleExpected=null;
		String stringExpected=null;
		integerLinkedList.addAtLast(10);
		integerLinkedList.addAtLast(20);
		doubleLinkedList.addAtLast(10.00);
		doubleLinkedList.addAtLast(20.00);
		stringLinkedList.addAtLast("Vaishali");
		stringLinkedList.addAtLast("naina");
		Assert.assertEquals((Integer)intExpected, (Integer)integerLinkedList.getParticularPositionElement(3));
		Assert.assertEquals((Double)doubleExpected, (Double)doubleLinkedList.getParticularPositionElement(3));
		Assert.assertEquals((String)stringExpected, (String)stringLinkedList.getParticularPositionElement(3));		
	}
	
	//test case to reverse list
	@Test
	public void testReverseList(){
		Integer intExpected = new Integer(10);
		Double  doubleExpected=new Double(10.00);
		String stringExpected=new String("Vaishali");
		integerLinkedList.addAtLast(10);
		integerLinkedList.addAtLast(20);
		doubleLinkedList.addAtLast(10.00);
		doubleLinkedList.addAtLast(20.00);
		stringLinkedList.addAtLast("Vaishali");
		stringLinkedList.addAtLast("naina");
		integerLinkedList.reverseList();
		doubleLinkedList.reverseList();
		stringLinkedList.reverseList();
		Assert.assertEquals((Integer)intExpected, (Integer)integerLinkedList.getParticularPositionElement(2));
		Assert.assertEquals((Double)doubleExpected, (Double)doubleLinkedList.getParticularPositionElement(2));
		Assert.assertEquals((String)stringExpected, (String)stringLinkedList.getParticularPositionElement(2));
		
	}
	
	//test case to sort list
	@Test
	public void testSort(){
		Integer intExpected = new Integer(10);
		Double  doubleExpected=new Double(10.00);
		String stringExpected=new String("Vaishali");
		integerLinkedList.addAtLast(10);
		integerLinkedList.addAtLast(5);
		doubleLinkedList.addAtLast(10.00);
		doubleLinkedList.addAtLast(5.00);
		stringLinkedList.addAtLast("Vaishali");
		stringLinkedList.addAtLast("naina");
		integerLinkedList.reverseList();
		doubleLinkedList.reverseList();
		stringLinkedList.reverseList();
		Assert.assertEquals((Integer)intExpected, (Integer)integerLinkedList.getParticularPositionElement(2));
		Assert.assertEquals((Double)doubleExpected, (Double)doubleLinkedList.getParticularPositionElement(2));
		Assert.assertEquals((String)stringExpected, (String)stringLinkedList.getParticularPositionElement(2));
		
	}


}
