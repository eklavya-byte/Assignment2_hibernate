package edu.jsp.dto;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Company {
	@Id
	@Column(name="c_id")
	private int id;
	private String name;
	@Column(name="loc")
	private String location;
	@OneToMany
	private List<Employee> employes;
	public Company() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Company(int id, String name, String location, List<Employee> employes) {
		super();
		this.id = id;
		this.name = name;
		this.location = location;
		this.employes = employes;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public List<Employee> getEmployes() {
		return employes;
	}
	public void setEmployes(List<Employee> employes) {
		this.employes = employes;
	}
	@Override
	public String toString() {
		return "Company [id=" + id + ", name=" + name + ", location=" + location + ", employes size=" + employes.size() + "]";
	}
	
}
