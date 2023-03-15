package com.caiopivetta6.model;


public class Employer {

	private Integer id;
	private String name;
	private String department;
	private String address;
	private Double salary;
	private String designation;

	public Employer() {
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	@Override
	public String toString() {
		return "Employer [id=" + id + ", name=" + name + ", department=" + department + ", address=" + address
				+ ", salary=" + salary + ", designation=" + designation + "]";
	}

	
	
	
}
