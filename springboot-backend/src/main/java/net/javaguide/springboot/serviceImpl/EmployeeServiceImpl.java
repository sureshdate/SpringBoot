package net.javaguide.springboot.serviceImpl;



import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import net.javaguide.springboot.exception.ResourceNotFoundException;
import net.javaguide.springboot.model.Employee;
import net.javaguide.springboot.repository.EmployeeRepository;
import net.javaguide.springboot.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	private EmployeeRepository employeeRepository;
	
	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		super();
		this.employeeRepository = employeeRepository;
	}

	@Override
	public Employee saveEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}
    
	@Override
	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();
		
	}
	

	  
	@Override
	public Employee getEmployeeById(long id) {
		Optional<Employee> employee=employeeRepository.findById(id);
		if(employee.isPresent()) {
			return employee.get();
		}
		else {
			throw new ResourceNotFoundException("Employee", "Id", id);
		}
		//or by using lambda expression
		
	//	return employeeRepository.findById(id).orElseThrow(() -> 
		//new ResourceNotFoundException("Employee", "Id", id));
	}
    
	@Override
	public Employee updateEmployee(Employee employee,long id) {
		// we need to check whether employee with given id is exist in DB or not
		Employee existingEmployee=employeeRepository.findById(id).orElseThrow(
				()->new ResourceNotFoundException("Employee","id",id));
		
		existingEmployee.setFirstName(employee.getFirstName());
		existingEmployee.setLastName(employee.getLastName());
		existingEmployee.setEmail(employee.getEmail());
		employeeRepository.save(existingEmployee);
		return existingEmployee;
	}

	
	public void deleteEmployee(long id) {
		
		// check whether a employee exist in a DB or not
		employeeRepository.findById(id).orElseThrow(() -> 
								new ResourceNotFoundException("Employee", "Id", id));
		employeeRepository.deleteById(id);
	}
	
}