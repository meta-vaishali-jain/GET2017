package employee;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
import java.util.logging.Logger;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

/**
ClassName  : EmployeeService
@author    : Vaishali Jain
Description : Web service for the employee class
*/

@Path("/employees")
public class EmployeeService {
	EmployeeFacade employeeDetails;

	//default constructor
	public EmployeeService() {
		employeeDetails = new EmployeeFacade();
	}

	//service to get all employees
	@GET
	@Path("/getAll/")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Employee> getEmployees() {
		return employeeDetails.getAllEmployees();
	}
	
	//service to get employee id
	@GET
	@Path("/getById/{employee}")
	public List<Employee> getEmployee(@PathParam("employee")Integer id) {
		return employeeDetails.getEmployeeById(id);
	}
	
	//service to get employee by name
	@GET
	@Path("/getByName/{employee}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Employee> getEmployeeByName(@PathParam("employee") String name) {
		return employeeDetails.getEmployeesByName(name);
	}

	//service to delete employee
	@GET
	@Path("/deleteById/{employee}")
	@Produces(MediaType.APPLICATION_JSON)
	public boolean deleteEmployee(@PathParam("employee") Integer id) {
		return employeeDetails.deleteEmployee(id);
	}
	
	//service to create employee
	@GET
	@Path("/create/{id}/{name}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public boolean createEmployee(@PathParam("id") Integer id,
							     @PathParam("name") String name
							  ) {
			
		return employeeDetails.addEmployee(id, name);
	}
}