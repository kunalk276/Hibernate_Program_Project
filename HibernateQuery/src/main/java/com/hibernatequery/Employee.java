package com.hibernatequery;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;


///*HQL - Hibernate Query Language */
//@NamedQueries(
//		
//		{ 
//			@NamedQuery(
//					
//					name="findEmployeeBYName",
//					query="from Employee e where e.name=:name"
//					
//					   )
//			
//		
//		}
//
//		)
//




@Entity
@NamedQuery(name = "findEmployeeByName", query = "SELECT e FROM Employee e WHERE e.name = :name")
public class Employee {
	
	@Id
	private int id;
	private String name;
	private String job;
	private int salary;
	
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employee(int id, String name, String job, int salary) {
		super();
		this.id = id;
		this.name = name;
		this.job = job;
		this.salary = salary;
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
	public String getDept() {
		return job;
	}
	public void setjob(String job) {
		this.job = job;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", job=" + job + ", salary=" + salary + "]";
	}

}