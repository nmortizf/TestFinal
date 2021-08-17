package com.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.spy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.model.Employee;
import com.example.service.EmployeesServiceImpl;

@SpringBootTest
class BackendPruebaApplicationTests {
	
	private static final Logger log = LoggerFactory.getLogger(BackendPruebaApplicationTests.class);

	@Mock
	private Employee employee;
	
	@Autowired
	private EmployeesServiceImpl employeesService;
	
	@BeforeEach
	void setup() {
		employee = spy(Employee.class);
	}
	
	@Test
	void prueba1() {
		//given
		employee.setId(1);
		employee.setEmployeeName("Tiger Nixon");
		employee.setEmployeeSalary(320800);
		employee.setEmployeeAge(61);
		employee.setAnualEmployeeSalary(employee.getEmployeeSalary() * 12);
		int expectedAnnualSalary = employee.getAnualEmployeeSalary();
		//when
		Employee employee2 = employeesService.searchEmployee(1);
		log.info("El salario esperado es {}",expectedAnnualSalary);
		int annualSalary = employee2.getAnualEmployeeSalary();
		log.info("El salario calculado al consumir el servicio es {}",annualSalary);
		//then
		assertEquals(expectedAnnualSalary,annualSalary);
	}

}
