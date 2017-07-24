package assignment1;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/**
 * Class Name : TowerOfHanoiMain
 * @author    : Vaishali Jain
 * Description : Main Class
 */
public class TowerOfHanoiMain {
	int numberOfDisk;
	void getInputFromUser(){
		System.out.println("Enter the number of disk to transfer");
		Scanner sc=new Scanner(System.in);
		numberOfDisk=sc.nextInt();
	}
	public static void main(String args[]){
		TowerOfHanoiMain mainObject=new TowerOfHanoiMain();
		TowerOfHanoi moveDisk=new TowerOfHanoi();
		TowerOfHanoiRunner runner=new TowerOfHanoiRunner();
		mainObject.getInputFromUser();
		List<String> resultMoves = new ArrayList<String>();
		resultMoves = moveDisk.utilTowerOfHanoi("A", "B", "C", mainObject.numberOfDisk);
		for(int i=0; i< resultMoves.size(); i++){
			System.out.println(resultMoves.get(i));
		}
		//calling test runner class
		runner.TestRunner();
	}
}