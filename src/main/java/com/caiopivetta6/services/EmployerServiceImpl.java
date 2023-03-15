package com.caiopivetta6.services;

import java.util.List;

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

	
	
}
