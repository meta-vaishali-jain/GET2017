package assignment2;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/**
 * Class Name : GeneratePermutationMain
 * @author    : Vaishali Jain
 * Description : Main Class
 */
public class GeneratePermutationMain {
	String inputString;
	void getInputFromUser(){
		System.out.println("Enter the string to find permutation");
		Scanner sc=new Scanner(System.in);
		inputString=sc.next();
	}
	public static void main(String args[]){
		GeneratePermutationMain mainObject=new GeneratePermutationMain();
		GeneratePermutation permutations=new GeneratePermutation();
		GeneratePermutationRunner runner=new GeneratePermutationRunner();
		mainObject.getInputFromUser();
		List<String> stringPermutations = new ArrayList<String>();
		stringPermutations =permutations.generatePermutation(mainObject.inputString);
		for(int i=0; i< stringPermutations.size(); i++){
			System.out.println(stringPermutations.get(i));
		}
		//calling test runner class
		runner.TestRunner();
	}
}