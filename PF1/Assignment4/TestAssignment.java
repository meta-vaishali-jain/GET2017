package assignment4;
import org.junit.*;

public class TestAssignment {
	ProcessScheduling process;
	
	@Before
	public void setUp(){
		process = new ProcessScheduling();
	}
	
	@Test
	public void testGiven(){
		int[] arrival_time= {1,5,9,25};
		int[] job_size    = {12,7,2,5};
		
		int[][] expected = {{1, 1, 0, 1, 12}, 
							{2, 5, 8, 13, 19},
							{3, 9, 11, 20, 21},
							{4, 25, 0, 25, 29}
							};
				
		int[][] actual = process.FCFS(arrival_time, job_size);
		System.out.println("Job\tArrival Time\tWait Time\tStart at\tFinish Time");
		for(int row=0; row< actual.length; row++){
			for(int column=0; column<5; column++){
				System.out.print(actual[row][column]+ "\t\t");
			}
			System.out.println();
		}
		Assert.assertFalse(process.isArrayEqual(expected, actual));
	}

	@Test
	public void testInitialWait(){
		int[] arrival_time= {0, 1, 5, 9, 25};
		int[] job_size    = {4, 12,7,2,5};
		
		int[][] expected = {{1, 0, 1, 1, 4},
							{2, 1, 2, 5, 16}, 
							{3, 5, 11, 17, 23},
							{4, 9, 16, 24, 26},
							{5, 25, 1, 27, 31}
							};		
		
		int[][] actual = process.FCFS(arrival_time, job_size);
		System.out.println("Job\tArrival Time\tWait Time\tStart at\tFinish Time");
		for(int row=0; row< actual.length; row++){
			for(int column=0; column<5; column++){
				System.out.print(actual[row][column]+ "\t\t");
			}
			System.out.println();
		}
		Assert.assertFalse(process.isArrayEqual(expected, actual));
	}
	
	@Test
	public void testSameArrival(){
		int[] arrival_time= {2, 5, 5};
		int[] job_size    = {1, 12, 7};
		
		int[][] expected = {{1, 2, 0, 2, 2},
							{2, 5, 0, 5, 17},
							{3, 5, 12, 28, 25},
							};
		
		int[][] actual = process.FCFS(arrival_time, job_size);
		System.out.println("Job\tArrival Time\tWait Time\tStart at\tFinish Time");
		for(int row=0; row< actual.length; row++){
			for(int column=0; column<5; column++){
				System.out.print(actual[row][column]+ "\t\t");
			}
			System.out.println();
		}
		Assert.assertFalse(process.isArrayEqual(expected, actual));
	}
}
