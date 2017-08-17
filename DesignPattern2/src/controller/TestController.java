package controller;
import org.junit.*;

public class TestController {
	Controller controller;
      
	@Before
	public void setup(){
		controller=Controller.getInstance();	
	}
	
	//Test case to check entered input is in number format only
	//when number
	@Test
	public void testIsValidNumber(){
		Assert.assertTrue(controller.isNumber("1"));
	}
	//when not number
	@Test
	public void testIsInvalidNumber(){
		Assert.assertFalse(controller.isNumber("abc"));
	}
	
	//Test case to check entered choice is valid or not
	//when choice is valid
	@Test
	public void testIsValidChoice(){
		Assert.assertTrue(controller.isNumber("1"));
		Assert.assertTrue(controller.isValidChoice("1"));
	}
	//when choice is not valid
	@Test
	public void testIsInvalidChoice(){
		Assert.assertTrue(controller.isNumber("8"));
		Assert.assertFalse(controller.isValidChoice("8"));
	}
		
}
