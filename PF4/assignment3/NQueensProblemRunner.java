package assignment3;
/**
 * class=NQueensProblemRunner
 * For executing all the test cases
 */
import org.junit.runner.*;
import org.junit.runner.notification.Failure;

public class NQueensProblemRunner {
	public  void TestRunner() {
		Result result = JUnitCore.runClasses(TestNQueensProblem.class);

	    for(Failure failure : result.getFailures()) {
	    	System.out.println(failure.toString());
	    }
			
	    System.out.println(result.wasSuccessful());
	   }
	} 