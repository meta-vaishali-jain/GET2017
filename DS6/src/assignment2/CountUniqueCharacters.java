package assignment2;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * ClassName   : CountUniqueCharacters
 * @author     : Vaishali Jain
 * Description : class has method that takes a string and returns the number of unique characters in the string. 
 */
public class CountUniqueCharacters {
	//hash map act as cache memory
	private HashMap<String,Integer> cachedString;
	
	//default constructor
	public CountUniqueCharacters(){
		cachedString = new HashMap<String, Integer>();
	}
	
	//getter to get cached memory
	public HashMap<String, Integer> getCachedString() {
		return cachedString;
	}
	
	//setter to set cache memory
	public void setCachedString(HashMap<String, Integer> cachedString) {
		this.cachedString = cachedString;
	}
	
	/**
	 * method to count unique characters in the input string
	 * @param inputString
	 * @return
	 */
	public int countUniqueCharacters(String inputString){
		//if cached string is already in memory return its corresponding count
		if(cachedString.containsKey(inputString)){
			System.out.println("Element reterived from cache " + cachedString.get(inputString));
			return cachedString.get(inputString);
		}
		//count number of unique characters in the string
		ArrayList<Character> charactersInString=new ArrayList<Character>();
		for(int i=0;i<inputString.length();i++){
			if(!charactersInString.contains(inputString.charAt(i))){
				charactersInString.add(inputString.charAt(i));
			}
		}
		//put that string in the memory with the corresponding count
		int uniqueCharacters=charactersInString.size();
		cachedString.put(inputString,uniqueCharacters);
		System.out.println("Element not reterived from cache " + uniqueCharacters);
		return uniqueCharacters;
	}
}
