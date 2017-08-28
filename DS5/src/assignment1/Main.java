package assignment1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * ClassName :  Main
 * @author   :  Vaishali Jain
 * Description: Controller class of the project
 */
public class Main {
	//input from command line
	public static void main(String args[]){
		Concordance concordance=new Concordance();
		String inputString = "";
		for(int index =0; index < args.length; index++) {
			inputString += args[index];
			}
		concordance.concordanceOfString(inputString);
		HashMap<Character,ArrayList<Integer>> concordantCharacters=concordance.getConcordantCharacters();
		
		//print the hash map containing all character positions
		System.out.print("{");
		for(Map.Entry<Character,ArrayList<Integer>> item : concordantCharacters.entrySet()){
			System.out.print(item.getKey() +"="+item.getValue().toString());
			}
		System.out.print("}");
		}	
	}
