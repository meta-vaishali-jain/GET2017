package assignment2;
/**
 * @author-Vaishali Jain
 * Class name = Pyramid
 * Create  quarter pyramid in inverse order from 1 to given size 
 */
public class InversePyramid {
	/**
	 * For spacing on each row before number depending on row number
	 * @param row describes row number
	 * @param n   describes size of pyramid
	 * @return
	 */
	public String getSpace(int row,int n){
		//throws exception if wrong input or wrong number format
		if(n<=0 | row<0 |row>=n){
			throw new NumberFormatException();	
		}
		// loop for spacing
	    String spaces="";
	    for(int i=0;i<row;i++){
		 spaces=spaces+"  ";
	 }
	 return spaces;
	}
	/**
	 * For number string on each row depending on row number
	 * @param row  describes row number
	 * @param n    describes size of pyramid
	 * @return
	 */
    public String getNumber(int row,int n){
    	//throws exception if wrong input or wrong number format
    	if(n<=0 | row<0 |row>=n){
			throw new NumberFormatException();	
		}
		String numbers="";
		//loop for numbering
		for(int i=0;i<(n-row);i++){
			numbers=numbers+(i+1)+" ";		}
		return numbers;
	}
    /**
     * Call both number and space method and concatenate both and return array of string .
     * @param n  describes size of pyramid
     * @return
     */
	public String[] numberPyramid(int n){
		//throws exception if wrong input or wrong number format
		if(n<=0){
			throw new NumberFormatException();
		}
	    
		String[] pyramid=new String[n];
		
	    for(int i=0;i<n;i++){
			//concatenate both number and space for each row
			pyramid[i]=getSpace(i,n)+getNumber(i,n)+"\n";
			System.out.print(pyramid[i]);
	    }
		
	    return pyramid;//return array of string
	}
}