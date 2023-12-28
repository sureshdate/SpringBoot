package net.javaguide.springboot.service;



import java.util.List;

import net.javaguide.springboot.model.Employee;

public interface EmployeeService {
	Employee saveEmployee(Employee employee);
	
	List<Employee> getAllEmployees();
	
	Employee getEmployeeById(long id);
	
	Employee updateEmployee(Employee employee, long id);
	
	void deleteEmployee(long id);
}