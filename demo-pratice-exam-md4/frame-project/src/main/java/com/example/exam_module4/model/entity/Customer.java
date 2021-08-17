package com.example.exam_module4.model.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "customer_deal")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nameCustomer;
    private String numberPhone;
    private String emailCustomer;
    @OneToMany(mappedBy = "customer")
    private List<Deal> deals;

    public Customer() {
    }

    public Customer(int id, String nameCustomer, String numberPhone, String emailCustomer, List<Deal> deals) {
        this.id = id;
        this.nameCustomer = nameCustomer;
        this.numberPhone = numberPhone;
        this.emailCustomer = emailCustomer;
        this.deals = deals;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameCustomer() {
        return nameCustomer;
    }

    public void setNameCustomer(String nameCustomer) {
        this.nameCustomer = nameCustomer;
    }

    public String getNumberPhone() {
        return numberPhone;
    }

    public void setNumberPhone(String numberPhone) {
        this.numberPhone = numberPhone;
    }

    public String getEmailCustomer() {
        return emailCustomer;
    }

    public void setEmailCustomer(String emailCustomer) {
        this.emailCustomer = emailCustomer;
    }

    public List<Deal> getDeals() {
        return deals;
    }

    public void setDeals(List<Deal> deals) {
        this.deals = deals;
    }
}
