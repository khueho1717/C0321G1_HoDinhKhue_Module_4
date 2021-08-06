package com.example.case_study_module4.model.entity;

import org.springframework.web.bind.annotation.Mapping;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "customer_type")
public class CustomerType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String typeName;

    @OneToMany(mappedBy = "customerType")
    List<Customer> customerlist;

    public CustomerType() {
    }

    public CustomerType(int id, String typeName, List<Customer> customerlist) {
        this.id = id;
        this.typeName = typeName;
        this.customerlist = customerlist;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public List<Customer> getCustomerlist() {
        return customerlist;
    }

    public void setCustomerlist(List<Customer> customerlist) {
        this.customerlist = customerlist;
    }
}
