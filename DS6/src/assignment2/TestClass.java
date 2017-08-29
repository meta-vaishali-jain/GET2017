package assignment2;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * ClassName : TestClass
 * @author   : Vaishali Jain
 * Description: Test class of the Count Unique Characters class
 */
public class TestClass {
	CountUniqueCharacters counttUniqueCharacters;
	
	@Before
	public void setup(){
		counttUniqueCharacters=new CountUniqueCharacters();
	}
	
	//test method to test normal string
	@Test
	public void testCountCharacters(){
		Assert.assertEquals(3,counttUniqueCharacters.countUniqueCharacters("naina"));
	}
	
	//test case to test if string has same characters
	@Test
	public void testIFStringHasSameCharacters(){
		Assert.assertEquals(1,counttUniqueCharacters.countUniqueCharacters("aaaaa"));
	}
    
	//test case is string has all different characters
	@Test
	public void testIfStringHasDifferentCharacters(){
		Assert.assertEquals(6,counttUniqueCharacters.countUniqueCharacters("abcdef"));
	}
	
	//test case if string null
	@Test
	public void testIfStringNull(){
		Assert.assertEquals(0,counttUniqueCharacters.countUniqueCharacters(""));
	}
}
