
package assignment2;

import static org.junit.Assert.assertEquals;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
/**
 * ClassName TestGeneratePermutation
 * testcases for testing GeneratePermutations
 * test cases include checks for base condition, boundary values values or central range inputs.
 */
public class TestGeneratePermutation{
	GeneratePermutation obj;

	// instantiate an object
	@Before
	public void start() {
		obj = new GeneratePermutation();
	}

	// testcase when input string has different letters
	@Test
	public void testStringWithDifferentLetters() {
		List<String> output = new ArrayList<String>();
		List<String> expected = new ArrayList<String>();
		output = obj.generatePermutation("ABC");
		expected.add("ABC");
		expected.add("ACB");
		expected.add("BAC");
		expected.add("BCA");
		expected.add("CAB");
		expected.add("CBA");
		assertEquals(expected, output);

	}

	// testcase when input string has some same letters
	@Test
	public void testStringWithSameLetters() {
		List<String> output = new ArrayList<String>();
		List<String> expected = new ArrayList<String>();
		output = obj.generatePermutation("AAC");
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
		output = obj.generatePermutation("A");
		expected.add("A");
		assertEquals(expected, output);

	}

	// testcase when input string has some same letters
	@Test(expected= IllegalArgumentException.class)
	public void testNullString() {
		List<String> output = new ArrayList<String>();
		List<String> expected = new ArrayList<String>();
		 obj.generatePermutation(null);
		

	}

}
