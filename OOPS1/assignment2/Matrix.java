package assignment2;

import java.util.InputMismatchException;

/**
 * ClassName : Matrix
 * @author   : Vaishali Jain
 * Description : Class performing different operations on matrix using OOPS concept
 */
public class Matrix {
	private int dataMatrix[][];
	private int noOfRows;
	private int noOfColumns;
	
	//default constructor
	public Matrix(){
		noOfRows=0;
		noOfColumns=0;
		dataMatrix=new int[noOfRows][noOfColumns];
	}
	
	//parameterize constructor
	public Matrix(int noOfRows,int noOfColumns){
		//throws exception if argument are not correct 
		if(noOfRows<=0 | noOfRows<=0){
			throw new IllegalArgumentException();
		}
		this.noOfRows= noOfRows;
		this.noOfColumns=noOfColumns;
		dataMatrix=new int[noOfRows][noOfColumns];
	}
	
	/**
	 * To add elements in matrix at given row number and column number
	 * @param rowNumber   row number at which element is to be added
	 * @param columnNumber column number at which element is to be added
	 * @param element      element which is to be added in array
	 */
	public void addElements(int rowNumber,int columnNumber,int element){
		//throws exception if argument are not correct 
				if(rowNumber<0 | columnNumber<0){
					throw new IllegalArgumentException();
				}
				if(rowNumber>=this.noOfRows | columnNumber>=this.noOfColumns){
					throw new ArrayIndexOutOfBoundsException();
				}
		dataMatrix[rowNumber][columnNumber]=element;
	}
	
	/**
	 * To find transpose of the matrix
	 * @return
	 */
	public Matrix transposeMatrix(){
		Matrix matrixTranspose=new Matrix(this.noOfColumns,this.noOfRows);
		for(int i=0;i<this.noOfRows;i++){
			for(int j=0;j<this.noOfColumns;j++){
				matrixTranspose.addElements(j,i,dataMatrix[i][j]);
			}
		}
		return matrixTranspose;
	}
	
	/**
	 * Two multiply two matrices
	 * @param secondMatrix
	 * @return
	 */
	public Matrix matrixMultiply(Matrix secondMatrix){
		if(this.noOfColumns!=secondMatrix.noOfRows){
			throw new InputMismatchException();
		}
		Matrix resultantMatrix=new Matrix(this.noOfRows,secondMatrix.noOfColumns);
		for(int i=0;i< this.noOfRows;i++){
			for(int j=0;j< secondMatrix.noOfColumns;j++){
				for(int k=0;k<this.noOfColumns;k++){
					resultantMatrix.dataMatrix[i][j]+=this.dataMatrix[i][k]*secondMatrix.dataMatrix[k][j];
				}
			}
		}
			return resultantMatrix;
		}

	
	/**
	 * method to show elements of matrix
	 * @return return matrix
	 */
	public int[][] show(){
		return this.dataMatrix;
	}

}
