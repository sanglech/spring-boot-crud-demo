package com.christian.cruddemo.dao;

import com.christian.cruddemo.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    public List<Employee> findAll();
    public Employee getEmployeeById( int id);
    public void saveEmployee(Employee theEmployee);
    public void deleteEmployeeById(int theId);

}
