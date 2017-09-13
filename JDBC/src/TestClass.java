import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * ClassName  :TestClass
 * @author    : Vaishali Jain 
 * Description: Test class having test cases for all methods
 */
public class TestClass {
LibInformationSystemDao dao;
	
	@Before
	public void setup(){
		dao=new LibInformationSystemDao();
	}
	
	//To test if book exist in library
	@Test
	public void testBookExistInLibrary() throws SQLException{
		Assert.assertTrue(dao.bookExistInLibrary("Let us C++"));
	}
	
	//to test if book not exist in library
	@Test
	public void testBookNotExistInLibrary() throws SQLException{
		Assert.assertFalse(dao.bookExistInLibrary("Ramayana"));
	}
	
	//to test if author exist
	@Test
	public void testAuthorExist() throws SQLException{
		Assert.assertTrue(dao.authorExist("vaishali"));
	}
	
	//to test if author not exist
	@Test
	public void testAuthorNotExist() throws SQLException{
		Assert.assertFalse(dao.authorExist("abc"));
	}
	
	//to test if no author is passed
	@Test
	public void testAuthor() throws SQLException{
		Assert.assertFalse(dao.authorExist(" "));
	}
	
	//to test if null is passed
	@Test
	public void testAuthorIfNULL() throws SQLException{
		Assert.assertFalse(dao.authorExist(null));
	}
	
	//to test if no book is passed
	@Test
	public void testBook() throws SQLException{
		Assert.assertFalse(dao.bookExistInLibrary(" "));
	}
	
	//to test if null is passed
	@Test
	public void testBookIfNull() throws SQLException{
		Assert.assertFalse(dao.bookExistInLibrary(null));
	}
	
	//test case to get book details corresponding to author name
	@Test
	public void testGetBookDetails() throws SQLException{
		ArrayList<Books> booksList=new ArrayList<Books>();
		booksList=dao.getBooksDetails("naina");
		Assert.assertEquals("LET US JAVA",booksList.get(0).getBookTitle());
		Assert.assertEquals("Java",booksList.get(0).getSubjectName());
		Assert.assertEquals("New Moon Books",booksList.get(0).getPublisherName());
	}
	
	//test case to check if no book exist with that author
	@Test
	public void testGetBookDetailsIfNoBookThere() throws SQLException{
		ArrayList<Books> booksList=new ArrayList<Books>();
		booksList=dao.getBooksDetails("abc");
		Assert.assertEquals(0,booksList.size());
	}
	
	//test case to check status if book was issued
	@Test
	public void testGetBookIssueStatus() throws SQLException{
		Assert.assertEquals("ISSUED",dao.getBookIssueStatus("Let us c++"));
	}
	
	//test case to check status if book was not issued
	@Test
	public void testGetBookNotIssueStatus() throws SQLException{
		Assert.assertEquals("NOT ISSUED",dao.getBookIssueStatus("Let us java"));
	}
	
	
	
}
