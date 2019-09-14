package com.spring.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.spring.model.Employee;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;

@Controller
public class EmployeeController {
	List<Employee> emp = new ArrayList<Employee>();

	@PostConstruct
	public void init() throws Exception {
		emp.add(new Employee(1, "Prashant", "Pune"));
		emp.add(new Employee(2, "Nikita", "Pune"));
	}

	// @GetMapping
	// public String index() {
	// return "redirect:/employee";
	// }

	@GetMapping("/employee")
	public String getEmployee(Model model) {
		model.addAttribute("employee", emp);

		printhtml(emp);
		return "employee/employee.html";

	}

	private void printhtml(List<Employee> empOoj) {
		TemplateEngine templateEngine = new TemplateEngine();
		ClassLoaderTemplateResolver resolver = new ClassLoaderTemplateResolver();
		resolver.setPrefix("/templates/");
		resolver.setSuffix(".html");
		resolver.setCharacterEncoding("UTF-8");
		resolver.setTemplateMode(TemplateMode.HTML); 
														
		templateEngine.setTemplateResolver(resolver);
		
		Context ct = new Context();
		ct.setVariable("employee", empOoj);
		String temp = templateEngine.process("employee/employee.html", ct);
		System.out.println(temp);
		System.out.println("********************************** END **********************************");
	}

}
