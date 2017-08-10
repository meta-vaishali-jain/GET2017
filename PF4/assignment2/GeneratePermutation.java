package assignment2;
 import java.util.ArrayList; 
 import java.util.List; 
 
 
 /** 
  * class take an input string and return the all possible permutation  
  * that can be made using the string characters. 
  * Class Name : GeneratePermutation
  * @author Vaishali Jain 
  *  
  */ 
 public class GeneratePermutation { 
             List<String> possiblePermutations = new ArrayList<String>(); 
     /**
 	 * Method take a input String , starting index of input array and second index and swapCharacterOfString the value of
 	 * indexes
 	 * @param inputString   
 	 * @param firstIndex    starting Index
 	 * @param secondIndex 
 	 * @return String after swapCharacterOfStringping 
 	 */ 
	 String swapCharacterOfString(String inputString, int firstIndex, int secondIndex) { 
 		char[] characterArray = inputString.toCharArray(); 
 		char temp = characterArray[firstIndex]; 
		characterArray[firstIndex] = characterArray[secondIndex]; 
 		characterArray[secondIndex] = temp; 
 		return String.valueOf(characterArray); 
 	} 
     /** 
 	 * Method Generates all possible permutation of input String 
 	 * @param inputString 
 	 * @param lowIndex 
 	 * @param highIndex 
 	 * @return ArrayList<String> 
 	 * 
 	 */ 
 	private List<String> generatePermutations(String inputString, int lowIndex, int highIndex) { 
 		if (lowIndex == highIndex) { 
 			if (!possiblePermutations.contains(inputString)) { 
 				possiblePermutations.add(inputString); 
 			} 
 		} else { 
 			for (int iterateIndex = lowIndex; iterateIndex <= highIndex; iterateIndex++) { 
 				inputString = swapCharacterOfString(inputString, iterateIndex, lowIndex); 
 				generatePermutations(inputString, lowIndex + 1, highIndex); 
 				inputString = swapCharacterOfString(inputString, iterateIndex, lowIndex); 
 			} 
 		} 
 		return possiblePermutations; 
 	} 
 	//method overloading 
 	public List<String> generatePermutations(String inputString) { 
 		if(inputString.length()==0){
 			throw new NullPointerException();
 		}
 		int lowIndex = 0; 
 		int highIndex = inputString.length() - 1;  
 		return generatePermutations(inputString, lowIndex, highIndex); 
 	} 

 } 
