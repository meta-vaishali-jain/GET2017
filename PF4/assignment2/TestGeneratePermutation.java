
package assignment2;

import static org.junit.Assert.assertEquals;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
/**
 * ClassName TestgeneratePermutations
 * testcases for testing generatePermutationss
 * test cases include checks for base condition, boundary values values or central range inputs.
 */
public class TestGeneratePermutation{
	GeneratePermutation permutationObject;

	// instantiate an permutationObjectect
	@Before
	public void start() {
		permutationObject= new GeneratePermutation();
	}

	// testcase when input string has different letters
	@Test
	public void testStringWithDifferentLetters() {
		List<String> output = new ArrayList<String>();
		List<String> expected = new ArrayList<String>();
		output = permutationObject.generatePermutations("ABC");
		expected.add("ABC");
		expected.add("ACB");
		expected.add("BAC");
		expected.add("BCA");
		expected.add("CBA");
		expected.add("CAB");
		assertEquals(expected, output);

	}
	
	@Test
	public void testStringWithFourLetters() {
		List<String> output = new ArrayList<String>();
		List<String> expected = new ArrayList<String>();
		output = permutationObject.generatePermutations("ABCD");
		expected.add("ABCD");
		expected.add("ABDC");
		expected.add("ACBD");
		expected.add("ACDB");
		expected.add("ADCB");
		expected.add("ADBC");
		expected.add("BACD");
		expected.add("BADC");
		expected.add("BCAD");
		expected.add("BCDA");
		expected.add("BDCA");
		expected.add("BDAC");
		expected.add("CBAD");
		expected.add("CBDA");
		expected.add("CABD");
		expected.add("CADB");
		expected.add("CDAB");
		expected.add("CDBA");
		expected.add("DBCA");
		expected.add("DBAC");
		expected.add("DCBA");
		expected.add("DCAB");
		expected.add("DACB");
		expected.add("DABC");	
		assertEquals(expected, output);

	}

	// testcase when input string has some same letters
	@Test
	public void testStringWithSameLetters() {
		List<String> output = new ArrayList<String>();
		List<String> expected = new ArrayList<String>();
		output = permutationObject.generatePermutations("AAC");
		expected.add("AAC");
		expected.add("ACA");
		expected.add("CAA");
		assertEquals(expected, output);

	}

	// testcase when input string has one letter
	@Test
	public void testStringWithSingleLetter() {
		List<String> output = new ArrayList<String>();
		List<String> expected = new ArrayList<String>();
		output = permutationObject.generatePermutations("A");
		expected.add("A");
		assertEquals(expected, output);

	}

	// testcase when input string has some same letters
	@Test(expected= NullPointerException.class)
	public void testNullString() {
		List<String> output = new ArrayList<String>();
		List<String> expected = new ArrayList<String>();
		 permutationObject.generatePermutations(null);
		

	}

}
