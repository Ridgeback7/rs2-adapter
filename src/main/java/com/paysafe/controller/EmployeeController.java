package com.paysafe.controller;

import com.paysafe.model.Employee;
import com.paysafe.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v1")
public class EmployeeController {

    @Autowired
    EmployeeService employeeServiceImpl;

    @PostMapping("/registerUser")
    public ResponseEntity<Employee> registerData(@RequestBody Employee employee) {

        return ResponseEntity.ok(employeeServiceImpl.registerData(employee));
    }
    //me kahi vishesh changes kele nahi aahet


    @GetMapping("/showdata")
    public ResponseEntity<List<Employee>> showAllData() {
        return ResponseEntity.ok(employeeServiceImpl.showAllData());
    }

    @DeleteMapping("/deleteDataById/{empId}")
    public ResponseEntity<String> deleteDataBqqyId(@PathVariable int empId) {
        employeeServiceImpl.deleteById(empId);
        return ResponseEntity.ok("Data Deleted Successfully");
    }

    //dfgdghjkubnyjb
    @PutMapping("/updateDataById/{empId}")
    public ResponseEntity<String> updateDataById(@PathVariable int empId, @RequestBody Employee employee) {
        return ResponseEntity.ok("data updated successfully");
    }

    @GetMapping("/getbyrefid/{empId}")
    public ResponseEntity<List<String>> getTranactionDetailsByRefId(@PathVariable int empId) {
        List<String> sl = new ArrayList<>();
        sl.add("1");
        sl.add("2");
        sl.add("3");
        sl.add("4");
        return ResponseEntity.ok(sl);
    }

//geetu che changes ad kele
}
