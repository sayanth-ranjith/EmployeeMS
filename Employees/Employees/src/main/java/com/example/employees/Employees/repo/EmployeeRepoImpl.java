package com.example.employees.Employees.repo;

import com.example.employees.Employees.ENTITY.AddressResponse;
import com.example.employees.Employees.ENTITY.Employeeentity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

@Repository

public class EmployeeRepoImpl  {
    @Autowired
    Employeegetdetails employeegetdetails;

    @Autowired
    RestTemplate restTemplate;

    public Employeeentity getEmployeeDetails(int id ){
        Employeeentity employeeentity = employeegetdetails.findById(id).get();


        AddressResponse addressResponse=restTemplate.getForObject("http://localhost:8080/address-app/api/getbyID/{id}", AddressResponse.class,id);
        System.out.println(addressResponse);
        employeeentity.setAddressResponse(addressResponse);
         return employeeentity;
    }


}
