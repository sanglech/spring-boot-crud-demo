package com.christian.cruddemo.service;

import com.christian.cruddemo.dao.EmployeeDAO;
import com.christian.cruddemo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    private EmployeeDAO employeeDAO;

    //beanid is class name starting with lowercase
    //tells spring which bean to use
    @Autowired
    public EmployeeServiceImpl(@Qualifier("employeeDAOJPAImpl") EmployeeDAO theEmployeeDAO){
        employeeDAO=theEmployeeDAO;
    }
    @Override
    @Transactional
    public List<Employee> findAll() {
        return employeeDAO.findAll();
    }

    @Override
    @Transactional
    public Employee getEmployeeById(int id) {
        return employeeDAO.getEmployeeById(id);
    }

    @Override
    @Transactional
    public void saveEmployee(Employee theEmployee) {
        employeeDAO.saveEmployee(theEmployee);
    }

    @Override
    @Transactional
    public void deleteEmployeeById(int theId) {
        employeeDAO.deleteEmployeeById(theId);
    }
}
