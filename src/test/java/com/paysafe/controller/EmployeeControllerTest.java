package com.paysafe.controller;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.paysafe.model.Employee;
import com.paysafe.service.EmployeeService;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ContextConfiguration(classes = {EmployeeController.class})
@ExtendWith(SpringExtension.class)
class EmployeeControllerTest {
    @Autowired
    private EmployeeController employeeController;

    @MockBean
    private EmployeeService employeeService;

    /**
     * Method under test: {@link EmployeeController#deleteDataById(int)}
     */
    @Test
    void testDeleteDataById() throws Exception {
        doNothing().when(employeeService).deleteById(anyInt());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/v1/deleteDataById/{empId}", 123);
        MockMvcBuilders.standaloneSetup(employeeController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
                .andExpect(MockMvcResultMatchers.content().string("Data Deleted Successfully"));
    }

    /**
     * Method under test: {@link EmployeeController#registerData(Employee)}
     */
    @Test
    void testRegisterData() throws Exception {
        Employee employee = new Employee();
        employee.setEmpId(123);
        employee.setEmpName("Emp Name");
        employee.setEmpSalary(10.0d);
        when(employeeService.registerData((Employee) any())).thenReturn(employee);

        Employee employee1 = new Employee();
        employee1.setEmpId(123);
        employee1.setEmpName("Emp Name");
        employee1.setEmpSalary(10.0d);
        String content = (new ObjectMapper()).writeValueAsString(employee1);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/v1/registerUser")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(employeeController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(
                        MockMvcResultMatchers.content().string("{\"empId\":123,\"empName\":\"Emp Name\",\"empSalary\":10.0}"));
    }

    /**
     * Method under test: {@link EmployeeController#showAllData()}
     */
    @Test
    void testShowAllData() throws Exception {
        when(employeeService.showAllData()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/v1/showdata");
        MockMvcBuilders.standaloneSetup(employeeController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Method under test: {@link EmployeeController#showAllData()}
     */
    @Test
    void testShowAllData2() throws Exception {
        when(employeeService.showAllData()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/v1/showdata");
        getResult.characterEncoding("Encoding");
        MockMvcBuilders.standaloneSetup(employeeController)
                .build()
                .perform(getResult)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Method under test: {@link EmployeeController#deleteDataById(int)}
     */
    @Test
    void testDeleteDataById2() throws Exception {
        doNothing().when(employeeService).deleteById(anyInt());
        MockHttpServletRequestBuilder deleteResult = MockMvcRequestBuilders.delete("/v1/deleteDataById/{empId}", 123);
        deleteResult.characterEncoding("Encoding");
        MockMvcBuilders.standaloneSetup(employeeController)
                .build()
                .perform(deleteResult)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
                .andExpect(MockMvcResultMatchers.content().string("Data Deleted Successfully"));
    }

    /**
     * Method under test: {@link EmployeeController#getTranactionDetailsByRefId(int)}
     */
    @Test
    void testGetTranactionDetailsByRefId() throws Exception {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/v1/getbyrefid/*");
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(employeeController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().is(500));
    }

    /**
     * Method under test: {@link EmployeeController#updateDataById(int, Employee)}
     */
    @Test
    void testUpdateDataById() throws Exception {
        Employee employee = new Employee();
        employee.setEmpId(123)
        employee.setEmpName("Emp Name");
        employee.setEmpSalary(10.0d);
        String content = (new ObjectMapper()).writeValueAsString(employee);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.put("/v1/updateDataById/{empId}", 123)
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(employeeController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
                .andExpect(MockMvcResultMatchers.content().string("data updated successfully"));
    }
}

