package assignment1;
import org.junit.*;
/**
 * Class Name=PyramidTestPositives
 * Describe all the positive Test Cases
 */
public class PyramidTestPositives {
	Pyramid whole_pyramid;
	@Before
	public void setUp(){
		whole_pyramid = new Pyramid();
	}
	//Test case for space for first row and when size of pyramid is 1
	@Test
	public void testOneSpace(){
		String expected_space = "";
		Assert.assertEquals(expected_space, whole_pyramid.getSpace(1,1));
	}
	//Test case for number for first row and when size of pyramid is 1 
	@Test
	public void testOneNumber(){
		String expected_no = "1 ";
		Assert.assertEquals(expected_no, whole_pyramid.getNumber(1, 1));
	}
	//Test case for complete Pyramid for first row and when size of pyramid is 1 
    @Test
	public void testOnePyramid(){
		String[] expected = {"1 \n"};
		Assert.assertArrayEquals(expected, whole_pyramid.makePyramid(1));		
	}
    //Test case for space for row>n and when size of pyramid is any number
	@Test
	public void testRandomSpace(){
		String expected_space = "    ";
		Assert.assertEquals(expected_space, whole_pyramid.getSpace(8, 6));
	}
	
	//Test case for number for row>n and when size of pyramid is any number
	@Test
	public void testRandommNumber(){	
		String expected_no = "1 2 3 4 3 2 1 ";
		Assert.assertEquals(expected_no, whole_pyramid.getNumber(8, 6));
	}
	//Test case for complete pyramid when size of pyramid is any number
	@Test
	public void testRandommPyramid(){	
		String[] expected = {
						 "          1 \n", 
						 "        1 2 1 \n",
						 "      1 2 3 2 1 \n",
						 "    1 2 3 4 3 2 1 \n",
						 "  1 2 3 4 5 4 3 2 1 \n",
						 "1 2 3 4 5 6 5 4 3 2 1 \n",
						 "  1 2 3 4 5 4 3 2 1 \n",
						 "    1 2 3 4 3 2 1 \n",
						 "      1 2 3 2 1 \n",
						 "        1 2 1 \n",
						 "          1 \n" };
		Assert.assertArrayEquals(expected, whole_pyramid.makePyramid(6));
	}
	

//Test case for space for   row < n and when size of pyramid is any number
	@Test
	public void testRandommSpace(){
		String expected_space = "      ";
		Assert.assertEquals(expected_space, whole_pyramid.getSpace(3, 6));
	}
	//Test case for number for  row<n and when size of pyramid is any number
	@Test
	public void testRandomNumber(){	
		String expected_no = "1 2 3 2 1 ";
		Assert.assertEquals(expected_no, whole_pyramid.getNumber(3, 6));
	}
	//Test case for complete pyramid  when size of pyramid is any number
	@Test
	public void testRandomPyramid(){	
		String[] expected = {
						 "          1 \n", 
						 "        1 2 1 \n",
						 "      1 2 3 2 1 \n",
						 "    1 2 3 4 3 2 1 \n",
						 "  1 2 3 4 5 4 3 2 1 \n",
						 "1 2 3 4 5 6 5 4 3 2 1 \n",
						 "  1 2 3 4 5 4 3 2 1 \n",
						 "    1 2 3 4 3 2 1 \n",
						 "      1 2 3 2 1 \n",
						 "        1 2 1 \n",
						 "          1 \n" };
		Assert.assertArrayEquals(expected, whole_pyramid.makePyramid(6));
	}
}