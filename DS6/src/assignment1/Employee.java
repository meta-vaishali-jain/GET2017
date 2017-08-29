package assignment1;

import java.util.Comparator;

/**
 * ClassName  : Employee
 * @author    : Vaishali Jain
 * Description: class with fields as employeeID, employeeName and employeeAddress describing 
 * 				all the details of each employee.
 */
public class Employee implements Comparable<Employee> {
	private int employeeID;
	private String employeeName;
	private String employeeAddress;
	
	//parameterize constructor
	public Employee(int employeeID, String employeeName, String employeeAddress) {
		this.employeeID = employeeID;
		this.employeeName = employeeName;
		this.employeeAddress = employeeAddress;
	}
	
	//getter to get employee ID
	public int getEmployeeID() {
		return employeeID;
	}
	
	//setter to set employee ID
	public void setEmployeeID(int employeeID) {
		this.employeeID = employeeID;
	}
	
	//getter to get employee Name
	public String getEmployeeName() {
		return employeeName;
	}
	
	//setter to set employee Name
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	
	//getter to get employee Address
	public String getEmployeeAddress() {
		return employeeAddress;
	}
	
	//setter to set employee address
	public void setEmployeeAddress(String employeeAddress) {
		this.employeeAddress = employeeAddress;
	}
	
	/**
	 * for getting a unique ID
	 */
	@Override
	public int hashCode(){
	return employeeID;
	}

	@Override
	public boolean equals(Object employeeObject){
	if(this.employeeID== ((Employee)employeeObject).getEmployeeID()){
	return true;
	}
	return false;
	}
	
	/**
	 * compareTo method to compare objects in natural order
	 */
	@Override
	public int compareTo(Employee employee) {
		// TODO Auto-generated method stub
		return (((Integer)this.getEmployeeID()).compareTo(employee.getEmployeeID()));	
	}
	
	/**
	 *Nested class implementing comparator interface to sort the collection on the basis of name
	 */
	public static class CompareToUsingName implements Comparator<Employee>
	{
	    public int compare(Employee employeeOne, Employee employeeTwo)
	    {	if(employeeOne.getEmployeeName().compareTo(employeeTwo.getEmployeeName())==0){
	    		return employeeOne.compareTo(employeeTwo);
	    	}
	        return employeeOne.getEmployeeName().compareTo(employeeTwo.getEmployeeName());
	    }
	}
}
