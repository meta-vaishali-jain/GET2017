package assignment1;
import java.util.ArrayList;
import java.util.List;


public class Menu extends MenuItem{
	
	private List<MenuItem> subMenu=new ArrayList<MenuItem>();

	public List<MenuItem> getSubMenu() {
		return subMenu;
	}

	public void setSubMenu(List<MenuItem> list) {
		this.subMenu= list;
	}
	
	public MenuItem getSelection(int choice){
		if(choice>=subMenu.size()||choice<0){
			System.out.println("\nWrong choice ");
			System.out.println("\nEnter Again");
			return null;
		}
		return subMenu.get(choice);
	}

	
}
