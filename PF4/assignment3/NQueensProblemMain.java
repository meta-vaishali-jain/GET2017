package assignment3;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/**
 * Class Name : NQueensProblemMain
 * @author    : Vaishali Jain
 * Description : Main Class
 */
public class NQueensProblemMain {
	int matrixDimension;
	int chessBoard[][] ;
	void getInputFromUser(){
		System.out.println("Enter the dimension of matrix");
		Scanner sc=new Scanner(System.in);
		matrixDimension=sc.nextInt();
		chessBoard =new int[matrixDimension][matrixDimension];
		for(int i=0;i<matrixDimension;i++){
			for(int j=0;j<matrixDimension;j++){
			    chessBoard[i][j]=0;	
			}
		}
	}
	public static void main(String args[]){
		NQueensProblemMain mainObject=new NQueensProblemMain();
		NQueensProblem placingNQueens=new NQueensProblem();
		NQueensProblemRunner runner=new NQueensProblemRunner();
		mainObject.getInputFromUser();
		boolean result=placingNQueens.findQueenPlace(mainObject.chessBoard, 0, 4);
		System.out.println(result);
       for(int i=0;i<mainObject.matrixDimension;i++){
			for(int j=0;j<mainObject.matrixDimension;j++){
				System.out.print(mainObject.chessBoard[i][j]);
			}
			System.out.println();
		}
		//calling test runner class
		runner.TestRunner();
	}
}