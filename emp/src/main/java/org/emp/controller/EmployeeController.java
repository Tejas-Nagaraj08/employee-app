package org.emp.controller;

import java.util.List;

import org.emp.entity.Employee;
import org.emp.services.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {
	
	private EmployeeService employeeService;
	
	public EmployeeController(EmployeeService employeeService)
	{
		this.employeeService=employeeService;
	}
	@GetMapping("/")
	public ResponseEntity<List<Employee>> getAllEmployee()
	{
		return new ResponseEntity<>(employeeService.getAllEmployee(),HttpStatus.OK);
	}
	@GetMapping("/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable Integer id)
	{
		return new ResponseEntity<>(employeeService.getEmployeeById(id),HttpStatus.OK);
	}
	@PostMapping("/create")
	public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee)
	{
		return new ResponseEntity<>(employeeService.createEmployee(employee),HttpStatus.CREATED);
	}
	@PutMapping("/update")
	public ResponseEntity<Employee> updateEmployee(@PathVariable Integer id,@RequestBody Employee employee)
	{
		return new ResponseEntity<>(employeeService.updateEmployee(id, employee),HttpStatus.OK);
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<Employee> deleteEmployee(@PathVariable Integer id)
	{
		employeeService.deleteByEmployee(id);
	    return new ResponseEntity<>(HttpStatus.OK);
	}
}
