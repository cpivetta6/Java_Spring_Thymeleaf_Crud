package com.caiopivetta6.services;

import java.util.List;

import com.caiopivetta6.model.Employer;


public interface EmployerService {

	List<Employer> getAllEmployers();
	void saveEmployer(Employer employer);
	Employer getEmployerById(Integer id);
	void deleteEmployer(Integer id);
	
	
}
