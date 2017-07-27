package assignment2;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
/**
 * ClassName Main Class
 * @author   Vaishali Jain
 * Description: Main and menu Class
 */

public class Main {
	//creation of menu
	public  static Menu createMenu(){
		Menu mainMenu=new Menu();
		
		MenuItem mi=new ActionableMenuItem(new Controller());
		List<MenuItem> subMenu=mainMenu.getSubMenu();
		mi.setDisplayName("1.Enter Matrix");
		subMenu.add(mi);
        
	    mi=new ActionableMenuItem(new Controller());
		mi.setDisplayName("2.TransPose Matrix");
		subMenu.add(mi);
		
		mi=new ActionableMenuItem(new Controller());
	    mi.setDisplayName("3. Multiplication of matrix");
		subMenu.add(mi);
		
		mi=new ActionableMenuItem(new Controller());
		mi.setDisplayName("4. Update Matrix");
		subMenu.add(mi);
		
		mi=new ActionableMenuItem(new Exit());
		mi.setDisplayName("5. Exit");
		subMenu.add(mi);
		
		
		
		return mainMenu;
}

	//to display menu
public static void display(Menu menu){
		
		Iterator<MenuItem> itr=menu.getSubMenu().iterator();
		
		while(itr.hasNext()){
			System.out.println(itr.next().getDisplayName());
		}
		
		
	}

// method to enter choice
public static int getInput(){
	try{
	Scanner scan= new Scanner(System.in);
	String choice=scan.next();
    int validChoice=Integer.parseInt(choice);
	return validChoice-1;
}catch(Exception e){
	return -1;
}
	
}
//display menu  on the baseis of input choice

public static void displayAndPerformAction(Menu menu){
	
	display(menu);
	
	int choice=getInput();
	
	MenuItem menuItem= menu.getSelection(choice);

	
	if(menuItem==null){
		displayAndPerformAction(menu);
	}
	else if(menuItem instanceof ActionableMenuItem){
		
		((ActionableMenuItem)menuItem).triggerAction(choice);
		
	}
	else{
		displayAndPerformAction((Menu)menuItem);
	}
}

public static void main(String args[]){
	Menu menu=createMenu();
	
	while(true){
	displayAndPerformAction(menu);
	}
	
	
}
	
}