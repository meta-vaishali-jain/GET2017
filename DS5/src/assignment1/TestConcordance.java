package assignment1;

import java.util.ArrayList;
import java.util.HashMap;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * ClassName : TestQueue
 * @author   : Vaishali Jain
 * Description: Test class to test Concordance class
 */
public class TestConcordance {
	Concordance concordance;
	HashMap<Character,ArrayList<Integer>> concordantCharacters;
	
	// initializing the variables.
	@Before
	public void setup(){
		concordance=new Concordance();
	}
	
	//test case to check concordance of string
	@Test
	public void testconcordanceOfString(){
		concordance.concordanceOfString("Hello World");
		concordantCharacters=concordance.getConcordantCharacters();
		Assert.assertEquals("[7]",concordantCharacters.get('r').toString());
		Assert.assertEquals("[9]",concordantCharacters.get('d').toString());
		Assert.assertEquals("[1]",concordantCharacters.get('e').toString());
		Assert.assertEquals("[5]",concordantCharacters.get('W').toString());
		Assert.assertEquals("[0]",concordantCharacters.get('H').toString());
		Assert.assertEquals("[2, 3, 8]",concordantCharacters.get('l').toString());
		Assert.assertEquals("[4, 6]",concordantCharacters.get('o').toString());	
	}
	
	//test case to check concordance of string if string is null 
	@Test
	public void testConcordanceOfNullString(){
		concordance.concordanceOfString("");
		concordantCharacters=concordance.getConcordantCharacters();
		Assert.assertEquals("{}",concordantCharacters.toString());
	}
	
	//test case to check concordance of string if string has same characters
	@Test
	public void testConcordanceOfSameCharacterString(){
		concordance.concordanceOfString("aaaaaaa");
		concordantCharacters=concordance.getConcordantCharacters();
		Assert.assertEquals("[0, 1, 2, 3, 4, 5, 6]",concordantCharacters.get('a').toString());
	}


}
