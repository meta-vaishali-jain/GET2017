package employee;

import java.io.*;
import java.util.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * ClassName  : EmployeeDao
 * @author    : Vaishali Jain
 * Description: Dao class to perform read and write operaton on JSON ile
 */
public class EmployeeDao {
	public static final String FILEPATH = "C:/Users/user11/workspace/WS2/Employees.json";
	public static final String EMPLOYEES= "employees";
	
	/**
	 * Read operation to read data from JSON file
	 * Stored that data in the list of JSON object
	 * @return
	 */
	public List<JSONObject> readFile() {
		List<JSONObject> employees = new ArrayList<JSONObject>();
		JSONParser parser = new JSONParser();
		
		try {
			 Object obj = parser.parse(new FileReader( FILEPATH ));
		     JSONObject jsonObject = (JSONObject) obj;
		 
		     JSONArray employeeDetails = (JSONArray) jsonObject.get( EMPLOYEES );
		     
		     for(int i = 0 ; i < employeeDetails.size() ; i++){
		         employees.add( (JSONObject)employeeDetails.get(i));
		     }
		}catch(ParseException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		return employees;
	}
	
	/**
	 * Write operation to write data to a file
	 * @param employeeList
	 */
	public void writeToFile(Map<Integer, Employee> employeeList ) {
		JSONArray list = new JSONArray();
		
		for(Map.Entry<Integer, Employee> employee: employeeList.entrySet()) {
			JSONObject addToFile = new JSONObject();

			addToFile.put("id", employee.getValue().getId() );
			addToFile.put("name", employee.getValue().getEmpName() );
			list.add( addToFile);
		}
		
		JSONObject fileObject = new JSONObject();
		fileObject.put(EMPLOYEES, list);

		try {
			FileWriter writer = new FileWriter( FILEPATH );
			
			writer.write( fileObject.toJSONString() );
			writer.flush();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
