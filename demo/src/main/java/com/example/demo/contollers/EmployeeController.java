package com.example.demo.contollers;
import java.util.*;
import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.services.EmployeeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping()
public class EmployeeController{
	@Autowired
	private EmployeeRepository employeeRepository;
    private EmployeeService employeeService;
    public EmployeeController(EmployeeService employeeService) {
		super();
		this.employeeService = employeeService;
	}
   // public EmployeeController(){}

    @PostMapping("/api/employees")
	public List<Employee> saveEmployee(@RequestBody Employee employee){

		employeeService.saveEmployee(employee);
		System.out.println();
		return employeeService.getAllEmployees();

	}
	@GetMapping("/show")
	public List<Employee> p(){
		return employeeService.getAllEmployees();
	}
	@GetMapping("/getbyid")
	public Employee getall(@RequestParam(name="id") long id ){
		return (employeeService.getEmployeeById(id));
		
	}
	@GetMapping("/deletebyid")
	public String delete(@RequestParam(name="id")long id){
		employeeService.deleteEmployee(id);
		return "deleted";
		
	}
	@GetMapping("/getbyname")
	public ResponseEntity<List<Employee>> getbyname(@RequestParam(name="firstname")String firstname){
		return new ResponseEntity<List<Employee>>(employeeRepository.findByName(firstname),HttpStatus.OK);

	}





}