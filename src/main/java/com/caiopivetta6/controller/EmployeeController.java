package com.caiopivetta6.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.caiopivetta6.model.Employee;
import com.caiopivetta6.services.EmployeeService;

@Controller
public class EmployeeController {
	
	
	@Autowired
	private EmployeeService employeeService;

	@GetMapping("/")
	public String viewHomePage(Model model) {
		
		return findPaginated(1,"firstName", "asc", model);
	}
	
	@GetMapping("/showNewEmployeeForm")
	public String showNewEmployeeForm(Model model) {
		Employee employee = new Employee();
		model.addAttribute("employee", employee);
		return "new_employee";
	}
	
	@PostMapping("/saveEmployee")
	public String saveEmployee(@ModelAttribute("employee") Employee employee) {
		employeeService.saveEmployee(employee);
		return "redirect:/";
	}
	
	
	@GetMapping("/showFormForUpdate/{id}")
	public String showFormForUpdate(@PathVariable (value = "id") Integer id, Model model) {
		
		//get Employee from the service 
		Employee employee = employeeService.getEmployee(id);
		
		//Set Employee as a model attribute to pre populate the form
		model.addAttribute("employee", employee);
		return "update_employee";
		
	}
	
	@GetMapping("/deleteEmployee/{id}")
	public String deleteEmployee(@PathVariable (value = "id") Integer id) {
			//call delete employee method
			this.employeeService.deleteEmployee(id);
			return "redirect:/";
		
	}
	
	@GetMapping("/page/{pageNo}")
	public String findPaginated(@PathVariable (value = "pageNo") int pageNo, 
			@RequestParam("sortField") String sortField,
			@RequestParam("sortDir") String sortDir,
			Model model) {
		int pageSize = 5;
		
		Page<Employee> page = employeeService.findPaginated(pageNo, pageSize, sortField, sortDir);
		List<Employee> listEmployees = page.getContent();
		
		model.addAttribute("currentPage", pageNo);
		model.addAttribute("totalPages", page.getTotalPages());
		model.addAttribute("totalItems", page.getTotalElements());
		
		model.addAttribute("sortField", sortField);
		model.addAttribute("sortDir", sortDir);
		model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");
		
		model.addAttribute("listEmployees", listEmployees);
		return "index";
	}
	
	
	/*@GetMapping("/page/{pageNo}")
	public String findPaginated(@PathVariable (value = "pageNo") int pageNo, 
								@RequestParam("sortField") String sortField,
								@RequestParam("sortDir") String sortDir,
							    Model model) {
		
			int pageSize = 5;
			
			//take a mapped Page number and page size from the Service and put on a list.
			Page<Employee> page = employeeService.findPaginated(pageNo, pageSize, sortField, sortDir);
			List<Employee> listEmployees = page.getContent();
			
			//add page numbers, current page and last page, links, and put the list from a range size of a actual model.
			model.addAttribute("currentPage", pageNo);
			model.addAttribute("totalPages", page.getTotalPages());
			model.addAttribute("totalItems", page.getTotalElements());
			
			model.addAttribute("sortField", sortField);
			model.addAttribute("sortDir", sortDir);
			model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");
			
			
			model.addAttribute("listEmployees", listEmployees);
			
			return "index";
			
	}*/
	
}
