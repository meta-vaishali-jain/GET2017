package view;

import java.util.Scanner;
import controller.Controller;

/**
 * ClassName   : BaseView
 * @author     : Vaishali Jain
 * Description : class which is the base for all the view related class
 *             : singleton class
 */
public class BaseView {
	Scanner inputScanner=new Scanner(System.in);
    Controller  controller=null;
    GetInput userInput=null;
    DisplayOutput displayOutput=null;
	
    private static BaseView baseView;
	private BaseView(){
		 //create menu to perform action
		   controller=Controller.getInstance();
		     userInput=GetInput.getInstance();
		     displayOutput=DisplayOutput.getInstance();
		 Menu.createMenu();
		 while(true){
			displayOutput.displayMenu(Menu.getMenu());
		    String choice=userInput.getChoice();
		    controller.selectResponse(choice);
		}	
	}
	
	
	public static BaseView getInstance(){
		if (baseView == null){
			//synchronized(BaseView.class){
				if (baseView == null){	
					baseView = new BaseView();
				}
			//}
		}
		return baseView;
	}
	
	
	
		
	
	
	
}
