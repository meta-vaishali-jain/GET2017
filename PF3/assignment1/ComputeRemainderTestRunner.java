package assignment1;
/**
 * class=ComputeRemainderTestRunner
 * For executing all the test cases
 */
import org.junit.runner.*;
import org.junit.runner.notification.Failure;

public class ComputeRemainderTestRunner {
	public  void TestRunner() {
		Result result = JUnitCore.runClasses(TestComputeRemainder.class);

	    for(Failure failure : result.getFailures()) {
	    	System.out.println(failure.toString());
	    }
			
	    System.out.println(result.wasSuccessful());
	   }
	} 