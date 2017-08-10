package assignment2;
/**
 * class=LinearSearchTestRunner
 * For executing all the test cases
 */
import org.junit.runner.*;
import org.junit.runner.notification.Failure;

public class LinearSearchTestRunner {
	public  void TestRunner() {
		Result result = JUnitCore.runClasses(TestLinearSearch.class);

	    for(Failure failure : result.getFailures()) {
	    	System.out.println(failure.toString());
	    }
			
	    System.out.println(result.wasSuccessful());
	   }
	} 