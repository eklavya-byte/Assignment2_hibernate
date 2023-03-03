package edu.jsp.dao;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import edu.jsp.dto.Employee;
public class EmployeeDao {
	
	public void saveEmployee(Employee employee)
	{
		// save employees details here 
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("Prem_Prakash");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		Employee emp = new Employee();
		emp.setId(employee.getId());
		emp.setName(employee.getName());
		emp.setSalary(employee.getSalary());
		emp.setDesignation(employee.getDesignation());
		transaction.begin();
		manager.persist(emp);
		transaction.commit();
		manager.close();
		factory.close();
	}
	public Employee getEmployeeById(int id)
	{
		// get employee details
		//get company details based on id 
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("Prem_Prakash");
		EntityManager manager = factory.createEntityManager();
		Employee e = manager.find(Employee.class, id);
		//System.out.println(p);
		return e;
		// need to close to factory and manager !
	}
	public List<Employee> getAllEmployee()
	{
		// return list of employee
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("Prem_Prakash");
		EntityManager manager = factory.createEntityManager();
		String query = "SELECT s FROM Employee s";
		Query q = manager.createQuery(query);
		List<Employee> emp = q.getResultList();
		return emp;
	}
	public void updateEmployee(int id , double salary)
	{
		//update employee
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("Prem_Prakash");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		EmployeeDao ref = new EmployeeDao();
		Employee e =ref.getEmployeeById(id);
		System.out.println("Before Updating the employee salary");
		System.out.println(e.getSalary());
		e.setSalary(salary);
		Employee updated = manager.merge(e);
		System.out.println("after Updating the employee salary");
		System.out.println(updated.getSalary());
		System.out.println("Salary updated");
		transaction.commit();
		manager.close();
		factory.close();
	}
	public void deleteEmployee(int id)
	{
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("Prem_Prakash");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		EmployeeDao ref = new EmployeeDao();
		Employee employee = ref.getEmployeeById(id);
		employee = manager.find(Employee.class,id);
		manager.remove(employee);
		System.out.println("Employee info with id = "+employee.getId()+" is deleted ");
		transaction.commit();
		manager.close();
		factory.close();
	}
}
