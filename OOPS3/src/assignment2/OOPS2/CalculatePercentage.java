package assignment2.OOPS2;

public class CalculatePercentage{
public  void calculatePercentage(Question[] arrayOfQuestion, int noOfUsers) {
	    FileOperation writeInFile=new FileOperation();
		for (int i = 0; i < arrayOfQuestion.length; i++) {
			Question question = arrayOfQuestion[i];
			if (question.getQuestionType().startsWith("Single")) {
				for (int j = 0; j < question.getOptions().length; j++) {

					// percentage calculation for each choice
					float percentage = (question.getOptionFrequency()[j] / (float) noOfUsers) * 100;

					// writing percentage in a file
					writeInFile.write((j + 1) + "-" + String.format("%.02f", percentage)
							+ "%", "Report-A.txt");
					writeInFile.write("-1", "Report-A.txt");
				}
				System.out.print("Percentage calculated successfully");
			}
		}

	}
}