package view;

class MenuItem {
	private String menuName;
	private int menuOption;	
	
	public MenuItem() {
		
	}
	//describe each item of complete menu
	public MenuItem(int option, String menuitem) {
		this.menuName  = menuitem;
		this.menuOption= option; 
	}
	
	public String getMenuItemName(){
		return this.menuName;
	}
	
	public int getMenuItemOption(){
		return this.menuOption;
	}
}
