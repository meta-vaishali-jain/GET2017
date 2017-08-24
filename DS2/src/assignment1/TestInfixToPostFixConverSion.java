package assignment1;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestInfixToPostFixConverSion {
	NewInfixToPostFixConversion converter;
	
	@Before
	public void setup(){
		converter=new NewInfixToPostFixConversion();
	}
	
	//test case to check valid string
	@Test
	public void testValidString(){
		String expected="abcd^*+e-fgh*+^i-";
		Assert.assertEquals(expected,converter.infixToPostFixConversion("(a+b*c^d-e)^(f+g*h)-i"));
	}
	
	//test case to check null string
	@Test
	public void testNullString(){
		Assert.assertEquals(null,converter.infixToPostFixConversion(null));
	}
	
	//test cases to check invalid steing due to parenthesis mismatching
	@Test
	public void testInvalidString(){
		Assert.assertEquals(null,converter.infixToPostFixConversion("a+b*c^d-e)^(f+g*h)-i"));
	}
	
	@Test
	public void testInvalidRightParenthesisString(){
		Assert.assertEquals(null,converter.infixToPostFixConversion("(a+b*c^d-e)^(f+g*h)-i)"));
	}
}
