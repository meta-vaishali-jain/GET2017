package assignment4;

//Process scheduling using First Come First Serve(FCFS)
public class ProcessScheduling {
	public boolean isArrayEqual(int[][] expected, int[][] actual){
		boolean flag= true;
				
		for(int row=0; row< actual.length; row++){
			for(int column=0; column< actual[0].length; column++){
				if(actual[row][column] == expected[row][column]){
					flag= false;
					break;
				}
			}
		}
		return flag;
	}
	 
	public int[][] FCFS( int arrival_time[], int job_size[] ) 
	{

	int i,j,start_time=1;
	 int result_array[][]=new int[arrival_time.length][5];
	 
	 for(i=0,j=0;i<arrival_time.length;i++)
	 {
		 result_array[i][j]=i+1;
	 }
	 /*
	 for(i=0,j=1;j<arrival_time.length;i++)
	 {
		 result_array[i][j]=arrival_time[i];
	 }
	 result_array[0][3]=arrival_time[0];
	 result_array[0][4]=arrival_time[1];
	 for(i=1,j=3;i<arrival_time.length;i++)
	 {
		 result_array[i][j]=
	 }
		*/
	 
	 result_array[0][1]=arrival_time[0];
	 result_array[0][2]=start_time-arrival_time[0];
	 result_array[0][3]=arrival_time[0];
	 result_array[0][4]=job_size[0]+result_array[0][3]-1;
	 
	 
	
		for(i=1;i< arrival_time.length ;i++)
		{
			
				
				if(result_array[i-1][4]<arrival_time[i])
				{
					result_array[i][1]=arrival_time[i];
					result_array[i][3]=arrival_time[i];
					result_array[i][2]=0;
					result_array[i][4]=job_size[i]+result_array[i][3]-1;
				}
				else
					
				{
					result_array[i][1]=arrival_time[i];
					result_array[i][3]=result_array[i-1][4]+1;
					result_array[i][4]=job_size[i]+result_array[i][3]-1;
					result_array[i][2]=result_array[i][3]-result_array[i][1];
				}
				
		}
			return result_array;	
			}
}
	
	/**
	public int[][] FCFS( int arrival_time[], int job_size[] ){
		int[][] result_array=new int[arrival_time.length][5];
	 
		//Process ID
		for(int i=0,j=0; i<arrival_time.length; i++){
			result_array[i][j]=i+1;
		}
	 
		//Input values
		result_array[0][1]= arrival_time[0];
		result_array[0][2]= 0;
		result_array[0][3]= arrival_time[0];
		result_array[0][4]= job_size[0]+result_array[0][3]-1;
	
		//Job Finished at time
		for(int i=1; i< arrival_time.length; i++){
			if(result_array[i-1][4]< arrival_time[i]){
				result_array[i][1]= arrival_time[i];
				result_array[i][3]= arrival_time[i];
				result_array[i][2]= 0;
				result_array[i][4]= job_size[i]+result_array[i][3]-1;
			}
			else{
				result_array[i][1]= arrival_time[i];
				result_array[i][3]= result_array[i-1][4]+1;
				result_array[i][4]= job_size[i]+result_array[i][3]-1;
				result_array[i][2]= result_array[i][3]-result_array[i][1];
			}	
		}
		return result_array;	
	}
}


	public static void main(String args[])
	{
		ProcessScheduling ps=new ProcessScheduling();
		int arrival_time[]= {1,5,9,25};
		int job_size[]= {12,7,2,5};
		int result_array[][]=ps.FCFS(arrival_time, job_size);
		System.out.println("Job\tArrival Time\tWait Time\tStart at\tFinish Time");
		for(int i=0;i<arrival_time.length;i++)
		{
			for(int j=0;j<5;j++)
			{
				System.out.print(result_array[i][j]+ "\t");
			}
			System.out.println();
		}
		
		
	}
		
		 
	 }
**/

