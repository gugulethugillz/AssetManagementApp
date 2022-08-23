package com.gugulethuapps.AssetManagementApp.employee.service;

import com.gugulethuapps.AssetManagementApp.employee.model.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    List<Employee> findAll();

    public Optional<Employee> findById(int id);

    public void delete(int id);

    public void save( Employee employee);
    public Employee findByUsername(String un);
}
