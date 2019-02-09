package com.CRUD.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="employes001")
public class Employee {
	
	@Id
	//@GeneratedValue(strategy=GenerationType.AUTO)
	
	//@GeneratedValue(strategy=GenerationType.TABLE)
	
	/*
	 * @TableGenerator(name = "employee_gen", table = "id_gen", pkColumnName =
	 * "gen_name", valueColumnName = "gen_val", allocationSize = 100)
	 * 
	 * @GeneratedValue(strategy = GenerationType.TABLE,generator="employee_gen")
	 */
	@GenericGenerator(name="emp_id",strategy="Generators.CustomRandomIDGenerator")
	@GeneratedValue(generator="emp_id")
	private Long id;
	private String name;
	private Long salary;
	//@Column is optional but it is used when we want different column name in db.
	@Column(name="department")
	private String dept;
	public Employee() {
		super();
	}
	public Employee(String name, Long salary, String dept) {
		super();
		this.name = name;
		this.salary = salary;
		this.dept = dept;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getSalary() {
		return salary;
	}
	public void setSalary(Long salary) {
		this.salary = salary;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	
	
}
