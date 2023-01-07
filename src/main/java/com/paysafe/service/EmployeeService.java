package com.paysafe.service;

import com.paysafe.model.Employee;
import com.paysafe.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepo employeeRepoImpl;


    public Employee registerData(Employee employee) {

        return employeeRepoImpl.save(employee);
    }
}
