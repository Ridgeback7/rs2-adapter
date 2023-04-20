package com.paysafe.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {

    @Id
    @GeneratedValue
    private int empId;

    private String empName;

    private double empSalary;

    private String empDob;

    //line 27 la hrishi che changes

    private String empTimePass;
    //line 29 la changed add kele

//line no 31 la issue aanane

//30 ani
    //31 la change

}
