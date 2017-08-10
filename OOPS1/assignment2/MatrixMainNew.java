package assignment2;

import java.util.Scanner;
/**
 * ClassName : MatrixMain
 * @author   : Vaishali Jain
 * Description : MainClass of matrix class
 */

public class MatrixMainNew {
	void menu(){
		System.out.println("Enter what you want to do\n"
	            +"1. Want to enter Matrix\n"
	            +"2. Find Transpose Of Matrix\n"
	            +"3. Multiplication of Matrix\n"
	            +"4. Display Matrix\n");
	}
	//Integer scanner input class
	int scannerInputInt(){
		Scanner scInput=new Scanner(System.in);
		return scInput.nextInt();
	}
	char scannerInputChar(){
 		Scanner scInput=new Scanner(System.in);
 		return scInput.next().charAt(0);
 	}
	//Number of rows input class
	int enterNumberOfRows(){
   	 System.out.println("Enter number of rows for matrix");	 
   	 int noOfRows=scannerInputInt();
   	 return noOfRows;
    }
	//Number Of column input class
	int enterNumberOfColumns(){
    	 System.out.println("Enter number of columns for matrix"); 
    	 int noOfColumns=scannerInputInt();
    	 return noOfColumns;
     }
	/**
	 * take size and elements of matrix from user
	 * @return object of matrix class
	 */
	 Matrix enterMatrix(){
		Scanner sc=new Scanner(System.in);
		int noOfRows=enterNumberOfRows();
		if(noOfRows<=0){
			System.out.println("Wrong Input");
			noOfRows=enterNumberOfRows();
		}
		int noOfColumns=enterNumberOfColumns();
		if(noOfColumns<=0){
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
   void showMatrix(int matrix[][]){
		System.out.println("Elements of matrix are");
		for(int i=0;i<matrix.length;i++){
			for(int j=0;j<matrix[0].length;j++){
		     System.out.print(matrix[i][j]+" ");
			}
			System.out.println();
	    }
	}
	public static void main(String args[]){
		MatrixMainNew mainObject=new MatrixMainNew();
		int choiceOfUser;
		char choice = 0;
		
		do{
			
			mainObject.menu();
			choiceOfUser=mainObject.scannerInputInt();
			if(choiceOfUser<=0 || choiceOfUser>4){
				System.out.println("Wrong input");
				mainObject.menu();
			}
			switch(choiceOfUser){
			// To enter Matrix
			case 1:
		        mainObject.enterMatrix();
				break;
				//To find transpose of matrix
			case 2:
				Matrix enteredMatrix= mainObject.enterMatrix();
				System.out.println("transpose of matrix is");
				Matrix transposeMatrixObject=enteredMatrix.transposeMatrix();
				int transposeMatrix[][]=transposeMatrixObject.show();
				mainObject.showMatrix(transposeMatrix);
				break;
				//to find multiplication of matrix
			case 3:
				Matrix MatrixOne= mainObject.enterMatrix();
				Matrix MatrixTwo= mainObject.enterMatrix();
				Matrix multipliedMatrix = MatrixOne.matrixMultiply(MatrixTwo);
				int resultantMatrix[][]=multipliedMatrix .show();
				mainObject.showMatrix(resultantMatrix);
				break;
				//for the display of matrix
			case 4:
				Matrix enteredDisplayMatrix= mainObject.enterMatrix();
				System.out.println("Our entered matrix is");
				int displayMatrix[][]=enteredDisplayMatrix.show();
				mainObject.showMatrix(displayMatrix);
				break;
				
			}
			System.out.println("Want to go to menu");
			choice=mainObject.scannerInputChar();
		}while(choice=='Y'||choice=='y');	
	}
}




