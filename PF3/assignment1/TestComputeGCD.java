package assignment1;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
/**
 * Class Name : TestComputeGCD
 * @author    : Vaishali Jain
 * Description : Describes Test cases for computeGCD class
 */

public class TestComputeGCD {
ComputeGCD divisor;
	
	@Before
	public void setup(){
		divisor= new ComputeGCD();
	}
	// Test case if first number is greater than second number
	@Test
	public void testForCorrectValueOne(){
		int expectedGCD=divisor.greatestCommonDivisor(2, 1);
		Assert.assertEquals(1, expectedGCD);
	}
	// Test case if second number is greater than first number
	@Test
	public void testForCorrectValueTwo(){
		int expectedGCD=divisor.greatestCommonDivisor(12,18);
		Assert.assertEquals(6, expectedGCD);
	}
	// Random Test case
	@Test
	public void testForCorrectValueThree(){
		int expectedGCD=divisor.greatestCommonDivisor(100,3);
		Assert.assertEquals(1, expectedGCD);
	}
	// Test case if number one is zero
	@Test
	public void testForNumberOneZero(){
		int expectedGCD=divisor.greatestCommonDivisor(0,3);
		Assert.assertEquals(3, expectedGCD);
	}
	// Test case if number second is zero
	@Test
	public void testForNumberSecondZero(){
		int expectedGCD=divisor.greatestCommonDivisor(5,0);
		Assert.assertEquals(5, expectedGCD);
	}
	// Test case if  both number are zero
	@Test
	public void testForBothNumberZero(){
		int expectedGCD=divisor.greatestCommonDivisor(0,0);
		Assert.assertEquals(0, expectedGCD);
	}
	// Test case if  first number is negative
	@Test(expected=IllegalArgumentException.class)
	public void testForNumberOneNegative(){
		divisor.greatestCommonDivisor(-2,3);
	}
	// Test case if  second number is negative
	@Test(expected=IllegalArgumentException.class)
	public void testForNumberSecondNegative(){
		divisor.greatestCommonDivisor(2,-3);
	}
	// Test case if  both number are negative
	@Test(expected=IllegalArgumentException.class)
	public void testForBothNumberNegative(){
		divisor.greatestCommonDivisor(-2,-3);
	}

}
