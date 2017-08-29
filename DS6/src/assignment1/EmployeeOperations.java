package assignment1;

import java.util.ArrayList;
import java.util.Collections;
import assignment1.Employee.CompareToUsingName;

/**
 * ClassName  : EmployeeOperations
 * @author    : Vaishali Jain
 * Description: class performing different function on employee collection
 * 				1) Perform sorting on  collection i.e natural order.
 * 				2) Perform sorting on collection based on name of employee
 * 				3) Addition of employee in collection
 */
public class EmployeeOperations {
	//collection containing list of employees
	ArrayList<Employee> listOfEmployees;
	
	//getter to get list of employees
	public ArrayList<Employee> getListOfEmployees() {
		return listOfEmployees;
	}
	
	//setter to set list of employees
	public void setListOfEmployees(ArrayList<Employee> listOfEmployees) {
		this.listOfEmployees = listOfEmployees;
	}
	
	//default constructor
	public EmployeeOperations(){
		listOfEmployees=new ArrayList<Employee>();
	}
	
	/**
	 * method performing sorting based on natural order
	 * @return
	 */
	public ArrayList<Employee> naturalOrderSorting(){
		if(listOfEmployees.size()==0){
			return null;
		}
		Collections.sort(listOfEmployees);
		return listOfEmployees;
	}
	
	/**
	 * method performing sorting based on employee name
	 * @return
	 */
	public ArrayList<Employee> nameBasedSorting(){
		if(listOfEmployees.size()==0){
			return null;
		}
		 CompareToUsingName compareToUsingName = new CompareToUsingName();
	        Collections.sort(listOfEmployees,compareToUsingName);
	        return listOfEmployees;
	}
	
	/**
	 * private overloaded method to add employee in the collection
	 * if employee with that id already exist it return false
	 * @param employee
	 * @return
	 */
	private boolean addEmployee(Employee employee){
		if(listOfEmployees.contains(employee)){
			return false;
		}
		listOfEmployees.add(employee);
		return true;
	}
	
	/**
	 * add employee method calling the overloadd method by creating object of employee
	 * @param employeeID
	 * @param employeeName
	 * @param employeeAddress
	 * @return
	 */
	public boolean addEmployee(int employeeID,String employeeName,String employeeAddress){
		return addEmployee(new Employee(employeeID,employeeName,employeeAddress));
	}
}
