package com.example.service;

import java.util.List;

import com.example.model.Employee;

public interface EmployeesService {

	public List<Employee> listOfEmployees();
	
	public Employee searchEmployee(int id);
	
	
}
