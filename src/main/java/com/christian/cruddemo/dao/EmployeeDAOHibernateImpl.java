package com.christian.cruddemo.dao;

import com.christian.cruddemo.entity.Employee;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class EmployeeDAOHibernateImpl implements EmployeeDAO {

    //define field for entity manager
    private EntityManager entityManager;

    //setup constructor injection
    @Autowired
    public EmployeeDAOHibernateImpl(EntityManager theEntityManager){
        entityManager=theEntityManager;
    }


    @Override
    @Transactional
    public List<Employee> findAll() {
        //get the hibernate session
        Session currentSession=entityManager.unwrap(Session.class);
        //create query
        Query<Employee> theQuery= currentSession.createQuery("from Employee",Employee.class);

        // execute query et result list
        List<Employee> employees=theQuery.getResultList();

        // return list
        return employees;
    }
}
