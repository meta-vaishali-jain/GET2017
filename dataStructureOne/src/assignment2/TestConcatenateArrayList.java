package assignment2;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import assignment1.UserDefinedArrayList;

/**
 * ClassName  : TestConcatenateArrayList
 * @author 	  : Vaishali Jain
 * Description: Class to perfotm test on ConcatenateArrayListClass
 */
public class TestConcatenateArrayList {
	UserDefinedArrayList<Integer> integerFrstList;
	UserDefinedArrayList<Integer> integerSecondList;
	UserDefinedArrayList<String> stringFirstList;
	UserDefinedArrayList<String> stringSecondList;
	
	@Before
	public void setup() {
		integerFrstList = new UserDefinedArrayList<Integer>();
		integerSecondList = new UserDefinedArrayList<Integer>();
		stringFirstList = new UserDefinedArrayList<String>();
		stringSecondList = new UserDefinedArrayList<String>();
	}
	
	//Test case when type of array list is integer
	@Test
	public void testConcatenateIntegerList(){
		int expectedListSize=7;
		Integer expectedElement=70;
		integerFrstList.addItem(10);
		integerFrstList.addItem(20);
		integerFrstList.addItem(30);
		integerFrstList.addItem(40);
		integerSecondList.addItem(50);
		integerSecondList.addItem(60);
		integerSecondList.addItem(70);
		integerFrstList=new ConcatenateArrayList().joinTwoArrayList(integerFrstList,integerSecondList);
		Assert.assertEquals(expectedListSize,integerFrstList.getArraySize());
		Assert.assertEquals((Integer)expectedElement, (Integer)integerFrstList.getElementBasedOnPosition(7));
	}
	
	//Test case when type of array list is string
	@Test
	public void testConcatenateStringList(){
		int expectedListSize=3;
		String expectedElement="jain";
		stringFirstList.addItem("naina");
		stringFirstList.addItem("vaishali");
		stringSecondList.addItem("jain");	
		stringFirstList=new ConcatenateArrayList().joinTwoArrayList(stringFirstList,stringSecondList);
		
		Assert.assertEquals(expectedListSize,stringFirstList.getArraySize());
		Assert.assertEquals((String)expectedElement, (String)stringFirstList.getElementBasedOnPosition(3));
	}
}
