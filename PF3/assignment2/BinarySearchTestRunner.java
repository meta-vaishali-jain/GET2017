package assignment2;
/**
 * class=ComputeGCDTestRunner
 * For executing all the test cases
 */
import org.junit.runner.*;
import org.junit.runner.notification.Failure;

public class BinarySearchTestRunner {
	public  void TestRunner() {
		Result result = JUnitCore.runClasses(TestBinarySearch.class);

	    for(Failure failure : result.getFailures()) {
	    	System.out.println(failure.toString());
	    }
			
	    System.out.println(result.wasSuccessful());
	   }
	} 