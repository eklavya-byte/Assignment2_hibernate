package edu.jsp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import edu.jsp.dto.Company;
import edu.jsp.dto.Employee;

public class CompanyDao {
	public void saveCompany(Company company)
	{
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("Prem_Prakash");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		Company comp = new Company();
		comp.setId(company.getId());
		comp.setName(company.getName());
		comp.setLocation(company.getLocation());
		comp.setEmployes(company.getEmployes());
		transaction.begin();
		manager.persist(comp);
		transaction.commit();
		manager.close();
		factory.close();
	}
	public Company getCompanybyId(int id)
	{
		//get company details based on id 
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("Prem_Prakash");
		EntityManager manager = factory.createEntityManager();
		Company p = manager.find(Company.class, id);
		//System.out.println(p);
//		manager.close();
//		factory.close();
		return p;
		// need to close to factory and manager !
	}
	
	public List<Company> getAllCompany()
	{
		//Get Company Details
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("Prem_Prakash");
		EntityManager manager = factory.createEntityManager();
		String query = "SELECT s FROM Company s";
		Query q = manager.createQuery(query);
		List<Company> com = q.getResultList();
		return com;
	}
	
	//update //delete
	public void updateCompany(int id , String name)
	{
		//update employee
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("Prem_Prakash");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		CompanyDao ref = new CompanyDao();
		Company e =ref.getCompanybyId(id);
		System.out.println("Before Updating the Company Name");
		System.out.println(e.getName());
		e.setName(name);
		Company updated = manager.merge(e);
		System.out.println("after Updating the Company name");
		System.out.println(updated.getName());
		System.out.println("Name updated");
		transaction.commit();
		manager.close();
		factory.close();
	}
	public void deleteCompany(int id)
	{
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("Prem_Prakash");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		CompanyDao ref = new CompanyDao();
		Company company = ref.getCompanybyId(id);
		company = manager.find(Company.class,id);
		manager.remove(company);
		System.out.println("Company info with id = "+company.getId()+" is deleted ");
		transaction.commit();
		manager.close();
		factory.close();
	}
}
