package com.example.employees.Employees.repo;

import com.example.employees.Employees.ENTITY.AddressResponse;
import com.example.employees.Employees.ENTITY.Employeeentity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientException;
import org.springframework.web.reactive.function.client.WebClientResponseException;

@Repository

public class EmployeeRepoImpl  {
    @Autowired
    Employeegetdetails employeegetdetails;

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    WebClient webClient;

    public Employeeentity getEmployeeDetails(int id ){
        Employeeentity employeeentity = employeegetdetails.findById(id).get();
        //AddressResponse addressResponse=restTemplate.getForObject("http://localhost:8080/address-app/api/getbyID/{id}", AddressResponse.class,id);
        try {
            AddressResponse addressResponse = webClient.get()
                    .uri("http://localhost:8080/address-app/api/getbyID/{id}", id)
                    .retrieve()
                    .bodyToMono(AddressResponse.class)
                    .block();
            System.out.println(addressResponse);
            employeeentity.setAddressResponse(addressResponse);
        }

        catch (WebClientResponseException.NotFound ex) {
            System.out.println("404 Not Found: " + ex.getMessage());
        }

        return employeeentity;
    }


}
