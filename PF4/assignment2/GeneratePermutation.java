package assignment2;

import java.util.*;
/**
 * ClassName GeneratePermutation
 * @author Vaishali Jain
 * Generates number of permutations of any string
 */
public class GeneratePermutation {
	private List<String> stringPermutations;
	/**
	 * Generate permutations of string and return string list
	 * @param inputString  input string to find permutation
	 * @return
	 */
	public List<String> generatePermutation (String inputString){	
		stringPermutations = new ArrayList<String>();
		//initially empty permutation string
		generatePermutation("", inputString);
	    /*
	     * First converting List into hash set to remove duplicate permutation and then again converting it into list
	     */
		stringPermutations = new ArrayList<String>(new LinkedHashSet<String>(stringPermutations));
		
		return stringPermutations;
	}

	private void generatePermutation(String prefix, String inputString) {
		if (inputString == null) {
			throw new IllegalArgumentException();
		}
		if (inputString.length() == 0) {
			stringPermutations.add(prefix);
		}
		else {
			    // i is only looping variable to iterate complete string
			    for (int i = 0; i < inputString.length() ; i++){
				//it will fix the i character of string and then call the same function for all other character string by converting into string
				generatePermutation(prefix + inputString.charAt(i), inputString.substring(0, i) + inputString.substring(i+1, inputString.length()));
				}
			}
		}
    }
