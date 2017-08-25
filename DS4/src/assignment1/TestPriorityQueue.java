package assignment1;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * ClassName :TestPriorityQueue
 * @author   :Vaishali Jain
 *
 */
public class TestPriorityQueue {
	PriorityQueue queue;
	
	@Before
	public void setup(){
		queue=new PriorityQueue();
	}
	
	//test case to check if queue is empty
	@Test
	public void testIsQueueEmpty(){
		Assert.assertTrue(queue.queueEmpty());
	}
	
	//test case to check insert function
	@Test
	public void testInsert(){
		Assert.assertTrue(queue.insert("naina",2,"Graduates"));
		Assert.assertFalse(queue.queueEmpty());
	}
	
	//test case to check heapify method
	@Test
	public void testHeapify(){
		queue.insert("naina",2,"Graduates");
		queue.insert("Shreya",3,"Professors");
		Assert.assertEquals(3,queue.print()[0].getPriority());
	}
	
	//test case to check if priorities are same
	@Test
	public void testPrintIfPrioritiesAreSame(){
		queue.insert("naina",2,"Graduates");
		queue.insert("Shreya",2,"Graduates");
		Assert.assertEquals(1,queue.print()[0].getJobNo());		
	}
	
	//test case to check print if priorities are different
	@Test
	public void testPrintIfPrioritiesAreDifferent(){
		queue.insert("naina",2,"Graduates");
		queue.insert("Shreya",1,"UnderGraduates");
		Assert.assertEquals(2,queue.print()[0].getPriority());		
	}
	
	
}
