package assignment2;

import java.util.InputMismatchException;

import org.junit.*;

/**
 * ClassName:TestMatrix
 * @author  :Vaishali Jain
 * Description:Describe test cases for all the methods of Matrix class 
 */

public class TestMatrix {
	Matrix matrix;
	
	@Before
	public void setup(){
		matrix=new Matrix(2, 3);
	}
	/*
	 * Test case for method add element
	 */
	//Negative test cases
	@Test(expected=IllegalArgumentException.class)
	public void testRowNumberNegative(){
		matrix.addElements(-2,3,10);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testColumnNumberNegative(){
		matrix.addElements(2,-3,10);
	}
	
	@Test(expected = ArrayIndexOutOfBoundsException.class)
	public void testForOutOfBoundsRow() {
		matrix.addElements(20, 2, 12);
	}
	//positive test cases
	@Test
	public void testForAddingElement() {
		matrix.addElements(1, 2, 12);
	    int resultantMatrix[][]=matrix.show();
	    Assert.assertEquals(12,resultantMatrix[1][2]);
	}
	/*
	 * Test cases for method transpose matrix
	 */
	@Test
	public void testTranspose() {
		matrix.addElements(0,0, 1);
		matrix.addElements(0,1, 4);
		matrix.addElements(0,2, 3);
		matrix.addElements(1,0, 2);
		matrix.addElements(1,1,-6);
		matrix.addElements(1,2, 0);
 		
		int[][] expected = {{1,2},
				            {4,-6},
				            {3,0}};
	
		Matrix result=matrix.transposeMatrix();
		 int resultantMatrix[][]=result.show();
		for(int i=0; i< 3; i++) {
			Assert.assertArrayEquals(expected[i], resultantMatrix[i]);
		}
	}
	/*
	 * Test case for multiplication of array
	 */
	@Test
	public void testMultiplyMatrices() {
		Matrix multiplymatrix = new Matrix(3, 2);
		matrix.addElements(0,0, 1);
		matrix.addElements(0,1, 4);
		matrix.addElements(0,2, 3);
		matrix.addElements(1,0, 2);
		matrix.addElements(1,1,-6);
		matrix.addElements(1,2, 0);
		
		multiplymatrix.addElements(0,0, 1);
		multiplymatrix.addElements(0,1, 4);
		multiplymatrix.addElements(1,0, 2);
		multiplymatrix.addElements(1,1, 6);
		multiplymatrix.addElements(2,0, 0);
		multiplymatrix.addElements(2,1, 0);
		
		Matrix result= matrix.matrixMultiply(multiplymatrix);
		 int resultantMatrix[][]=result.show();
		
		int[][] expected = {{9, 28},
							{-10, -28}};
		
		for(int i=0; i<2; i++) {
			Assert.assertArrayEquals(expected[i], resultantMatrix[i]);
		}
	}
	 //Negative test case
	@Test(expected = InputMismatchException.class)
	public void testIncompatibleMultiply() {
		matrix.matrixMultiply(matrix);
	}
	//Test case for show matrix
	@Test
	public void testDisplayingMatrix() {
		int[][] expected = {{1, 4},
							{2, -6}};
		
		matrix = new Matrix(2, 2);
		matrix.addElements(0,0, 1);
		matrix.addElements(0,1, 4);
		matrix.addElements(1,0, 2);
		matrix.addElements(1,1,-6);
		int resultantMatrix[][]=matrix.show();
		for(int i=0; i< 2; i++) {
			Assert.assertArrayEquals(expected[i], resultantMatrix[i]);
		}		
	}
}
