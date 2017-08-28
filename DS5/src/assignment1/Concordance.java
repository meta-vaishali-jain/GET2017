package assignment1;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * ClassName  : Concordance
 * @author    : Vaishali Jain
 * Description: class create a concordance of characters occurring in a string (i.e which characters occur where in a string)
 */
public class Concordance {
	private HashMap<Character,ArrayList<Integer>> concordantCharacters ;
	
	//default constructor
	public Concordance(){
		concordantCharacters=new HashMap<Character,ArrayList<Integer>>();
	}
	
	//getter to get hash map value 
	public HashMap<Character, ArrayList<Integer>> getConcordantCharacters() {
		return concordantCharacters;
	}
    
	//setter to set hash map value
	public void setConcordantCharacters(HashMap<Character, ArrayList<Integer>> concordantCharacters) {
		this.concordantCharacters = concordantCharacters;
	}

    /**
     * method to find which character occurs where in the string and update their position in the hashmap
     * @param inputString
     */
	public void concordanceOfString(String inputString){
		//to remove space from string
		String updatedString = inputString.replaceAll("\\s","");
		for(int i=0;i<updatedString.length();i++){
			if(concordantCharacters.containsKey(updatedString.charAt(i))){
				concordantCharacters.get(updatedString.charAt(i)).add(i);
			}else{
				ArrayList<Integer> position =new ArrayList<Integer>();
				position.add(i);
				concordantCharacters.put(updatedString.charAt(i),position);
			}
		}
		
	}
}
