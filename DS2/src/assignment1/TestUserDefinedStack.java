package assignment1;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;



public class TestUserDefinedStack {
	UserDefinedStack<Integer> intStack;
	UserDefinedStack<String> stringStack;
	
	@Before
	public void setup(){
		intStack=new UserDefinedStack<Integer>();
		stringStack=new UserDefinedStack<String>();
	}
	
	//test case to check stack size when stack is empty
	@Test
	public void testGetStackSize(){
		Assert.assertEquals(0,intStack.getStackSize());
		Assert.assertEquals(0,stringStack.getStackSize());
	}
	
	//test case to check push operation
	@Test
	public void testPush(){
		Assert.assertEquals(0,intStack.getStackSize());
		Assert.assertEquals(0,stringStack.getStackSize());
		intStack.push(10);
		intStack.push(20);
		stringStack.push("naina");
		stringStack.push("vaishali");
		Assert.assertEquals(2,intStack.getStackSize());
		Assert.assertEquals(2,stringStack.getStackSize());
	}
	
	//test case to check pop operation
	@Test
	public void testPop(){
		intStack.push(10);
		intStack.push(20);
		stringStack.push("naina");
		stringStack.push("vaishali");
		Assert.assertEquals((Integer)20,(Integer)intStack.pop());
		intStack.pop();
		Assert.assertEquals(null,(Integer)intStack.pop());
		Assert.assertEquals((String)"vaishali",(String)stringStack.pop());
		stringStack.pop();
		Assert.assertEquals(null,(String)stringStack.pop());
	}
	
	//test case to check peek operation
	@Test
	public void testPeek(){
		intStack.push(10);
		intStack.push(20);
		stringStack.push("naina");
		stringStack.push("vaishali");
		Assert.assertEquals((Integer)20,(Integer)intStack.peek());
		Assert.assertEquals((String)"vaishali",(String)stringStack.peek());
	}
	
	//test case to check peek operation
	@Test
	public void testPeekWhenStackEmpty(){
		Assert.assertEquals(null,(Integer)intStack.peek());
		Assert.assertEquals(null,(String)stringStack.peek());
	}
}
