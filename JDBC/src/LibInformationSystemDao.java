import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * ClassName   : LibInformationSystemDao
 * @author     : Vaishali Jain
 * Description : Dao class of library information system to perform all operation
 * 				 from database.
 */
public class LibInformationSystemDao {
	//Object of Connection
	Connection connection;
	
	//default constructor
	public LibInformationSystemDao() {
		connection = JDBCConnection.getJDBCConnection();
	}
	
	/**
	 * Fetch all the books published by author, given the name of the author.Return the books data (List of Titles).
	 * @param authorName
	 * @return
	 * @throws SQLException
	 */
	public ArrayList<Books> getBooksDetails(String authorName) throws SQLException{
		//query performing following function
		String query="SELECT B.accession_no,T.title_name,S.subject_name,P.publisher_name"
					+ " FROM Books AS B  "
					+ "JOIN Titles AS T ON T.title_id = B.title_id "
					+ "JOIN Subjects AS S ON S.subject_id=T.subject_id "
					+ "JOIN Publishers AS P ON P.publisher_id=T.publisher_id "
					+ "JOIN Title_Author AS TA ON T.title_id=TA.title_id "
					+ "JOIN Authors AS A ON TA.author_id=A.author_id "
					+ "WHERE A.author_name=?";
		PreparedStatement preparedStatement=connection.prepareStatement(query);
		preparedStatement.setString(1,authorName);
		//execute the query stored result in result set
		ResultSet resultSet=preparedStatement.executeQuery();
		ArrayList<Books> booksList=new ArrayList<Books>();
		//store result in book class object and add that in ArrayList
		while(resultSet.next()){
			booksList.add(new Books(resultSet.getInt(1),resultSet.getString(2),resultSet.getString(3),resultSet.getString(4)));
		}
		//return list of books
		return booksList;
	}
	
	/**
	 * method to check book exist in library or not.
	 * @param bookName
	 * @return
	 * @throws SQLException
	 */
	public boolean bookExistInLibrary(String bookName) throws SQLException{
		String result="";
		//query returning Exist if book exist in library otherwise returning notExist
		String query="SELECT IF(count(*)>0 ,'Exist','notExist') "
				+ "FROM Books AS B JOIN Titles As T ON B.title_id=T.title_id "
				+ "WHERE T.title_name=?";
		PreparedStatement preparedStatement=connection.prepareStatement(query);
		preparedStatement.setString(1,bookName);
		//execute query
		ResultSet resultSet=preparedStatement.executeQuery();
		resultSet.next();
		result=resultSet.getString(1);
		//return true if book exist
		if(result.equals("Exist")){
			return true;
		}
		//return false if book not exist
		return false;
	}
	
	/**
	 * method to check if particular author exist or not
	 * @param authorName
	 * @return
	 * @throws SQLException
	 */
	public boolean authorExist(String authorName) throws SQLException{
		String result="";
		//query returning exist if author exist otherwise returning not exist
		String query="SELECT IF(count(*)>0,'Exist','notExist') FROM Authors WHERE author_name=?";
		PreparedStatement preparedStatement=connection.prepareStatement(query);
		preparedStatement.setString(1,authorName);
		//execute query
		ResultSet resultSet=preparedStatement.executeQuery();
		while(resultSet.next()){
		 result=resultSet.getString(1);
		}
		//return true if exist
		if(result.equals("Exist")){
			return true;
		}
		//return false if not exist
		return false;
		
	}
	
	/**
	 * Given the name of the book, to be issued by an existing member.Return flag to indicate whether the  the book has been issued or not.
	 * @param bookName
	 * @return
	 * @throws SQLException
	 */
	public String getBookIssueStatus(String bookName) throws SQLException{
		String flag="";
		//query results "ISSUED" if book has been issued otherwise resuls"NOT ISSUED"
		String query="SELECT IF(COUNT(*)>0 ,'ISSUED','NOT ISSUED') FROM Book_Issue AS BI JOIN Books AS B ON BI.accession_no=B.accession_no JOIN Titles AS T ON T.title_id= B.title_id WHERE T.title_name=?";	
		PreparedStatement preparedStatement=connection.prepareStatement(query);
		preparedStatement.setString(1,bookName);
		//execute query
		ResultSet resultSet=preparedStatement.executeQuery();
		//set value of flag
		while(resultSet.next()){
			flag=resultSet.getString(1);
		}
		//return flag
		return flag;
	}
	
	/**
	 * Delete all those books which were not issued in last 1 year. Return the number of books deleted.
	 * @return
	 * @throws SQLException
	 */
	public int deleteBooksNotIssuedInOneYear() throws SQLException{
		String query="DELETE FROM Books WHERE accession_no NOT IN (SELECT BI.accession_no FROM Book_issue AS BI WHERE TIMESTAMPDIFF( YEAR,BI.issue_date,now())<1)";
		PreparedStatement preparedStatement=connection.prepareStatement(query);
		int noOfUpdates=preparedStatement.executeUpdate();
		return noOfUpdates;
	}
}
