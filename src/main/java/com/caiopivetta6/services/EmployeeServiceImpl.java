package com.caiopivetta6.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.caiopivetta6.model.Employee;
import com.caiopivetta6.repository.EmployedRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	private EmployedRepository employeeRepository;
	
	@Override
	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();
	}

	
	
	@Override
	public void saveEmployee(Employee employee) {
		Employee empLowCase = new Employee();
		
		empLowCase.setId(employee.getId());
		empLowCase.setFirstName(employee.getFirstName().toLowerCase());
		empLowCase.setLastName(employee.getLastName().toLowerCase());
		empLowCase.setEmail(employee.getEmail().toLowerCase());
		empLowCase.setSalary(employee.getSalary());
	
		
		this.employeeRepository.save(empLowCase);
	}

	@Override
	public Employee getEmployee(Integer id) {
		Optional<Employee> optional = employeeRepository.findById(id);
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
		this.employeeRepository.deleteById(id);
		
		
	}

	
	
	@Override
	public Page<Employee> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection) {
		Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
			Sort.by(sortField).descending();
		
		Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
		return this.employeeRepository.findAll(pageable);
	}

	/*@Override
	public Page<Employee> findPaginated(int pageNo, int pageSize, String sortField, String sortDirectional) {
		
		// method takes a Sort parameter that specifies the order in which the results should be returned. 
		Sort sort = sortDirectional.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() : Sort.by(sortField).descending();
		
		Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
		return this.employeeRespository.findAll(pageable);
	}*/


	
	
}
