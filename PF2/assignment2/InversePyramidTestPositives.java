package assignment2;
/**
 * @author-Vaishali Jain
 * Class name=InversePyramidTestNegatives
 * All negative test cases are in this class
 */
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class InversePyramidTestPositives {
	    InversePyramid complete_pyramid;
		
	    @Before
		public void setup(){
			complete_pyramid=new InversePyramid();
		}
		
	    /*
		 * Test case if size of pyramid is 1
		 */
		//Space
		@Test
		public void testOneSpace(){
			String expected_space="";
			Assert.assertEquals(expected_space,complete_pyramid.getSpace(0, 1));
		}
		//Number
		@Test
		public void testOneNumber(){
			String expected_no="1 ";
		    Assert.assertEquals(expected_no,complete_pyramid.getNumber(0, 1));
		}
		//Complete Pyramid
		@Test
		public void testOnePyramid(){
		String[] expected_pyramid={"1 \n"};
		Assert.assertArrayEquals(expected_pyramid,complete_pyramid.numberPyramid(1));
		}
		/*
		 * Test case if size of pyramid is any number
		 */
		//space
		@Test
		public void testRandomSpace(){
			String expected_space = "    ";
			Assert.assertEquals(expected_space, complete_pyramid.getSpace(2, 5));
		}
		//row
		@Test
		public void testRandomNumber(){
			String expected_no = "1 2 3 ";
			Assert.assertEquals(expected_no, complete_pyramid.getNumber(2, 5));
		}
		//complete pyramid
		@Test
		public void testRandomPyramid(){
			String[] expected = {"1 2 3 4 5 \n",
							     "  1 2 3 4 \n",
							     "    1 2 3 \n",
							     "      1 2 \n",
							     "        1 \n"};
			Assert.assertArrayEquals(expected, complete_pyramid.numberPyramid(5));
		}
		}

