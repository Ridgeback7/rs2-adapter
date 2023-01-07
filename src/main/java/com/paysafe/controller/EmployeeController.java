package com.paysafe.controller;

import com.paysafe.model.Employee;
import com.paysafe.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1")
public class EmployeeController {

    @Autowired
    EmployeeService employeeServiceImpl;

    @PostMapping("/registerUser")
    public ResponseEntity<Employee> registerData(@RequestBody Employee employee)
     {

       return ResponseEntity.ok( employeeServiceImpl.registerData(employee));
    }

    @GetMapping("/showdata")
    public ResponseEntity<List<Employee>> showAllData()
    {
        return ResponseEntity.ok(employeeServiceImpl.showAllData());
    }

}
