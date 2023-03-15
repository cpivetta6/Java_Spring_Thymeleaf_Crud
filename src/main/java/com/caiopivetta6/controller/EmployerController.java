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
	
}
