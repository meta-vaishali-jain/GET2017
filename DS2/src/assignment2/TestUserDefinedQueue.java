package assignment2;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;



public class TestUserDefinedQueue {
	UserDefinedQueue<Integer> queueInteger;
	UserDefinedQueue<String> queueString;
	
	@Before
	public void setup(){
		queueInteger=new UserDefinedQueue<Integer>();
		queueString=new UserDefinedQueue<String>();
	}
	
	//test case to check queue enqueue operation
	@Test
	public void testEnqueue(){
		queueInteger.enqueue(10);
		queueInteger.enqueue(20);
		queueString.enqueue("Naina");
		queueString.enqueue("vaishali");
		Assert.assertEquals(2,queueInteger.getArrayList().getArraySize());
		Assert.assertEquals(2,queueString.getArrayList().getArraySize());		
	}
	
	//test case to check queue dequeue operation
	@Test
	public void testDequeue(){
		queueInteger.enqueue(10);
		queueInteger.enqueue(20);
		queueString.enqueue("Naina");
		queueString.enqueue("vaishali");
		Assert.assertEquals("Naina",queueString.dequeue());
		Assert.assertEquals(10,queueInteger.dequeue());
	}
	
	//test case to check queue get front operation
	@Test
	public void testGetFront(){
		queueInteger.enqueue(10);
		queueInteger.enqueue(20);
		queueString.enqueue("Naina");
		queueString.enqueue("vaishali");
		Assert.assertEquals("Naina",queueString.getFront());
		Assert.assertEquals(10,queueInteger.getFront());
	}
	
}
