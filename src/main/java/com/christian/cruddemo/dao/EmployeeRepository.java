package com.christian.cruddemo.dao;

import com.christian.cruddemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository <Employee, Integer> {
    //finished.... all crud methods come from SpringDataJPA
}
