package com.caiopivetta6.services;

import java.util.List;

import com.caiopivetta6.model.Employee;


public interface EmployeeService {

	List<Employee> getAllEmployees();
	void saveEmployee(Employee employee);
	Employee getEmployee(Integer id);
	void deleteEmployee(Integer id);
	
	
}
