package com.christian.cruddemo.service;

import com.christian.cruddemo.entity.Employee;

import java.util.List;

public interface EmployeeService {
    public List<Employee> findAll();
    public Employee getEmployeeById( int id);
    public void saveEmployee(Employee theEmployee);
    public void deleteEmployeeById(int theId);
}
