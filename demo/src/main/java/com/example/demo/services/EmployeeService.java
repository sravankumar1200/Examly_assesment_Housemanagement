package com.example.demo.services;


import com.example.demo.model.Employee;

import java.util.*;

public interface EmployeeService {

   
    Employee saveEmployee(Employee employee);
	List<Employee> getAllEmployees();
	
	Employee getEmployeeById(long id);
	
	/*Employee updateEmployee(Employee employee, long id);*/
	void deleteEmployee(long id);
	//Employee getbyname(String firstname);
	//List<Employee> findByname(String firstname);
	
	
	
}
