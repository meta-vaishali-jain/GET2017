package assignment2;
import org.junit.*;
/**
 * Class name=InversePyramidTestNegatives
 * All negative test cases are in this class
 */
public class InversePyramidTestNegatives {
	InversePyramid complete_pyramid;
	@Before
	public void setup(){
		complete_pyramid=new InversePyramid();
	}
	/*
	 * Test case if size of pyramid is 0
	 */
	//space
	@Test(expected=NumberFormatException.class)
	public void testZeroSpace(){
		complete_pyramid.getSpace(4, 0);
	}
	//number
	@Test(expected=NumberFormatException.class)
	public void testZeroNumber(){
		complete_pyramid.getNumber(4,0);
	}
	//complete pyramid
	@Test(expected=NumberFormatException.class)
	public void testZeroPyramid(){
		complete_pyramid.numberPyramid(0);
	}
	/*
	 * Test case if there is negative value
	 */
	//Negative row for space
	@Test(expected=NumberFormatException.class)
	public void testNegativeRowSpace(){
		complete_pyramid.getSpace(-2, 3);
	}
	//Negative size for space
	@Test(expected=NumberFormatException.class)
		public void testNegativeSizeSpace(){
		complete_pyramid.getSpace(2, -3);
	}
	//Negative row for number
	@Test(expected=NumberFormatException.class)
	public void testNegativeRowNumber(){
		complete_pyramid.getNumber(-2, 3);
	}
	//Negative size for number
	@Test(expected=NumberFormatException.class)
	public void testNegativeSizeNumber(){
	complete_pyramid.getNumber(2, -3);
	}
	//Negative size for complete pyramid
	@Test(expected=NumberFormatException.class)
	public void testNegativePyramid(){
		complete_pyramid.numberPyramid(-3);
	}
	/*
	 * Test case if row >size of pyramid
	 */
	//space
	@Test(expected=NumberFormatException.class)
	public void testLargeRowForSpace(){
		complete_pyramid.getSpace(4, 3);
	}
	//row
	@Test(expected=NumberFormatException.class)
	public void testLargeRowForNumber(){
	complete_pyramid.getSpace(4, 3);
		
	}

}
