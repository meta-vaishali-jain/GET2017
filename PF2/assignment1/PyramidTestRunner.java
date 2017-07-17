package assignment1;
/**
 * class=PyramidTestRunner
 * For executing all the test cases
 */
import org.junit.runner.*;
import org.junit.runner.notification.Failure;

public class PyramidTestRunner {
	public  void TestRunner() {
		Result result = JUnitCore.runClasses(PyramidTestSuite.class);

	    for(Failure failure : result.getFailures()) {
	    	System.out.println(failure.toString());
	    }
			
	    System.out.println(result.wasSuccessful());
	   }
	} 
