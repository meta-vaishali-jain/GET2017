package assignment2;

import java.util.NoSuchElementException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * ClassName : TestQueue
 * @author   : Vaishali Jain
 * Description: Test class to test Queue class
 */
public class TestQueue {
		Queue<Integer> integerQueue;
		Queue<String> stringQueue;
		
		@Before
		public void setup(){
			integerQueue=new Queue<Integer>();
			stringQueue=new Queue<String>();
		}
		
		//test case to check if queue is empty
		@Test
		public void testIfQueueEmpty(){
			Assert.assertTrue(integerQueue.isEmpty());
			Assert.assertTrue(stringQueue.isEmpty());
		}
		
		//test case to check if queue is not empty
		@Test
		public void testIfQueueNotEmpty(){
			integerQueue.add(10);
			stringQueue.add("naina");
			Assert.assertFalse(integerQueue.isEmpty());
			Assert.assertFalse(stringQueue.isEmpty());
		}
		
		//test case to test add method
		@Test
		public void testAdd(){
			Assert.assertTrue(integerQueue.add(10));
			Assert.assertTrue(stringQueue.add("naina"));
			Assert.assertEquals(1,integerQueue.size());
			Assert.assertEquals(1,stringQueue.size());
		}
		
		//test case to check add method if element is null
		@Test
		public void testIfNullIsToAdd(){
			Assert.assertFalse(integerQueue.add(null));
			Assert.assertFalse(stringQueue.add(null));
		}
		
		//test case to check remove method
		@Test
		public void testRemove(){
			integerQueue.add(10);
			integerQueue.add(20);
			stringQueue.add("naina");
			stringQueue.add("vaishali");
			Assert.assertEquals(2,integerQueue.size());
			Assert.assertEquals(2,stringQueue.size());
			Assert.assertEquals(10,integerQueue.remove());
			Assert.assertEquals("naina",stringQueue.remove());
			Assert.assertEquals(1,integerQueue.size());
			Assert.assertEquals(1,stringQueue.size());	
		}
		
		//test case to check remove method if queue is empty
		@Test(expected=NoSuchElementException.class)
		public void testRemoveIfQueueEmpty(){
			integerQueue.remove();
			stringQueue.remove();
		}
		
		//test case to check poll method
		@Test
		public void testPoll(){
			integerQueue.add(10);
			integerQueue.add(20);
			stringQueue.add("naina");
			stringQueue.add("vaishali");
			Assert.assertEquals(2,integerQueue.size());
			Assert.assertEquals(2,stringQueue.size());
			Assert.assertEquals(10,integerQueue.poll());
			Assert.assertEquals("naina",stringQueue.poll());
			Assert.assertEquals(1,integerQueue.size());
			Assert.assertEquals(1,stringQueue.size());	
		}
		
		//test case to check poll if queue is empty
		@Test
		public void testPollIfQueueEmpty(){
			Assert.assertEquals(null,integerQueue.poll());
			Assert.assertEquals(null,stringQueue.poll());
		}
		
		//test case to check get Element method
		@Test
		public void testElement(){
			integerQueue.add(10);
			integerQueue.add(20);
			stringQueue.add("naina");
			stringQueue.add("vaishali");
			Assert.assertEquals(10,integerQueue.element());
			Assert.assertEquals("naina",stringQueue.element());
		}
		
		//test case to check get element method if queue is empty 
		@Test(expected=NoSuchElementException.class)
		public void testElementIfQueueEmpty(){
			integerQueue.element();
			stringQueue.element();
		}
		
		//test  case to check peek method
		@Test
		public void testPeek(){
			integerQueue.add(10);
			integerQueue.add(20);
			stringQueue.add("naina");
			stringQueue.add("vaishali");
			Assert.assertEquals(10,integerQueue.peek());
			Assert.assertEquals("naina",stringQueue.peek());
		}
		
		//test case to check peek if queue is empty
		@Test
		public void testPeekIfQueueEmpty(){
			Assert.assertEquals(null,integerQueue.peek());
			Assert.assertEquals(null,stringQueue.peek());
		}
		
		//test case to check size if queue is empty
		@Test
		public void testSizeIfQueueEmpty(){
			Assert.assertEquals(0,integerQueue.size());
			Assert.assertEquals(0,stringQueue.size());
		}
		
		//test case to check size if queue has element
		@Test
		public void testSizeIfQueueHasElement(){
			integerQueue.add(10);
			integerQueue.add(20);
			stringQueue.add("naina");
			stringQueue.add("vaishali");
			Assert.assertEquals(2,integerQueue.size());
			Assert.assertEquals(2,stringQueue.size());
		}
		
		//test case to check clear method
		@Test
		public void testClear(){
			integerQueue.add(10);
			integerQueue.add(20);
			stringQueue.add("naina");
			stringQueue.add("vaishali");
			Assert.assertEquals(2,integerQueue.size());
			Assert.assertEquals(2,stringQueue.size());
			integerQueue.clear();
			stringQueue.clear();
			Assert.assertEquals(0,integerQueue.size());
			Assert.assertEquals(0,stringQueue.size());
		}
		
}
