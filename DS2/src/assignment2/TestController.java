package assignment2;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestController {
	Controller controller;
	
	@Before
	public void setup(){
		controller=new Controller();
		
	}
	
	@Test
	public void testAssignCollege(){
		controller.initialiseColleges();
		Assert.assertEquals(5,controller.collegeDetails.size());
	}
	
	@Test
	public void testTotalNumberOfSeats(){
		controller.initialiseColleges();
		controller.getTotalNumberOfSeats();
		Assert.assertEquals(5,controller.getTotalNumberOfAvailableSeats());
	}
	
	@Test
	public void testAssignSeats(){
		controller.initialiseColleges();
		Assert.assertTrue(controller.assignSeats(1,1));
	}
	
	@Test
	public void testNotAssignedSeats(){
		controller.initialiseColleges();
		Assert.assertFalse(controller.assignSeats(4,1));
	}
	}
