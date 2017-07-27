package assignment2;

import java.util.Scanner;
/**
 * ClassName : MatrixMain
 * @author   : Vaishali Jain
 * Description : MainClass of matrix class
 */

public class Controller implements Action{
	
	Matrix matrixObject=null;
	//Integer scanner input class
	public static int scannerInputInt(){
		Scanner scInput=new Scanner(System.in);
		return scInput.nextInt();
	}
	public static char scannerInputChar(){
 		Scanner scInput=new Scanner(System.in);
 		return scInput.next().charAt(0);
 	}
	//Number of rows input class
   public static int enterNumberOfRows(){
   	 System.out.println("Enter number of rows for matrix");	 
   	 int noOfRows=scannerInputInt();
   	 return noOfRows;
    }
	//Number Of column input class
	public static int enterNumberOfColumns(){
    	 System.out.println("Enter number of columns for matrix"); 
    	 int noOfColumns=scannerInputInt();
    	 return noOfColumns;
     }
	/**
	 * take size and elements of matrix from user
	 * @return object of matrix class
	 */
	public static Matrix enterMatrix(){
		Scanner sc=new Scanner(System.in);
		int noOfRows=enterNumberOfRows();
		while(noOfRows<=0){
			System.out.println("Wrong Input");
			noOfRows=enterNumberOfRows();
		}
		int noOfColumns=enterNumberOfColumns();
		while(noOfColumns<=0){
			System.out.println("Wrong Input");
			noOfColumns=enterNumberOfColumns();
		}
		Matrix matrixObject=new Matrix(noOfRows,noOfColumns);
		System.out.println("Enter elements of matrix");
		for(int i=0;i<noOfRows;i++){
			for(int j=0;j<noOfColumns;j++){
				matrixObject.addElements(i,j,sc.nextInt());
			}
		}
		return matrixObject;
	}
	/**
	 * Display Matrix elements to user
	 * @param matrix take 2D array of matrix
	 */
   public static void showMatrix(int matrix[][]){
		System.out.println("Elements of matrix are");
		for(int i=0;i<matrix.length;i++){
			for(int j=0;j<matrix[0].length;j++){
		     System.out.print(matrix[i][j]+" ");
			}
			System.out.println();
	    }
	}
	@Override
	public void performAction(int choice) {
		switch(choice){
		case 0:
			//creation of matrix
			matrixObject= Controller.enterMatrix();
			break;
		case 1:
			//transpose of matrix
			if(matrixObject==null){
				System.out.println("Enter Matrix first");
				break;
			}
			System.out.println("transpose of matrix is");
			Matrix transposeMatrixObject=matrixObject.transposeMatrix();
			int transposeMatrix[][]=transposeMatrixObject.show();
			Controller.showMatrix(transposeMatrix);
			break;
		case 2:
			//multiplication of two matrix
			if(matrixObject==null){
				System.out.println("Enter first Matrix first");
				break;
			}
			Matrix MatrixTwo= Controller.enterMatrix();
			Matrix multipliedMatrix = matrixObject.matrixMultiply(MatrixTwo);
			int resultantMatrix[][]=multipliedMatrix .show();
			Controller.showMatrix(resultantMatrix);
			break;
		case 3:
			//display of matrix
			if(matrixObject==null){
				System.out.println("Enter first Matrix first");
				break;
			}
			System.out.println("Our entered matrix is");
			int displayMatrix[][]=matrixObject.show();
			Controller.showMatrix(displayMatrix);
			break;
		case 4:
			//to update element of matrix
			Scanner scanner =new Scanner(System.in);
			if(matrixObject==null){
				System.out.println("Enter first Matrix first");
				break;
			}
			System.out.println("Enter row number");
			int rowNumber=scanner.nextInt();
			if(rowNumber>=matrixObject.getNoOfRows()||rowNumber<0){
				System.out.println("Wrong row number");
				break;
			}
			System.out.println("Enter column  number");
			int columnNumber=scanner.nextInt();
			if(columnNumber>=matrixObject.getNoOfColumns()||columnNumber<0){
				System.out.println("Wrong column number");
				break;
			}
			System.out.println("Enter element ");
			int element=scanner.nextInt();
			matrixObject.addElements(rowNumber,columnNumber,element);
			break;
			
		}
		
		
	}
	
   
}




