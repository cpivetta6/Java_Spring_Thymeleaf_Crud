package com.caiopivetta6.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.caiopivetta6.model.Employer;

@Component
public class EmployerDao {

	@Autowired
	HibernateTemplate hibernateTemplate;
	
	//Save Empoyer
	public void addEmployer(Employer emp) {
		hibernateTemplate.save(emp);
	}
	
	//get List
	public List<Employer> getAllEmp(){
		return hibernateTemplate.loadAll(Employer.class);
	}
	
	//Get by id
	public Employer getEmpById(Integer id) {
		
		return hibernateTemplate.load(Employer.class, id);
	}
	
	//update
	public void updateEmp(Employer emp) {
		hibernateTemplate.update(emp);
	}
	
	public void deleteEmp(Integer id) {
		hibernateTemplate.delete(hibernateTemplate.load(Employer.class, id));
	}
	
}
