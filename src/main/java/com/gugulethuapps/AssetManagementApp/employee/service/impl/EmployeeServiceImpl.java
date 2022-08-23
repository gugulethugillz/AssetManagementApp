package com.gugulethuapps.AssetManagementApp.employee.service.impl;

import java.util.List;
import java.util.Optional;

import com.gugulethuapps.AssetManagementApp.employee.model.Employee;
import com.gugulethuapps.AssetManagementApp.employee.repository.EmployeeRepository;
import com.gugulethuapps.AssetManagementApp.employee.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@Slf4j
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
		
	private final EmployeeRepository employeeRepository;

	public List<Employee> findAll(){
		return employeeRepository.findAll();
	}	

	public Optional<Employee> findById(int id) {
		return employeeRepository.findById(id);
	}	

	public void delete(int id) {
		employeeRepository.deleteById(id);
	}

	public void save( Employee employee) {
		employeeRepository.save(employee);
	}
	public Employee findByUsername(String un) {
		return employeeRepository.findByUsername(un);
	}
}
