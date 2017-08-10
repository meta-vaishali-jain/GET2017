package assignment5;

/* 0: unsorted
 * 1: ascending sorted
 * 2: descending sorted
 * */
public class CheckArray {	
	public int checkSortArray(int[] a){
		int type_of_sort =0;
			
		/*check for ascending */
		int i=0;
		for(i=0; i< a.length-1 ; i++){
			if(a[i] > a[i+1]){
				break;
			}
		}
			
		/* => is in ascending order*/
		if(i == a.length -1){
			type_of_sort = 1;
			return type_of_sort;
		}
			
		/*descending check */
		for(i=0; i< a.length -1; i++){
			if(a[i] < a[i+1])
				break;
		}
		
		/* => is descending sorted*/
		if(i == a.length- 1){
			type_of_sort = 2;
			return type_of_sort;	 
		}
		
		type_of_sort = 0;
		return type_of_sort;
	}
}
