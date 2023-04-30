package com.caiopivetta6.model;

import java.io.Serializable;

import com.caiopivetta6.entities.Budget;
import com.caiopivetta6.entities.IRPEF;
import com.caiopivetta6.entities.TaxableIncome;
import com.caiopivetta6.entities.taxCalculate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Employee implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String firstName;
	private String lastName;
	private String email;
	private Double grossSalary;
	private Double netSalary;
	
	

	public Employee() {
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Double getSalary() {
		return grossSalary;
	}

	public void setSalary(Double salary) {
		
		calculateNetSalary(salary, new IRPEF());
		
	}

	public Double getNetSalary() {
		return netSalary;
	}

	//method for tax calculator
	public void calculateNetSalary(Double salary, TaxableIncome taxCalculator) {
	    try {
	        this.grossSalary = salary;
	        this.netSalary = taxCalculator.calculateTax(new Budget(salary));
	    } catch (Exception e) {
	        // Handle the error gracefully
	    }
	}
	
}
