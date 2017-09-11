package employee;

/**
 * ClassName  : Employee
 * @author    : Vaishali Jain
 * Description: Employee POJO class
 */
public class Employee {
	private int employeeID;
	private String employeeName;
	
	//default constructor
	public Employee() {
		
	}
	//parameterize constructor
	public Employee(int id, String name) {
		this.employeeID = id;
		this.employeeName = name;
	}
	
	//getter to get id
	public int getId() {
		return employeeID;
	}
	
	//getter to get employee name
	public String getEmpName() {
		return employeeName;
	}
}
