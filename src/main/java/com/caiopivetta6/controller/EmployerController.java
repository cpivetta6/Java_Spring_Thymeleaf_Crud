package com.caiopivetta6.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.caiopivetta6.model.Employer;
import com.caiopivetta6.services.EmployerService;

@Controller
public class EmployerController {
	
	
	@Autowired
	private EmployerService employerService;

	@GetMapping("/")
	public String viewHomePage(Model model) {
		model.addAttribute("listEmployers", employerService.getAllEmployers());
		return "index";
	}
	
	@GetMapping("/showNewEmployeeForm")
	public String showNewEmployeeForm(Model model) {
		Employer employer = new Employer();
		model.addAttribute("employer", employer);
		return "new_employee";
	}
	
	@PostMapping("/saveEmployee")
	public String saveEmployee(@ModelAttribute("employer") Employer employer) {
		employerService.saveEmployer(employer);
		return "redirect:/";
	}
	
	
	@GetMapping("/showFormForUpdate/{id}")
	public String showFormForUpdate(@PathVariable (value = "id") Integer id, Model model) {
		
		//get Employee from the service 
		Employer employer = employerService.getEmployerById(id);
		
		//Set Employee as a model attribute to pre populate the form
		model.addAttribute("employer", employer);
		return "update_employee";
		
	}
	
	@GetMapping("/deleteEmployee/{id}")
	public String deleteEmployee(@PathVariable (value = "id") Integer id) {
			//call delete employee method
			this.employerService.deleteEmployer(id);
			return "redirect:/";
		
	}
	
}
