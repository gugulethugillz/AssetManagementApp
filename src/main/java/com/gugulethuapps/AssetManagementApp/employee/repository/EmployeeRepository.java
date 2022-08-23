package com.gugulethuapps.AssetManagementApp.employee.repository;

import com.gugulethuapps.AssetManagementApp.employee.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	
	public Employee findByUsername(String un);
}
