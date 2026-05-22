package org.emp.services;

import java.util.List;

import org.emp.entity.Employee;
import org.emp.repository.EmployeeRepository;
import org.springframework.stereotype.Service;
@Service
public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeRepository employeeRepository;
	
	public EmployeeServiceImpl(EmployeeRepository employeeRepository)
	{
		this.employeeRepository=employeeRepository;
	}
	@Override
	public List<Employee> getAllEmployee() {
		return employeeRepository.findAll();
	}

	@Override
	public Employee getEmployeeById(Integer id) {
		return employeeRepository.findById(id).
				orElseThrow(()->new RuntimeException(id+"is not found "));
	}

	@Override
	public Employee createEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

	@Override
	public Employee updateEmployee(Integer id, Employee employee) {
		Employee emp=employeeRepository.findById(id).
				orElseThrow(()->new RuntimeException(id+"is not found "));
		return employeeRepository.save(emp);
	}

	@Override
	public void deleteByEmployee(Integer id) {
		Employee emp=employeeRepository.findById(id).
				orElseThrow(()->new RuntimeException(id+"is not found "));
		employeeRepository.deleteById(emp.getId());
	}

}
