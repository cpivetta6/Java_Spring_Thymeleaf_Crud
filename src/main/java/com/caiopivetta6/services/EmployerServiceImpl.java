package com.caiopivetta6.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.caiopivetta6.model.Employer;
import com.caiopivetta6.repository.EmployerRespository;

@Service
public class EmployerServiceImpl implements EmployerService{

	@Autowired
	private EmployerRespository employerRespository;
	
	@Override
	public List<Employer> getAllEmployers() {
		return employerRespository.findAll();
	}

	@Override
	public void saveEmployer(Employer employer) {
		Employer empLowCase = new Employer();
		
		empLowCase.setId(employer.getId());
		empLowCase.setFirstName(employer.getFirstName().toLowerCase());
		empLowCase.setLastName(employer.getLastName().toLowerCase());
		empLowCase.setEmail(employer.getEmail().toLowerCase());
		empLowCase.setSalary(employer.getSalary());
	
		
		this.employerRespository.save(empLowCase);
	}

	@Override
	public Employer getEmployerById(Integer id) {
		Optional<Employer> optional = employerRespository.findById(id);
		Employer employer = null;
		
		if(optional.isPresent()) {
			employer = optional.get();
		}else {
			throw new RuntimeException("Employee not found for id" + id);
		}
		
		return employer;
		
	}

	@Override
	public void deleteEmployer(Integer id) {
		this.employerRespository.deleteById(id);
		
	}
	
	

	
	
}
