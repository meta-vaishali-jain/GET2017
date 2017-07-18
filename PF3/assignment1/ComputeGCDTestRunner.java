package assignment1;
/**
 * class=ComputeGCDTestRunner
 * For executing all the test cases
 */
import org.junit.runner.*;
import org.junit.runner.notification.Failure;

public class ComputeGCDTestRunner {
	public  void TestRunner() {
		Result result = JUnitCore.runClasses(TestComputeGCD.class);

	    for(Failure failure : result.getFailures()) {
	    	System.out.println(failure.toString());
	    }
			
	    System.out.println(result.wasSuccessful());
	   }
	} 