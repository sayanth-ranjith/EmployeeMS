package com.example.employees.Employees.EmployeeController;

import com.example.employees.Employees.ENTITY.Employeeentity;
import com.example.employees.Employees.repo.EmployeeRepoImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@ResponseBody
public class EmployeeController {


    @Autowired
    EmployeeRepoImpl employeeRepoImpl;

    private final ObjectMapper objectMapper = new ObjectMapper();

    @GetMapping("/getValues/{id}")
    public Employeeentity getEmployeeDetails(@PathVariable ("id") int id){
        Employeeentity employeeentity= employeeRepoImpl.getEmployeeDetails(id);
        return employeeentity;

    }

    @GetMapping("/welcome")
    public String welcome(){
        return "WELCOME WORLD!";
    }

}
