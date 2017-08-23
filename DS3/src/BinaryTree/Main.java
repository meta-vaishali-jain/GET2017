package BinaryTree;

import java.util.Scanner;

public class Main {
	
	/**
	 * method to perform if choice enterd by user is valid or not
	 * @param choice
	 * @param limit describes limit of the choice i.e 1-limit
	 * @return
	 */
	public static boolean isValidChoice(String choice,int limit){
		try{
			int parsedChoice=Integer.parseInt(choice);
			if(parsedChoice<0||parsedChoice>limit){
				return false;
			}
			return true;
		}catch(Exception errorHandler){
			return false;
		}
	}
	
	/**
	 * method to display menu
	 */
	public static void menu(){
		System.out.println("Enter function to perform what you want to do");
		System.out.println("1 Insert : insert()");
		System.out.println("1 Inorder : inorder()");
		System.out.println("2 PostOrder : postOrder()");
		System.out.println("3 PreOrder : preOrder()");
		System.out.println("4 to find mirror or not:isMirrorImage()");
		System.out.println("5 return()");
	}
	
	public static void main(String args[]){
		Scanner scanner=new Scanner(System.in);
		BinaryTree<String> binaryTree1=new BinaryTree<String>();
		BinaryTree<String> binaryTree2=new BinaryTree<String>();
//		binaryTree1.insert("10");
//		System.out.println("Element inserted");
//		binaryTree1.insert("20");
//		System.out.println("Element inserted");
//		binaryTree1.insert("30");
//		System.out.println("Element inserted");
//		binaryTree1.insert("40");
//		System.out.println("Element inserted");
//		binaryTree1.insert("50");
//		System.out.println("Element inserted");
//		binaryTree1.insert("60");
//		System.out.println("Element inserted");
//		binaryTree1.insert("70");
//		System.out.println("Element inserted");
//		binaryTree2.insert("10");
//		System.out.println("Element inserted");
//		binaryTree2.insert("20");
//		System.out.println("Element inserted");
//		binaryTree2.insert("30");
//		System.out.println("Element inserted");
//		binaryTree2.insert("40");
//		System.out.println("Element inserted");
//		binaryTree2.insert("50");
//		System.out.println("Element inserted");
//		binaryTree2.insert("60");
//		System.out.println("Element inserted");
//		binaryTree2.insert("70");
//		System.out.println("Element inserted");
		while(true){
			//callig methods on the basis of string input
			menu();
			String function=scanner.next();
			if(function.equals("inorder()")){
				binaryTree1.inorder();
			}else if(function.equals("postOrder()")){
				binaryTree1.postOrder();
			}else if(function.equals("preOrder()")){
				binaryTree1.postOrder();
			}else if(function.equals("isMirrorImage()")){
				if(binaryTree1.isMirror(binaryTree1.getRoot(),binaryTree2.getRoot())){
					System.out.println("Mirror image");
				}else{
					System.out.println("Not a mirror image");
				}
			}else if(function.equals("return()")){
				return;
			}else if(function.equals("insert()")){
				String data=scanner.next();
				binaryTree1.insert(data);
			}
			else{
				System.out.println("Please enter input in correct format");
			}	
		}
		
	}
}

