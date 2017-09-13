/**
 * ClassName  : Books
 * @author    : Vaishali Jain
 * Description: POJO class for details of books.
 */
public class Books {
	//accession number of book
	private int accessionNo;
	//title of book
	private String bookTitle;
	//subject name of book
	private String subjectName;
	//publisher name of book
	private String publisherName;
	
	//getter to get accession number of book
	public int getAccessionNo() {
		return accessionNo;
	}
	
	//getter to get title of book
	public String getBookTitle() {
		return bookTitle;
	}
	
	//getter to get name of the subject
	public String getSubjectName() {
		return subjectName;
	}
	
	//getter to get publisher of the book
	public String getPublisherName() {
		return publisherName;
	}
	
	//parameterize constructor
	public Books(int accessionNo, String bookTitle, String subjectName,String publisherName) {
		this.accessionNo = accessionNo;
		this.bookTitle = bookTitle;
		this.subjectName = subjectName;
		this.publisherName = publisherName;
	}
}
