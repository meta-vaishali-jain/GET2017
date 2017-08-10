package assignment2;
/**
 * class=InversePyramidTestRunner
 * For executing all the test cases
 */
import org.junit.runner.*;
import org.junit.runner.notification.Failure;

public class InversePyramidTestRunner {
	public  void TestRunner() {
		Result result = JUnitCore.runClasses(InversePyramidTestSuite.class);

	    for(Failure failure : result.getFailures()) {
	    	System.out.println(failure.toString());
	    }
	    System.out.println(result.wasSuccessful());
	   }
	} 
