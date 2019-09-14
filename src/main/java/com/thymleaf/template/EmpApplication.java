package com.thymleaf.template;

import java.util.ArrayList;
import java.util.List;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;

public class EmpApplication {

	public static void main(String[] args) {

		List<Employee> emp = new ArrayList<Employee>();
		emp.add(new Employee(1, "Prashant", "Pune"));
		emp.add(new Employee(2, "Nikita", "Pune"));

		TemplateEngine templateEngine = new TemplateEngine();
		ClassLoaderTemplateResolver resolver = new ClassLoaderTemplateResolver();
		resolver.setPrefix("/templates/");
		resolver.setSuffix(".html");
		resolver.setCharacterEncoding("UTF-8");
		resolver.setTemplateMode(TemplateMode.HTML); 
		
		templateEngine.setTemplateResolver(resolver);
		
		Context ct = new Context();
		ct.setVariable("employee", emp);
		String temp = templateEngine.process("employee/employee.html", ct);
		System.out.println(temp);

	}

}
