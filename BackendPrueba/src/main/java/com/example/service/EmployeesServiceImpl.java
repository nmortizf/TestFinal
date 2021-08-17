package com.example.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.dto.Data;
import com.example.model.Employee;
import com.example.model.ResponseThales;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class EmployeesServiceImpl implements EmployeesService {

	private static final Logger log = LoggerFactory.getLogger(EmployeesServiceImpl.class);

	@Autowired
	private RestTemplate template;

    private static final String URL = "http://dummy.restapiexample.com/api/v1/";

	@Override
	@Cacheable("employees")
	public List<Employee> listOfEmployees() {		
		List<Employee> employees = new ArrayList<>();		
		ResponseEntity<ResponseThales> responseEntity = template.getForEntity(URL + "employees", ResponseThales.class);		
		ResponseThales bodyResponse= responseEntity.getBody();		
		List<Data> employeesResponse = bodyResponse.getData();		
		for (int i = 0; i < employeesResponse.size(); i++) {
			Employee employee = new Employee();
			employee.setId(employeesResponse.get(i).getId());
			employee.setEmployeeName(employeesResponse.get(i).getEmployee_name());
			employee.setEmployeeSalary(employeesResponse.get(i).getEmployee_salary());
			employee.setEmployeeAge(employeesResponse.get(i).getEmployee_age());
			employee.setAnualEmployeeSalary((calculateAnualSalary(employee.getEmployeeSalary())));
			employees.add(employee);
		}			
		return employees;
	}	
	
	@Override
	@Cacheable("employeeId")
	public Employee searchEmployee(int id) {
		ResponseEntity<String> responseEntity = template.getForEntity(URL + "employee/{id}", String.class,id);
		Employee employee = new Employee();
		String body = responseEntity.getBody();
		ObjectMapper mapper = new ObjectMapper();		  
		JsonNode actualObj;
		try {
			actualObj = mapper.readTree(body);
			JsonNode jsonNode1 = actualObj.get("data");
			employee.setId(jsonNode1.get("id").asInt());
			employee.setEmployeeName(jsonNode1.get("employee_name").asText());
			employee.setEmployeeAge(jsonNode1.get("employee_age").asInt());
			employee.setEmployeeSalary(jsonNode1.get("employee_salary").asInt());
			employee.setAnualEmployeeSalary(calculateAnualSalary(employee.getEmployeeSalary()));
		} catch (JsonProcessingException e) {
			log.error("Exception Details: {}", e);
		}  
		return employee;
	}
	
	private int calculateAnualSalary(int monthSalary) {
		return monthSalary *12;
	}	

}
