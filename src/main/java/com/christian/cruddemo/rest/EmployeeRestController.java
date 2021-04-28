package com.christian.cruddemo.rest;

//import com.christian.cruddemo.dao.EmployeeDAO;
import com.christian.cruddemo.entity.Employee;
import com.christian.cruddemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
    

    
    // quick and dirty inject employee dao
    // private EmployeeDAO employeeDAO;
   // @Autowired
   /* public EmployeeRestController(EmployeeDAO theEmployeeDAO){
        employeeDAO=theEmployeeDAO;
    }*/

    //correct way, use service

    private EmployeeService employeeService;

    @Autowired
    public EmployeeRestController(EmployeeService theEmployeeService){
        employeeService=theEmployeeService;
    }
    
    //expose /employees endpoint toreturn all the employees
    @GetMapping("/employees")
    public List<Employee> findAll(){
        return employeeService.findAll();
    }

    //expose /employees endpoint toreturn all the employees
    @GetMapping("/employees/{employeeid}")
    public Employee getEmployeeById(@PathVariable int employeeid){
        Employee theEmployee=employeeService.getEmployeeById(employeeid);

        if(theEmployee==null){
            throw new RuntimeException("Employee not Found");
        }
        return theEmployee;
    }

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee theEmployee){
        //set id to 0 to force insert, incase they pass an id
        theEmployee.setId(0);
        employeeService.saveEmployee(theEmployee);

        return employeeService.getEmployeeById(theEmployee.getId());

    }

}
