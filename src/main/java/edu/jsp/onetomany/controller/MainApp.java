package edu.jsp.onetomany.controller;
import java.util.Arrays;
import java.util.List;
import edu.jsp.dao.CompanyDao;
import edu.jsp.dao.EmployeeDao;
import edu.jsp.dto.Company;
import edu.jsp.dto.Employee;

public class MainApp {

	public static void main(String[] args) {
		
		Company company = new Company();
		company.setId(103);
		company.setName("Relience digital");
		company.setLocation("Mumbai");
		Employee employee1 = new Employee();
		employee1.setId(6004);
		employee1.setName("sanjay");
		employee1.setSalary(20000.00);
		employee1.setDesignation("Web Developer");
		Employee employee2 = new Employee();
		employee2.setId(6005);
		employee2.setName("Ramesh");
		employee2.setSalary(21000.00);
		employee2.setDesignation("Web Designer");
		Employee employee3 = new Employee();
		employee3.setId(6006);
		employee3.setName("Raj");
		employee3.setSalary(19000.00);
		employee3.setDesignation("Cloud Engineer");
		// This is a kind of bridge between two tables !
		List<Employee> employes = Arrays.asList(employee1,employee2,employee3);
		company.setEmployes(employes);	
/*-----------------------------------------------------------------*/
/*-----------------------------------------------------------------*/
		// calling and saving data 
		
		CompanyDao ref = new CompanyDao();
		EmployeeDao emp_ref = new EmployeeDao();
		
//		emp_ref.saveEmployee(employee1);
//		emp_ref.saveEmployee(employee2);
//		emp_ref.saveEmployee(employee3);
//		ref.saveCompany(company);
/*-----------------------------------------------------------------*/
/*-----------------------------------------------------------------*/
		//Find Company,Employee details by id !
		
//		System.out.println(ref.getCompanybyId(101));
//		System.out.println(emp_ref.getEmployeeById(5001));
/*-----------------------------------------------------------------*/
/*-----------------------------------------------------------------*/
		//find list of all employee 
		
//		List<Employee> e = emp_ref.getAllEmployee();
//		for(Employee i:e)
//		{
//			System.out.println(i);
//		}
/*-----------------------------------------------------------------*/
/*-----------------------------------------------------------------*/
		// find list of all company
		
//		List<Company> c = ref.getAllCompany();
//		for(Company i:c)
//		{
//			System.out.println(i);
//		}
/*-----------------------------------------------------------------*/
/*-----------------------------------------------------------------*/
		// updating employee
		//emp_ref.updateEmployee(6005, 20000.00);
/*-----------------------------------------------------------------*/
/*-----------------------------------------------------------------*/
		//deleting the employee 
		//emp_ref.deleteEmployee(6007);
/*-----------------------------------------------------------------*/
/*-----------------------------------------------------------------*/
		//update Company and delete company
//		ref.updateCompany(3, "Wipro"); 
//		ref.deleteCompany(3);

	}
}
