package assignment1;
import org.junit.*;
/**
 * Class Name : TestComputeRemainder
 * @author    : Vaishali Jain
 * Description : Describes Test cases for computeRemainder class
 */
public  class TestComputeRemainder {
	ComputeRemainder remainder;
	
	@Before
	public void setup(){
		remainder = new ComputeRemainder();
	}
	// Normal Test case for any two number
	@Test
	public void testForCorrectValueOne(){
		int expectedRemainder=remainder.getRemainder(100, 3);
		Assert.assertEquals(1, expectedRemainder);
	}
	// Normal Test case for any two number
	@Test
	public void testForCorrectValueTwo(){
		int expectedRemainder=remainder.getRemainder(2,1);
		Assert.assertEquals(0, expectedRemainder);
	}
	// Test case if dividend is zero
	@Test
	public void testForDividendZero(){
		int expectedRemainder=remainder.getRemainder(0,1);
		Assert.assertEquals(0, expectedRemainder);
	}
	// Test case if divisor is zero
	@Test(expected=IllegalArgumentException.class)
	public void TestForDivisorZero(){
		remainder.getRemainder(2, 0);
	}
	// Test case if dividend is negative
	@Test(expected=IllegalArgumentException.class)
	public void TestForDividendNegative(){
		remainder.getRemainder(-2, 3);
	}
	// Test case if divisor is negative
	@Test(expected=IllegalArgumentException.class)
	public void TestForDivisorNegative(){
		remainder.getRemainder(2,-3);
	}
	// Test case if both are negative
	@Test(expected=IllegalArgumentException.class)
	public void TestForBothNegative(){
		remainder.getRemainder(-2,-3);
	}
}
	


