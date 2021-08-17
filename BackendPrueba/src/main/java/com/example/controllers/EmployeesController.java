package com.example.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Employee;
import com.example.service.EmployeesService;

@RestController
@CrossOrigin(origins="*")
public class EmployeesController {

	@Autowired
	private EmployeesService service;
	
	@GetMapping(value="/employees", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Employee> employees(){		
		return service.listOfEmployees();
	}
	
	@GetMapping(value="/employee/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Employee searchEmployee(@PathVariable("id") int id) {
		return service.searchEmployee(id);
	}
	
	
}
