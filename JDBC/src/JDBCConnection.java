import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * ClassName  : JDBCConnection
 * @author    : Vaishali Jain
 * Description: Connection class to establish connectivity between java and database.
 */
public class JDBCConnection {
	private static final String HOST = "jdbc:mysql://localhost:3306/";
	private static final String DATABASE_NAME = "Library_Information_System";
	private static final String MY_SQL_URL = HOST + DATABASE_NAME;
	private static final String USER_ID = "root";
	private static final String PASSWORD = "naina";
	
	private static JDBCConnection jdbcConnection=null;
	Connection connection;
	
	private JDBCConnection(){	
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection=DriverManager.getConnection(MY_SQL_URL,USER_ID,PASSWORD);
		} catch (ClassNotFoundException cnfe) {
			System.out.println("Error loading driver" + cnfe);
		}catch(SQLException sqle){
			System.out.println("Error in SQL" + sqle);
		}
	}
	
	public static Connection getJDBCConnection() {
		if (jdbcConnection == null) {
			synchronized (JDBCConnection.class) {
				if (jdbcConnection == null) {
					jdbcConnection = new JDBCConnection();
					return jdbcConnection.connection;
				}
			}
		}
		return jdbcConnection.connection;
	}
	
}





