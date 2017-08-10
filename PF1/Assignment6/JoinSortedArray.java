package assignment6;
/*This is the program to join two sorted array into a third sorted array.In this program 
 * I assume that either the two sorted arrays are in ascending order or are n descending order and 
 * returned array is in same order as in input array.
 */
public class JoinSortedArray {
	int[] join(int a[], int asize, int b[], int bsize, int c[]){
		int i=0,j=0,k=0;
		// to check array is ascending sorted or descending sorted
		if(a[0]<=a[1]){
			//code if array is in ascending sort
			//sort the array by checking one one element of both array 
		 while(i<asize && j<bsize){
			if(a[i]<= b[j]){
	            c[k++] = a[i++];
	        }
	        else{
	            c[k++] = b[j++];
	        } 
		  }
		//if length of 'b' array is less than length of 'a' array
		   while(i < a.length){
		    c[k++] = a[i++];
		    }
		 //if length of 'a' array is less than length of 'b' array
        while (j < b.length){
		    c[k++] = b[j++];
		    }
		}
		else{
			//code if array is in descending sort
			while(i<asize && j<bsize){
				if(a[i] >=b[j]){
		            c[k++] = a[i++];
		        }
		        else{
		            c[k++] = b[j++];
		        }   
			}
			//if length of 'b' array is less than length of 'a' array
			 while(i < a.length){
			        c[k++] = a[i++];
			       
			    }
             //if length of 'a' array is less than length of 'b' array
			 while (j < b.length){
			        c[k++] = b[j++];
			       
			    }
		    }
		  return c;	
	  }
	
	

}

