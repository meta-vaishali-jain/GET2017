package assignment1;
import org.junit.*;
/**
 * @author-Vaishali Jain
 * Class name=PyramidTestNegatives
 * All negative test cases are in this class
 */
public class PyramidTestNegatives {
	//Class for negative test cases
	Pyramid complete_pyramid;
	@Before
	public void setup(){
		complete_pyramid=new Pyramid();
	}
    //Test case if size of pyramid is zero
	//space
	@Test(expected=NumberFormatException.class)
	public void testZeroSpace(){
		complete_pyramid.getSpace(4, 0);
	}
	//row
	@Test(expected=NumberFormatException.class)
	public void testZeroNumber(){
		complete_pyramid.getNumber(4,0);
	}
	//complete pyramid
	@Test(expected=NumberFormatException.class)
	public void testZeroPyramid(){
		complete_pyramid.makePyramid(0);
	}
	
	//Test cases if size of pyramid or row is negative
	//Row negative for space
	@Test(expected=NumberFormatException.class)
	public void testNegativeRowSpace(){
		complete_pyramid.getSpace(-2, 3);
	}
	//Size negative for space
	@Test(expected=NumberFormatException.class)
	public void testNegativeSizeSpace(){
		complete_pyramid.getSpace(2, -3);
	}
	//Row negative for number
	@Test(expected=NumberFormatException.class)
	public void testNegativeRowNumber(){
		complete_pyramid.getNumber(-2, 3);
	}
	//size negative for number
	@Test(expected=NumberFormatException.class)
	public void testNegativeSizeNumber(){
		complete_pyramid.getNumber(2, -3);
	}
	//size negative for complete pyramid
	@Test(expected=NumberFormatException.class)
	public void testNegativePyramid(){
		complete_pyramid.makePyramid(-3);
	}
	//Test case if row number is greater than 2*size of pyramid
    //space
	@Test(expected=NumberFormatException.class)
	public void testInvalidRowNumberSpace(){
		complete_pyramid.getSpace(12,5);
	}
	//number
	@Test(expected=NumberFormatException.class)
	public void testInvalidRowNumberNumber(){
		complete_pyramid.getSpace(12,5);
	}

}
