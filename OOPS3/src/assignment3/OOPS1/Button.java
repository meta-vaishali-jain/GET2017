package assignment3.OOPS1;

class Button extends Layout{
	
	protected int height,width;
	
	public Button()
	{
		// default size of the buttons 
	}
	/**
	 * 
	 * @param height
	 * @param width
	 * create buttons of variable height and width as required by user
	 */
	public void setButtonSize(int height,int width)
	{
		height = this.height;
		width = this.width;
	}
	/**
	 * 
	 * @return string value that user pressed
	 */
	public String onClick()
	{
		// return numbers and operators whatever user has added 
		// add these inputs to queue for further processing
		return "";
	}
}
