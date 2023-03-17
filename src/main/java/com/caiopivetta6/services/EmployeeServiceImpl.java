package com.caiopivetta6.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.caiopivetta6.model.Employee;
import com.caiopivetta6.repository.EmployedRespository;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	private EmployedRespository employeeRespository;
	
	@Override
	public List<Employee> getAllEmployees() {
		return employeeRespository.findAll();
	}

	
	
	@Override
	public void saveEmployee(Employee employee) {
		Employee empLowCase = new Employee();
		
		empLowCase.setId(employee.getId());
		empLowCase.setFirstName(employee.getFirstName().toLowerCase());
		empLowCase.setLastName(employee.getLastName().toLowerCase());
		empLowCase.setEmail(employee.getEmail().toLowerCase());
		empLowCase.setSalary(employee.getSalary());
	
		
		this.employeeRespository.save(empLowCase);
	}

	@Override
	public Employee getEmployee(Integer id) {
		Optional<Employee> optional = employeeRespository.findById(id);
		Employee employee = null;
		
		if(optional.isPresent()) {
			employee = optional.get();
		}else {
			throw new RuntimeException("Employee not found for id" + id);
		}
		
		return employee;
		
	}

	@Override
	public void deleteEmployee(Integer id) {
		this.employeeRespository.deleteById(id);
		
	}


	
	
}
