package assignment1;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
/**
 * Class Name : TestComputeLargestDigit
 * @author    : Vaishali Jain
 * Description : Describes Test cases for computeRemainder class
 */
public class TestComputeLargestDigit {
	ComputeLargestDigit largestDigit;
	@Before
	public void setup(){
		largestDigit= new ComputeLargestDigit();
	}
	// Test for single digit number
	@Test
	public void testForSingleDigitNumber(){
		int expectedDigit=largestDigit.getLargestDigit(2);
		Assert.assertEquals(2, expectedDigit);
	}
	// Test for all same digit number
	@Test
	public void testForThreeDigitSameNumber(){
		int expectedDigit=largestDigit.getLargestDigit(444);
		Assert.assertEquals(4, expectedDigit);
	}
	//Test for all different number
	@Test
	public void testForThreeDigitNumber(){
		int expectedDigit=largestDigit.getLargestDigit(486);
		Assert.assertEquals(8, expectedDigit);
	}
	//Test for number zero
	@Test
	public void testForZeroNumber(){
		int expectedDigit=largestDigit.getLargestDigit(0);
		Assert.assertEquals(0, expectedDigit);
	}
	//Test for large number
	@Test
	public void testForLargeNumber(){
		int expectedDigit=largestDigit.getLargestDigit(1257639);
		Assert.assertEquals(9, expectedDigit);
	}
	//Test for negative number
	@Test(expected=IllegalArgumentException.class)
	public void testForNumberNegative(){
		largestDigit.getLargestDigit(-864);
	}
	
}
