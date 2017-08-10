package assignment3;
import java.util.Scanner;

import assignment2.BinarySearch;
import assignment2.BinarySearchMain;

/**
 * Class Name : QuickSortMain
 * @author    : Vaishali Jain
 * Description : Main Class
 */

public class QuickSortMain {
	int array[];
    int lengthOfArray;
    void getInputFromUser(){
		  //length of array
		 System.out.println("Enter Length of array");
		 Scanner sc=new Scanner(System.in);
		 lengthOfArray=sc.nextInt();
		 array =new int[lengthOfArray];
		 //array
		 System.out.println("Enter Array in Sorted Order");
		 for(int i=0;i<lengthOfArray;i++){
			 array[i]=sc.nextInt();
		 }
	}
	public static void main(String args[]){
		QuickSortMain mainObject=new QuickSortMain();
		QuickSort sortedArray=new QuickSort();
		mainObject.getInputFromUser();
		sortedArray.quickSort(mainObject.array);
		for(int i =0; i< mainObject.lengthOfArray;i++)
		System.out.println();
		QuickSortTestRunner runner=new QuickSortTestRunner();
	    runner.testRunner();
	}
}
