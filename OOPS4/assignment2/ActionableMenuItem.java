package assignment2;

/**
 * ClassName: ActionableMenuItem
 * @author :  Vaishali Jain
 * Description: trigger action to perform on the basis of choics
 */
public class ActionableMenuItem extends MenuItem{
	
	Action action;

	
	public void triggerAction(int choice){
		this.action.performAction(choice);
	}

	public ActionableMenuItem(Action action) {
		
		this.action = action;
	}


}

