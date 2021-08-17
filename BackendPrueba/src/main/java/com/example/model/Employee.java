package com.example.model;

public class Employee {
	
	private int id;
	private String employeeName;
	private int employeeSalary;
	private int employeeAge;
	private int anualEmployeeSalary;

	public Employee() {
	}

	public Employee(int id, String employeeName, int employeeSalary, int employeeAge) {
		this.id = id;
		this.employeeName = employeeName;
		this.employeeSalary = employeeSalary;
		this.employeeAge = employeeAge;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public int getEmployeeSalary() {
		return employeeSalary;
	}

	public void setEmployeeSalary(int employeeSalary) {
		this.employeeSalary = employeeSalary;
	}

	public int getEmployeeAge() {
		return employeeAge;
	}

	public void setEmployeeAge(int employeeAge) {
		this.employeeAge = employeeAge;
	}

	public int getAnualEmployeeSalary() {
		return anualEmployeeSalary;
	}

	public void setAnualEmployeeSalary(int anualEmployeeSalary) {
		this.anualEmployeeSalary = anualEmployeeSalary;
	}
		
}
