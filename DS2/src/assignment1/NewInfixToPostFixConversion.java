package assignment1;
import java.util.Arrays;
import java.util.HashSet;
import arrayList.DisplayOutput;

/**
 * ClassName  : NewInfixToPostFixConversion
 * @author 	  : Vaishali Jain
 * Description: class to convert infix expression to postfix expression
 */
public class NewInfixToPostFixConversion {
	
	/**
	 * method to get the operator precedenc
	 * @param operator
	 * @return larger number for operator with high precedence
	 */
	public static int getOperatorPrecedence(char operator){
		switch(operator){
		case '+':
		case '-':
			return 4;
		case '*':
		case '/':
		case '%':
			return 5;
		case '&':
			return 3;
		case '|':
			return 1;
		case '^':
			return 6;
		}
		return 0;
	}
	
	/**
	 * method to convert infix expression to postfix expression based on the operator precedence
	 * @param infixString
	 * @return
	 */
	public static<T> String infixToPostFixConversion(String infixString){
		if(infixString==null){
			return null;
		}
		String postFixString="";
		char poppedElement;
		//stack to store operators
		UserDefinedStack<Character> stack=new UserDefinedStack<Character>();
		//hash set containing all the operators that can arrive in string
		HashSet<Character> match = new HashSet<Character>(Arrays.asList('+','-','*','/','%','&','|','^'));
		Character indexedCharacter;
		//iterating the infix string
		for(int i=0;i<infixString.length();i++){
			//getting character from string one by one
			indexedCharacter=infixString.charAt(i);
			//if character encounters is '(' than push that to stack
			if(indexedCharacter=='('){
				stack.push(indexedCharacter);
			//if character encounterd is ')' than pop the stack till stack goes empty or '(' arrived
			}else if(indexedCharacter==')'){
				while((stack.getStackSize()!=0 && stack.peek()!='(')){
					postFixString+=stack.pop();
				}
				if(stack.getStackSize()==0){
					DisplayOutput.messageHandler("wrong parenthisis-matching");
					postFixString="";
					return null;
				}else{
					stack.pop();
				}
			//if character encounterd with operator than if encountered character has precedence less than stack top most character 
			//than pop the operator from stack otherwise push the encounterd character in stack
			}else if(match.contains(indexedCharacter)){
				while(stack.getStackSize()!=0 && stack.peek()!='('&& getOperatorPrecedence(indexedCharacter)<=getOperatorPrecedence(stack.peek())){
					postFixString+=stack.pop();
				}
				stack.push(indexedCharacter);	
			}else{
				postFixString+=indexedCharacter;
			}
		}
		//popped the stack while its size is not equals 0
			while(stack.getStackSize()!=0){
				poppedElement=stack.pop();
				if(poppedElement=='('||poppedElement==')'){
					DisplayOutput.messageHandler("wrong parenthisis matching");
					postFixString="";
					return null;
				}else{
					postFixString+=poppedElement;
				}
			}
			//return postfix string
			return postFixString;
	}
}
