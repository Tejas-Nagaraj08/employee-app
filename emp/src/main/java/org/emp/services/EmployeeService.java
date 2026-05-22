package org.emp.services;

import java.util.List;

import org.emp.entity.Employee;

public interface EmployeeService {

	List<Employee> getAllEmployee();
	Employee getEmployeeById(Integer id);
	Employee createEmployee(Employee employee);
	Employee updateEmployee(Integer id, Employee employee);
	void deleteByEmployee(Integer id);
}
