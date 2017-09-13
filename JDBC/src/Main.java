import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
	Scanner inputScanner = new Scanner(System.in);

	/**
	 * method to display menu
	 */
	public static void menu() {
		System.out.println("\nEnter what you want to do");
		System.out.println("1 To get all books published by given author");
		System.out.println("2 To get book issue status");
		System.out.println("3 To delete books not issued in one year");
		System.out.println("4 Exit  : return()");
	}

	/**
	 * method to check input is in number format only
	 * @param choice
	 * @return
	 */
	public boolean isNumber(String input) {
		try {
			int parsedChoice = Integer.parseInt(input);
		} catch (NumberFormatException e) {
			return false;
		}
		return true;
	}

	/**
	 * method to get element in number format
	 * 
	 * @return
	 */
	public int getElementInNumberFormat() {
		String element = inputScanner.next();
		while (!isNumber(element)) {
			System.out
					.println("\nWrong element format Please enter in correct format");
			element = inputScanner.next();
		}
		return Integer.parseInt(element);
	}
	
	/**
	 * method to check for valid choice that is choice entered in particular boundary condition
	 * @param choice
	 * @param maxChoice
	 * @return
	 */
	public static boolean isValidChoice(int choice, int maxChoice) {

		if (choice < 0 || choice > maxChoice) {
			return false;
		}
		return true;
	}
	
	/**
	 * METHOD TO GET Name in correct format
	 * @return
	 */
	public String getElementInStringFormat() {
		Scanner inputScanner = new Scanner(System.in);
		LibInformationSystemDao dao = new LibInformationSystemDao();
		String element;
		element = inputScanner.nextLine();
		//name matches with this pattern or not
		Pattern pattern = Pattern.compile("^[ A-Za-z ]+$");
		Matcher match = pattern.matcher(element);
		boolean flag = match.matches();
		while (!flag) {
			System.out.println("Please enter name in correct format");
			element = inputScanner.nextLine();
		}
		return element;
	}

	// main method
	public static void main(String args[]) throws SQLException {
		Scanner inputScanner = new Scanner(System.in);
		LibInformationSystemDao dao = new LibInformationSystemDao();
		while (true) {
			menu();
			int choice = new Main().getElementInNumberFormat();
			while (!isValidChoice(choice, 4)) {
				System.out.println("Wrong choice\nEnter again");
				choice = new Main().getElementInNumberFormat();
			}
			switch (choice) {
			//to get books list based on author name
			case 1:
				System.out.println("Enter author name");
				String authorName = new Main().getElementInStringFormat();
				if (dao.authorExist(authorName)) {
					ArrayList<Books> booksList = dao
							.getBooksDetails(authorName);
					if (booksList.size() == 0) {
						System.out.println("No book with this author");
					} else {
						System.out
								.println("Accession Number\tBook Title\tPublisherName\tSubjectName");
						for (Books book : booksList) {
							System.out.println(book.getAccessionNo() + "\t\t"
									+ book.getBookTitle() + "\t\t"
									+ book.getPublisherName() + "\t\t"
									+ book.getSubjectName());
						}
					}
				} else {
					System.out.println("No author exist with this name");
				}
				break;
			//to get flag to check book is issued or not
			case 2:
				System.out.println("Enter book name");
				String bookName = inputScanner.nextLine();
				if (dao.bookExistInLibrary(bookName)) {
					System.out.println(dao.getBookIssueStatus(bookName));
				} else {
					System.out.println("Book not exist with this name");
				}
				break;
			//to delete books that were not issued in one year
			case 3:
				System.out.println("Number of books deleted "
						+ dao.deleteBooksNotIssuedInOneYear());
				break;
			//exit
			case 4:
				return;
			}

		}

	}

}
