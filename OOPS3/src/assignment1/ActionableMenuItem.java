package assignment1;
/**
 * ClassName: ActionableMenuItem
 * @author  : Vaishali Jain
 * Description: to trigger action depending on user choice
 */

public class ActionableMenuItem extends MenuItem{
	
	Action action;

	
	public void triggerAction(){
		this.action.performAction();
	}

	public ActionableMenuItem(Action action) {
		
		this.action = action;
	}


}

