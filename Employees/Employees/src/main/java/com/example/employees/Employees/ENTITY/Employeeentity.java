package com.example.employees.Employees.ENTITY;

import jakarta.persistence.*;
import org.springframework.beans.factory.annotation.Autowired;

@Entity
@Table(name = "employee")
public class Employeeentity {
    @Id
    @Column(name = "idemployee", nullable = false)
    private int id;
    @Column(name="Name",nullable = false)
    private String name;

    @Transient
    @Autowired
    private AddressResponse addressResponse;

    public AddressResponse getAddressResponse() {
        return addressResponse;
    }

    public void setAddressResponse(AddressResponse addressResponse) {
        this.addressResponse = addressResponse;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
