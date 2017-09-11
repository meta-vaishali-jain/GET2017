package employee;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestEmployeeOperations {
	EmployeeFacade employeeOperations;
	
	@Before
	public void setup(){
		employeeOperations=new EmployeeFacade();
	}
	
	//Test case to test add employee method
	@Test
	public void testAddEmployee(){
		Assert.assertTrue(employeeOperations.addEmployee(789,"naina"));
	}
	
	//test case to test delete employee function
	@Test
	public void testDeleteEmployeeFunction() {
		employeeOperations.addEmployee(999,"abc");
		employeeOperations.deleteEmployee(999);;
		boolean actual = employeeOperations.getAllemployees().containsKey(999);
		boolean expected = false;
		Assert.assertEquals(expected, actual);
	}
	
	//test case to test get employee by name function
	@Test
	public void testGetEmployeeByName(){
		employeeOperations.addEmployee(998,"abc");
		Assert.assertEquals(998,(int)employeeOperations.getEmployeesByName("abc").get(0).getId());
	}
	
	//test case to test get employee by id function
	@Test
	public void testGetEmployeeByID(){
		employeeOperations.addEmployee(997,"abcd");
		Assert.assertEquals(997,(int)employeeOperations.getEmployeeById(997).get(0).getId());
	}
	
	//test case to test get all employee
	@Test
	public void testGetAllEmployee(){
		Assert.assertEquals(10,employeeOperations.getAllemployees().size());
	}
}
