package com.example.demo.services.impl;

import java.util.List;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.services.EmployeeService;

import org.springframework.stereotype.Service;
@Service
public  class EmployeeServiceImpl  implements EmployeeService{

	private EmployeeRepository employeeRepository;
   
	
	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		//super();
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
		
		//return(employeeRepository.getById(id));
		return employeeRepository.findById(id).orElseThrow(() -> new RuntimeException("notfound"));



	}

	@Override
	public void deleteEmployee(long id) {
		employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee", "Id", id));
		employeeRepository.deleteById(id);
		
	}


	

	

	


   
    
}
