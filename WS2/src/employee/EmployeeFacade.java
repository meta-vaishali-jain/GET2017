package employee;

import java.util.*;
import org.json.simple.JSONObject;

/**
 * ClassName  : EmployeeFacade
 * @author    : Vaishali Jain
 * Description: Facade class performing all operations on employee
 */
public class EmployeeFacade {
	//HashMap storing all details of employee with key as EmployeeID 
	private Map<Integer, Employee> allemployees = new HashMap<Integer, Employee>();
	private EmployeeDao dao = null;
	
	//default constructor
	public EmployeeFacade() {
		dao = new EmployeeDao();
		List<JSONObject> employeesDetails = dao.readFile();
		makeMap(employeesDetails);
	}
	
	//storing all employee details in the hashMap
	private void makeMap(List<JSONObject> employeeDetails) {
		for(JSONObject emp: employeeDetails) {
			int id =  Integer.parseInt( emp.get("id").toString() );
			Employee employe = new Employee( id , (String)emp.get("name"));
			allemployees.put( id, employe);
		}
	}
	
	//get employee on the basis of the name
	public List<Employee> getEmployeesByName(String name) {
		List<Employee> commonNameEmployees = new ArrayList<Employee>();
		for(Map.Entry<Integer, Employee> emp : allemployees.entrySet()) {
			if(emp.getValue().getEmpName().equals(name)) {
				commonNameEmployees.add( emp.getValue() );
			}
		}
		return commonNameEmployees;
	}
	
	//get employee on the basis of id
	public List<Employee> getEmployeeById(int id) {
		List<Employee> employeeBasedOnID = new ArrayList<Employee>();
		for(Map.Entry<Integer, Employee> emp : allemployees.entrySet()) {
			if(emp.getKey().equals(id)) {
				employeeBasedOnID.add( emp.getValue() );
			}
		}
		return employeeBasedOnID;
	}
	
	//get all employees
	public List<Employee> getAllEmployees(){
		List<Employee> employees = new ArrayList<Employee>();
		
		if(allemployees != null && allemployees.size() > 0) {
			for(Map.Entry<Integer, Employee> emp : allemployees.entrySet()) {
				employees.add(emp.getValue());
			}
		}/*else{
			employees.add(null);
		}*/
		return employees;
	}
	
	//create employee
	public boolean addEmployee(Integer id, String name) {
		if(allemployees.containsKey(id)){
			return false;
		}
		Employee newEmployee =new Employee(id, name);
		allemployees.put(id, newEmployee);
		
		//write to JSON file this change
		dao.writeToFile(allemployees);
		return true;
	}
	
	//getter to get all employee
	public Map<Integer, Employee> getAllemployees() {
		return allemployees;
	}
	
	//setter to set all employee
	public void setAllemployees(Map<Integer, Employee> allemployees) {
		this.allemployees = allemployees;
	}

	//method to delete employee
	public boolean deleteEmployee(Integer id) {
		if(!allemployees.containsKey(id)){
			return false;
		}
		allemployees.remove(id);
		
		//write this change to file
		dao.writeToFile(allemployees);
		return true;
	}
}
