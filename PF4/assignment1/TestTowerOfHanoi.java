package assignment1;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
/**
 * Class Name : TestTowerOfHanoi
 * @author    : Vaishali Jain
 * Description : Describes Test cases for TowerOfHanoi class
 */

public class TestTowerOfHanoi {
	TowerOfHanoi diskMoves;
	@Before
	public void setup(){
		diskMoves=new TowerOfHanoi();
	}
	//Test case when valid number is given
	@Test
	public void testForAnyNumber(){
		TowerOfHanoi resultMoves=new TowerOfHanoi();
		List<String> expectedMoves=new ArrayList<String>();
		List<String> resultantMoves=new ArrayList<String>();
		expectedMoves.add("Move Disk 1 from A to B");
		expectedMoves.add("Move Disk 2 from A to C");
		expectedMoves.add("Move Disk 1 from B to C");
		expectedMoves.add("Move Disk 3 from A to B");
		expectedMoves.add("Move Disk 1 from C to C");
		expectedMoves.add("Move Disk 2 from C to B");
		expectedMoves.add("Move Disk 1 from C to B");
		Assert.assertEquals(expectedMoves, resultMoves.towerOfHanoi("A", "B", "C", 3));
	}
	//Test Case when Number Of Disk is One
	@Test
	public void testForOneDisk(){
		TowerOfHanoi resultMoves=new TowerOfHanoi();
		List<String> expectedMoves=new ArrayList<String>();
		List<String> resultantMoves=new ArrayList<String>();
		expectedMoves.add("Move Disk 1 from A to B");
		Assert.assertEquals(expectedMoves, resultMoves.towerOfHanoi("A", "B", "C", 1));
	}
	//Test case when number of disk is zero
	@Test(expected=IllegalArgumentException.class)
	public void TestForZeroDisk(){
		TowerOfHanoi resultMoves=new TowerOfHanoi();
		resultMoves.towerOfHanoi("A", "B", "C", 0);	
	}
	//Test case when number of disk is negative
	@Test(expected=IllegalArgumentException.class)
	public void TestForNegativeDisk(){
		TowerOfHanoi resultMoves=new TowerOfHanoi();
		resultMoves.towerOfHanoi("A", "B", "C", -1);	
	}
}
