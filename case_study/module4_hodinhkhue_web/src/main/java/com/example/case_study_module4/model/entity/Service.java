package com.example.case_study_module4.model.entity;

import javax.persistence.*;

@Entity
@Table(name = "service")
public class Service {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int serviceId;
    private String serviceCode;
    private String serviceName;
    private int serviceArea;
    private double serviceCost;
    private int serviceMaxPeople;
    @ManyToOne
    @JoinColumn(name = "rent_type_id",referencedColumnName = "rentTypeId")
    private RentType rentType;
    @ManyToOne
    @JoinColumn(name = "service_type_id",referencedColumnName = "serviceTypeId")
    private ServiceType serviceType;
    private String standardRoom;
    private String desciptionOtherConvenience;
    private double poolArea;
    private int numberOfFloors;

    public Service() {
    }

    public Service(int serviceId, String serviceCode, String serviceName, int serviceArea, double serviceCost, int serviceMaxPeople, RentType rentType, ServiceType serviceType, String standardRoom, String desciptionOtherConvenience, double poolArea, int numberOfFloors) {
        this.serviceId = serviceId;
        this.serviceCode = serviceCode;
        this.serviceName = serviceName;
        this.serviceArea = serviceArea;
        this.serviceCost = serviceCost;
        this.serviceMaxPeople = serviceMaxPeople;
        this.rentType = rentType;
        this.serviceType = serviceType;
        this.standardRoom = standardRoom;
        this.desciptionOtherConvenience = desciptionOtherConvenience;
        this.poolArea = poolArea;
        this.numberOfFloors = numberOfFloors;
    }

    public int getServiceId() {
        return serviceId;
    }

    public void setServiceId(int serviceId) {
        this.serviceId = serviceId;
    }

    public String getServiceCode() {
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        this.serviceCode = serviceCode;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public int getServiceArea() {
        return serviceArea;
    }

    public void setServiceArea(int serviceArea) {
        this.serviceArea = serviceArea;
    }

    public double getServiceCost() {
        return serviceCost;
    }

    public void setServiceCost(double serviceCost) {
        this.serviceCost = serviceCost;
    }

    public int getServiceMaxPeople() {
        return serviceMaxPeople;
    }

    public void setServiceMaxPeople(int serviceMaxPeople) {
        this.serviceMaxPeople = serviceMaxPeople;
    }

    public RentType getRentType() {
        return rentType;
    }

    public void setRentType(RentType rentType) {
        this.rentType = rentType;
    }

    public ServiceType getServiceType() {
        return serviceType;
    }

    public void setServiceType(ServiceType serviceType) {
        this.serviceType = serviceType;
    }

    public String getStandardRoom() {
        return standardRoom;
    }

    public void setStandardRoom(String standardRoom) {
        this.standardRoom = standardRoom;
    }

    public String getDesciptionOtherConvenience() {
        return desciptionOtherConvenience;
    }

    public void setDesciptionOtherConvenience(String desciptionOtherConvenience) {
        this.desciptionOtherConvenience = desciptionOtherConvenience;
    }

    public double getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(double poolArea) {
        this.poolArea = poolArea;
    }

    public int getNumberOfFloors() {
        return numberOfFloors;
    }

    public void setNumberOfFloors(int numberOfFloors) {
        this.numberOfFloors = numberOfFloors;
    }
}
