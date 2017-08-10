package assignment1;
/**
 * class=ComputeLargestDigitTestRunner
 * For executing all the test cases
 */
import org.junit.runner.*;
import org.junit.runner.notification.Failure;

public class ComputeLargestDigitTestRunner {
	public  void TestRunner() {
		Result result = JUnitCore.runClasses(TestComputeLargestDigit.class);

	    for(Failure failure : result.getFailures()) {
	    	System.out.println(failure.toString());
	    }
			
	    System.out.println(result.wasSuccessful());
	   }
	} 
