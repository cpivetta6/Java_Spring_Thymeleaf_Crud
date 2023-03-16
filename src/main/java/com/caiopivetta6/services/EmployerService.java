package com.caiopivetta6.services;

import java.util.List;

import com.caiopivetta6.model.Employer;


public interface EmployerService {

	List<Employer> getAllEmployers();
	void saveEmployer(Employer employer);
	Employer getEmployerById(Integer id);
	void deleteEmployer(Integer id);
	
	/*
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
	*/
}
