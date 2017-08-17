package view;

import java.util.ArrayList;

public class Menu {

	private static ArrayList<MenuItem> menu = new ArrayList<MenuItem>();
	
	//create menu to be displayed
	public static void createMenu(){
		menu.add(new MenuItem(1, "View product list"));
		menu.add(new MenuItem(2, "Add product to cart"));
		menu.add(new MenuItem(3, "Delete product from cart"));
		menu.add(new MenuItem(4, "Update product in cart"));
		menu.add(new MenuItem(5, "View your Cart"));
		menu.add(new MenuItem(6, "Generate Bill"));
		menu.add(new MenuItem(7, "Exit"));
	}
	
	public static ArrayList<MenuItem> getMenu(){
		return menu;
	}
}
