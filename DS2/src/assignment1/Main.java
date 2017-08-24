package assignment1;


public class Main {
	
	public static void main(String args[]){
		NewInfixToPostFixConversion infixToPostFixConversion=new NewInfixToPostFixConversion();
		String postFixString;
		//postFixString=infixToPostFixConversion.infixToPostFixConversion("(f+g*h)^(gh)-i");
		//postFixString=infixToPostFixConversion.infixToPostFixConversion("(a+b*c^d-e)^(f+g*h)-i");
		//postFixString=infixToPostFixConversion.infixToPostFixConversion("(a+b*c^d-e)^(f+g*h)-i");
		postFixString=infixToPostFixConversion.infixToPostFixConversion("a+b*c^d-e)^(f+g*h)-i");
		System.out.println(postFixString);
	}
	
}
