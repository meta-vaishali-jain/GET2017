
package assignment2.OOPS2;
/*
 * Question class to store values of each question and also implemented
 * comparable interface to compare question string to sort questions
 */
public class Question implements Comparable<Question>{

	private String questionString;
	private String questionType;
	private boolean isOptionAvailable;
	private String[] options;
	private int[] optionFrequency;
	private int questionIndex;
	private String selectedAnswer;
	private boolean isMultiSelect;
	
	public String getQuestionString() {
		return questionString;
	}
	public void setQuestionString(String questionString) {
		this.questionString = questionString;
	}
	public String getQuestionType() {
		return questionType;
	}
	public void setQuestionType(String questionType) {
		this.questionType = questionType;
	}
	public boolean isOptionAvailable() {
		return isOptionAvailable;
	}
	public void setOptionAvailable(boolean isOptionAvailable) {
		this.isOptionAvailable = isOptionAvailable;
	}
	public boolean isMultiSelect() {
		return isMultiSelect;
	}
	public void setMultiSelect(boolean isMultiSelect) {
		this.isMultiSelect = isMultiSelect;
	}
	public String[] getOptions() {
		return options;
	}
	public void setOptions(String[] options) {
		this.options = options;
	}
	public int getQuestionIndex() {
		return questionIndex;
	}
	public void setQuestionIndex(int questionIndex) {
		this.questionIndex = questionIndex;
	}
	public String getSelectedAnswer() {
		return selectedAnswer;
	}
	public void setSelectedAnswer(String selectedAnswer) {
		this.selectedAnswer = selectedAnswer;
	}	
	public int[] getOptionFrequency() {
		return optionFrequency;
	}
	public void setOptionFrequency(int[] optionFrequency) {
		this.optionFrequency = optionFrequency;
	}
	@Override
	public int compareTo(Question questionObject) {
		// TODO Auto-generated method stub
		
		return getQuestionString().compareTo(questionObject.questionString);
		
		//return 0;
	}
	
	
	
}
