package assignment1;


import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestClass {
	EmployeeOperations employeeOperations;
	
	@Before
	public void setup(){
		employeeOperations=new EmployeeOperations();
	}
	
	//test case to check add employee method
	@Test
	public void testAddEmployee(){
		Assert.assertTrue(employeeOperations.addEmployee(1001,"naina","123 xyz"));
		Assert.assertEquals(1,employeeOperations.getListOfEmployees().size());
	}
	
	//test case to check add employee method if employee is already there
	@Test
	public void testIfEmployeeAlreadyThere(){
		Assert.assertTrue(employeeOperations.addEmployee(1001,"naina","123 xyz"));
		Assert.assertFalse(employeeOperations.addEmployee(1001,"vaishali","1234 xyz"));
		Assert.assertEquals(1,employeeOperations.getListOfEmployees().size());
	}
	
	//test case to check add employee if employee with different id are there
	@Test
	public void testIfEmployeeWithDifferentID(){
		Assert.assertTrue(employeeOperations.addEmployee(1001,"naina","123 xyz"));
		Assert.assertTrue(employeeOperations.addEmployee(1002,"vaishali","1234 xyz"));
		Assert.assertEquals(2,employeeOperations.getListOfEmployees().size());
	}
	
	//test case to check natural sorting if collection is empty
	@Test
	public void testNaturalSortingIfCollectionEmpty(){
		Assert.assertEquals(null,employeeOperations.naturalOrderSorting());
	}
	
	//test case to check name based sorting if collection is empty
	@Test
	public void testNameBasedSortingIfCollectionEmpty(){
		Assert.assertEquals(null,employeeOperations.nameBasedSorting());
	}
	
	//test case to test natural sorting if collection is not empty
	@Test
	public void testNaturalSorting(){
		Assert.assertTrue(employeeOperations.addEmployee(1002,"naina","123 xyz"));
		Assert.assertTrue(employeeOperations.addEmployee(1001,"vaishali","1234 xyz"));
		ArrayList<Employee> listOfEmployees=employeeOperations.naturalOrderSorting();
		Assert.assertEquals(1001,listOfEmployees.get(0).getEmployeeID());
		Assert.assertEquals(1002,listOfEmployees.get(1).getEmployeeID());		
	}
	
	//test case to test name based sorting if collection is not empty
	@Test
	public void testNameBasedSorting(){
		Assert.assertTrue(employeeOperations.addEmployee(1002,"naina","123 xyz"));
		Assert.assertTrue(employeeOperations.addEmployee(1001,"vaishali","1234 xyz"));
		ArrayList<Employee> listOfEmployees=employeeOperations.nameBasedSorting();
		Assert.assertEquals(1002,listOfEmployees.get(0).getEmployeeID());
		Assert.assertEquals(1001,listOfEmployees.get(1).getEmployeeID());		
	}
	
	//test case to test if two employee with different id have same name
	@Test
	public void testSameNameBasedSorting(){
		Assert.assertTrue(employeeOperations.addEmployee(1002,"naina","123 xyz"));
		Assert.assertTrue(employeeOperations.addEmployee(1001,"naina","1234 xyz"));
		ArrayList<Employee> listOfEmployees=employeeOperations.nameBasedSorting();
		Assert.assertEquals(1001,listOfEmployees.get(0).getEmployeeID());
		Assert.assertEquals(1002,listOfEmployees.get(1).getEmployeeID());		
	}
}

