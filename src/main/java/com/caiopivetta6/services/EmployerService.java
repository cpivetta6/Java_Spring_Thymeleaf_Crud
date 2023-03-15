package com.caiopivetta6.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.caiopivetta6.dao.EmployerDao;
import com.caiopivetta6.model.Employer;

@Component
@Service
public class EmployerService {

	@Autowired
	EmployerDao employerDao;
	
	public void addEmp(Employer emp) {
		employerDao.addEmployer(emp);
	}
	
	//getList
	public List<Employer> getAllEmp(){
		return employerDao.getAllEmp();
	}
	
	//getId
	public Employer getById(Integer id) {
		return employerDao.getEmpById(id);
	}
	
	//Update
	public void updateEmp(Employer emp) {
		employerDao.updateEmp(emp);
	}
	
	//Delete
	public void deleteEmp(Integer id) {
		employerDao.deleteEmp(id);
	}
	
}
