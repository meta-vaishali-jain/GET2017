
/**
 * ClassName: ActionableMenuItem
 * @author  : Vaishali Jain
 * Description: to trigger action depending on user choice
 */

public class ActionableMenuItem extends MenuItem{
	
	Action action;	
	/*
	 * method to perform action dependig on the choice
	 */
	public void triggerAction(int choice){
		this.action.performAction(choice);
	}
    
	//parametrize constructor
	public ActionableMenuItem(Action action) {
		this.action = action;
	}


}

