package com.christian.cruddemo.dao;

import com.christian.cruddemo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Repository
public class EmployeeDAOJPAImpl implements EmployeeDAO{

    EntityManager entityManager;

    @Autowired
    public EmployeeDAOJPAImpl(EntityManager theEntityManager){
        entityManager=theEntityManager;
    }

    @Override
    public List<Employee> findAll() {

        //create query
        Query theQuery=entityManager.createQuery("from Employee");

        // execute query

        List<Employee> employees=theQuery.getResultList();

        //return list
        return employees;
    }

    @Override
    public Employee getEmployeeById(int id) {
        //get employee return employee
        Employee theEmployee= entityManager.find(Employee.class,id);

        if(theEmployee==null){
            throw new RuntimeException("Employee with "+ id+ " was not found");
        }
        return theEmployee;
    }

    @Override
    public void saveEmployee(Employee theEmployee) {
        Employee dbEmployee=entityManager.merge(theEmployee);

        //update with id from db so we can get generated id for save/insert
        theEmployee.setId(dbEmployee.getId());

    }

    @Override
    public void deleteEmployeeById(int theId) {
        //edelete object with gven primary key
        Query theQuery= entityManager.createQuery("delete from Employee where id=:employeeid");
        theQuery.setParameter("employeeid",theId);
        theQuery.executeUpdate();
    }
}
