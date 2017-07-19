package assignment3;
/**
 * ClassName NQueensProblem
 * @author Vaishali Jain
 * Description : To solve the NQueen Problem
 */
	public class NQueensProblem{
	/**
	 * function to check if a queen can be placed on chessBoard[rowNumber][columnNumber]
	 * @param chessBoard
	 * @param rowNumber 
	 * @param columnNumber
	 * @param dimensionOfMatrix
	 * @return
	 */
    	boolean safeQueenPlace(int chessBoard[][],int rowNumber,int columnNumber,int dimensionOfMatrix){
		int i, j;
	     // check particular board row on left side
		 for ( i = 0; i < columnNumber; i++){
	            if (chessBoard[rowNumber][i] == 1)
	                return false;
		 }
	    // Check upper diagonal on left side 
	     for (i=rowNumber,j=columnNumber; i>=0 & j>=0; i--, j--){
	            if (chessBoard[i][j] == 1)
	                return false;
	     }
	     //Check lower diagonal on left side 
	        for (i=rowNumber, j=columnNumber; j>=0 & i<dimensionOfMatrix; i++, j--){
	            if (chessBoard[i][j] == 1)
	                return false;
	        }
	        return true;
	}
    	/**
    	 * to find queen place and to test if it satisfies or not
    	 * @param chessBoard
    	 * @param columnNumber
    	 * @param dimensionOfMatrix
    	 * @return
    	 */
	boolean findQueenPlace(int chessBoard[][],int columnNumber,int dimensionOfMatrix){
		if(columnNumber<0 | dimensionOfMatrix<=0){
			throw new IllegalArgumentException();
		}
		if(columnNumber>=dimensionOfMatrix){
			return true;
		}
		for(int rowNumber=0;rowNumber<dimensionOfMatrix;rowNumber++){
			//to check if queen can be placed to particular location or not
			if(safeQueenPlace(chessBoard,rowNumber,columnNumber,dimensionOfMatrix)){
				chessBoard[rowNumber][columnNumber]= 1;
			    
				if(findQueenPlace(chessBoard,columnNumber+1,dimensionOfMatrix)){
					return true;
				}
				//backtracking if it doesnot lead to correct solution
				chessBoard[rowNumber][columnNumber]= 0;
			}
			
		}
		return false;
	}
}

