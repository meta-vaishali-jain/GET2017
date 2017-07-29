
package assignment2.OOPS2;
/**

 * ClassName	:	Survey
 * Author		:	Vaishali Jain
 * Description	:	Survey class that perform read operation, write operation, 		
 * 					calculate percentage distribution,sorting of questions alphabetiacally
 * 					and reports A and B created for storing  percentage distribution of 
 * 					participants’ choice for single select question only and all answers 
 * 					given by the participant
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.Scanner;


public class Survey {

	public static void main(String[] args) {
		FileOperation writeInFile=new FileOperation();
		FileOperation readFile=new FileOperation();
		// Read Data from File and store in object array
		Question[] arrayQuestions = readFile.readFromFile("Question.txt");

		Scanner scanner = new Scanner(System.in);
		Scanner lineScanner = new Scanner(System.in);
		try{
		// reading number of users for survey
		System.out.println("Please enter number of users for survey");
		int noOfUsersForSurvey = scanner.nextInt();

		// condition for checking valid number of users
		if (noOfUsersForSurvey < 1) {
			while (noOfUsersForSurvey < 1) {
				System.out
						.println("There must be atleast 1 user for survey, Please enter a valid number");
				noOfUsersForSurvey = scanner.nextInt();
			}
		}
		
		for (int userIndex = 0; userIndex < noOfUsersForSurvey; userIndex++) {

			System.out.println();
			System.out.println();
			System.out.println("**** User" + (userIndex + 1) + " Start ****");
			System.out.println();

			for (int i = 0; i < arrayQuestions.length; i++) {

				Question question = arrayQuestions[i];

				// Display question.
				System.out.println("Q" + question.getQuestionIndex() + ". "
						+ question.getQuestionString());

				// Display type of question.
				System.out.println("Type : " + question.getQuestionType());

				// Display Options only if available
				if (question.isOptionAvailable()) {

					if (question.getOptions() != null
							&& question.getOptions().length > 0) {
						for (int opt = 0; opt < question.getOptions().length; opt++) {
							System.out.println("Option " + (opt + 1) + " : "
									+ question.getOptions()[opt]);
						}
					}
				}

				
				// getting answers according to the type of question
				System.out.print("Please type your answer : ");
				if (question.getQuestionType().startsWith("Single")) {
					int answer = scanner.nextInt();
					while (answer > 5 || answer < 1) {
						System.out.println("Enter a valid option between 1-5");
						answer = scanner.nextInt();

					}
					question.setSelectedAnswer(answer + "");
					writeInFile.write("Participant " + (userIndex + 1) + ","
							+ question.getSelectedAnswer() + ",",
							"Report-B.txt");

					int indexOfAnswer = -1;
					for (int optionIndex = 0; optionIndex < question.getOptions().length; optionIndex++) {
						if (question.getOptions()[optionIndex].equalsIgnoreCase(answer
								+ "")) {
							indexOfAnswer = optionIndex;
							break;
						}
					}

					// setting option frequency for single select type question
					if (indexOfAnswer != -1) {
						question.getOptionFrequency()[indexOfAnswer] = question
								.getOptionFrequency()[indexOfAnswer] + 1;
					}
				} else if (question.getQuestionType().startsWith("Multi")) {
					String answer = lineScanner.nextLine();
					question.setSelectedAnswer(answer);
					writeInFile.write(question.getSelectedAnswer() + ",",
							"Report-B.txt");
				}

				else if (question.getQuestionType().equalsIgnoreCase("Text")
						&& question.getQuestionIndex() == 3) {
					String answer = lineScanner.nextLine();
					question.setSelectedAnswer(answer);
					writeInFile.write(question.getSelectedAnswer() + ",",
							"Report-B.txt");
				}

				else if (question.getQuestionType().equalsIgnoreCase("Number")) {
					long answer = scanner.nextLong();

					// checking if length of number is not equal to 10
					while (String.valueOf(answer).length() != 10) {
						System.out.print("Enter 10 digit number");
						answer = scanner.nextLong();
					}
					question.setSelectedAnswer(answer + "");
					writeInFile.write(question.getSelectedAnswer() + ",",
							"Report-B.txt");
				} else if (question.getQuestionType().equalsIgnoreCase("Text")) {
					String answer = lineScanner.nextLine();
					question.setSelectedAnswer(answer);
					writeInFile.write(question.getSelectedAnswer(),
							"Report-B.txt");
				}

				System.out.println();
				
			}

			System.out.println("**** User" + (userIndex + 1) + " End ****");
			System.out.println();
			System.out.println();
			writeInFile.write("-1", "Report-B.txt");

		}

		// calculate percentage
		CalculatePercentage percentage=new CalculatePercentage();
		percentage.calculatePercentage(arrayQuestions, noOfUsersForSurvey);

		// sorting of question array
		System.out.println();
		Sorting sort=new Sorting();
		sort.doQuickSort(arrayQuestions, 0, arrayQuestions.length - 1);
		System.out.println("Questions after sorting : ");
		for (int i = 0; i < arrayQuestions.length; i++) {
			System.out.println(arrayQuestions[i].getQuestionString());
		}
	
		}catch(Exception e){
			System.out.println("Invalid Input"+e.getMessage());
			
		}
		

	}
	

}
