package assignment1;
/**
 * class=TowerOfHanoiRunner
 * For executing all the test cases
 */
import org.junit.runner.*;
import org.junit.runner.notification.Failure;

public class TowerOfHanoiRunner {
	public  void TestRunner() {
		Result result = JUnitCore.runClasses(TestTowerOfHanoi.class);

	    for(Failure failure : result.getFailures()) {
	    	System.out.println(failure.toString());
	    }
			
	    System.out.println(result.wasSuccessful());
	   }
	} 