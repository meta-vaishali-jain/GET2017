package assignment2;
// Program to remove duplicate element from array by assigning max value to duplicate elements
public class RemoveDuplicate {
	 int[] removeDuplicate(int input[])
	 {
		 int max=Integer.MAX_VALUE ;
		
	   // assigning max value of integer to duplicate element in array
	   for(int i=0;i<input.length;i++){
		 for(int j=i+1;j<input.length;j++)
		 {
			 if(input[i]==input[j]){
				input[j]=max; 
			 }
		 }
	   } 
	 //dup_array to store array values other than max value	 
	  int dup_array[]=new int[input.length];
	  int j=0;
	  for(int i=0; i<input.length; i++)
	  {
		 if(input[i]!=max)
		 {
			 dup_array[j++]=input[i];
		 }
	  }
	  
	  // result to remove 0 from end
	 int[] result = new int[j];
	 for(int i=0; i<j; i++)
		 result[i] = dup_array[i];
	 return result;
	 }
}
