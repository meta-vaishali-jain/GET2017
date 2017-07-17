package assignment1;
/**
 *Class Name = Pyramid
 *@author-Vaishali Jain
 *creates Pyramid for 1 to given size and given size to 1
 */
public class Pyramid {
	/**
	 * For spacing on each row before number depending on row number
	 * @param row  describes row no
	 * @param n    describes size of pyramid
	 * @return
	 */
	public String getSpace(int row, int n){
		String spaces = "";
		/*
		 * throws number format exception depending on wrong input
		 */
		if(n<=0 | row >=2*n | row<=0){
			throw new NumberFormatException();
		}
		if(row>n){
			row=2*n-row;
		}
		for(int row_value = 1; row_value<=2*(n-row); row_value++){
			spaces += " ";
		}
		return spaces;
	}
	/**
	 * Number in  each row in increasing or decreasing order depending on row number
	 * @param row describes row no
	 * @param n   describes size of pyramid
	 * @return
	 */
	public String getNumber(int row, int n){
		 String numbers = ""; 
		/*
		 * throws number format exception depending on wrong input
		 */
		if(n<=0 | row >= 2*n | row <=0)
			throw new NumberFormatException();
		if(row>n){
			row=2*n-row;
		}
	    //For quarter left Pyramid
		for(int row_value = 1; row_value<row; row_value++){
			numbers += row_value+" ";
		}
		//For quarter right Pyramid
		for(int row_value= row; row_value>= 1; row_value--){
			numbers += row_value+" ";
		}
		return numbers;
	}
	/**
	 * Call both number and space method and concatenate both and return array of string .
	 * @param n  Size of Pyramid
	 * @return
	 */
	public String[] makePyramid(int n){
		String[] pyramid; 
		//Throws exception if size is less than 0
		if(n<=0){
			throw new NumberFormatException();
		}
		
		pyramid = new String[2*n -1];
		int k=0;//used for pointer for pyramid[]
		//For upper half Pyramid
		for(int row_no= 1; row_no < n; row_no++){
			pyramid[k++] = getSpace(row_no, n)+getNumber(row_no, n)+ "\n";
		}
		//For lower half Pyramid
		for(int row_no = n ; row_no > 0; row_no--){
			pyramid[k++] = getSpace(row_no, n)+getNumber(row_no, n)+"\n";
		}
		return pyramid;
	}
}
