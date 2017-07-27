package assignment1;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;


public class Main {
	//method to create menu
	public  static Menu createMenu(){
		Menu mainMenu=new Menu();
		
		MenuItem mi=new ActionableMenuItem(new ProductDetails());
		List<MenuItem> subMenu=mainMenu.getSubMenu();
		mi.setDisplayName("1.Display Product List");
		subMenu.add(mi);
      
        mi=new Menu();
		mi.setDisplayName("2.Display Promotion List");
		subMenu.add(mi);
		
	    List<MenuItem> subPromoMenu=((Menu)mi).getSubMenu();
	    mi=new ActionableMenuItem(new ProductPromo());
	    mi.setDisplayName("1. Product Promotion");
		subPromoMenu.add(mi);
		
		mi=new ActionableMenuItem(new OrderPromo());
		mi.setDisplayName("2. Order Promotion");
		subPromoMenu.add(mi);
		
		mi=new ActionableMenuItem(new OrderCalculation());
		mi.setDisplayName("3.Order");
		subMenu.add(mi);
		
		mi=new ActionableMenuItem(new Exit());
		mi.setDisplayName("4.Exit");
		subMenu.add(mi);
		
		return mainMenu;
}

	//display menu
public static void display(Menu menu){
		
		Iterator<MenuItem> itr=menu.getSubMenu().iterator();
		
		while(itr.hasNext()){
			System.out.println(itr.next().getDisplayName());
		}
		
		
	}
//to get input i.e. user choice

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

//to display menu and call trigger function
public static void displayAndPerformAction(Menu menu){
	
	display(menu);
	
	int choice=getInput();
	
	MenuItem menuItem= menu.getSelection(choice);

	
	if(menuItem==null){
		displayAndPerformAction(menu);
	}
	else if(menuItem instanceof ActionableMenuItem){
		
		((ActionableMenuItem)menuItem).triggerAction();
		
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