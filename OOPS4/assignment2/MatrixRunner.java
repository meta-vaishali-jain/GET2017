package assignment2;
/**
 * class=MatrixRunner
 * For executing all the test cases
 */
import org.junit.runner.*;
import org.junit.runner.notification.Failure;

public class MatrixRunner {
	public static void main(String args[]) {
		Result result = JUnitCore.runClasses(TestMatrix.class);

	    for(Failure failure : result.getFailures()) {
	    	System.out.println(failure.toString());
	    }
			
	    System.out.println(result.wasSuccessful());
	   }
	} 