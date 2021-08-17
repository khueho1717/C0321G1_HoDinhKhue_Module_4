package com.example.exam_module4.model.entity;

import javax.persistence.*;

@Entity
@Table(name = "deal")
public class Deal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idDeal;
    private String dealCode;
    @ManyToOne
    @JoinColumn(name = "id_customer",referencedColumnName = "id")
    private Customer customer;
    @Column(columnDefinition = "DATE")
    private String dateDeal;
    private int serviceType;
    private double unitPrice;
    private double areaUse;

    public Deal() {
    }

    public Deal(int idDeal, String dealCode, Customer customer, String dateDeal, int serviceType, double unitPrice, double areaUse) {
        this.idDeal = idDeal;
        this.dealCode = dealCode;
        this.customer = customer;
        this.dateDeal = dateDeal;
        this.serviceType = serviceType;
        this.unitPrice = unitPrice;
        this.areaUse = areaUse;
    }

    public int getIdDeal() {
        return idDeal;
    }

    public void setIdDeal(int idDeal) {
        this.idDeal = idDeal;
    }

    public String getDealCode() {
        return dealCode;
    }

    public void setDealCode(String dealCode) {
        this.dealCode = dealCode;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getDateDeal() {
        return dateDeal;
    }

    public void setDateDeal(String dateDeal) {
        this.dateDeal = dateDeal;
    }

    public int getServiceType() {
        return serviceType;
    }

    public void setServiceType(int serviceType) {
        this.serviceType = serviceType;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public double getAreaUse() {
        return areaUse;
    }

    public void setAreaUse(double areaUse) {
        this.areaUse = areaUse;
    }

}
