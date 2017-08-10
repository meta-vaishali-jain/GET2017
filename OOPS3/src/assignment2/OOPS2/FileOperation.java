
package assignment2.OOPS2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;

public class FileOperation {
	//write text in file
		public static void write(String text, String filePath) {
			try {

				BufferedWriter bufferWriter = new BufferedWriter(new FileWriter(new File(
						filePath), true));
				if (text.equals("-1")) {
					bufferWriter.newLine();
				} else {
					bufferWriter.write(text);
				}
				bufferWriter.close();
			} catch (Exception e) {
			}
		}
		
		
		/**
		 * @param filePath		:	path of file from where values are to be read
		 * @return				:	array of objects of Question class
		 *Description 			:	reads a file and return an array of questions objects 	
		 */
		public static Question[] readFromFile(String filePath) {
			Question questions[] = new Question[5];
			int index = 0;
			try {

				// takes stream of bytes from file
				FileInputStream fstream = new FileInputStream(filePath);

				BufferedReader br = new BufferedReader(new InputStreamReader(
						fstream));
				String str = "";

				// Read the File Line By Line
				while ((str = br.readLine()) != null) {

					String[] readedQuestionData = str.split(",");

					// split the values
					Question question = new Question();

					// storing index value
					question.setQuestionIndex(index + 1);

					// storing string of question
					question.setQuestionString(readedQuestionData[0].trim()
							.replaceFirst("Q" + question.getQuestionIndex() + ". ",
									""));

					// storing question type
					question.setQuestionType(readedQuestionData[1].trim());

					// checking for options
					if (readedQuestionData.length > 2) {
						question.setOptionAvailable(true);
						question.setOptions(readedQuestionData[2].trim().split("/"));

						if (question.getQuestionType().startsWith("Single")) {
							question.setMultiSelect(false);

							// initializing option frequency for all single select
							// type question
							question.setOptionFrequency(new int[question
									.getOptions().length]);
						} else {
							question.setMultiSelect(true);
						}

					}

					questions[index] = question;
					index++;
				}
				br.close();
			} catch (Exception e) {
				System.out.print(e.getMessage());
			}
			return questions;
		}

}
