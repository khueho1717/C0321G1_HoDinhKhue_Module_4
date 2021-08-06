package com.example.case_study_module4.dto;

import com.example.case_study_module4.model.entity.RentType;
import com.example.case_study_module4.model.entity.ServiceType;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class ServiceDto {

    private int serviceId;
    @NotNull(message = "yêu cầu nhâp mã khách hàng!!!")
    @Pattern(regexp = "^DV-\\d{4}$", message = "Chưa đúng định dạng DV-xxxx")
    private String serviceCode;
    @NotBlank(message = "vui lòng nhập tên dịch vụ")
    private String serviceName;
    @NotNull(message = "Không được để trống")
    @Min(value = 0,message = "phải lớn hơn 0")
    private int serviceArea;
    @NotNull(message = "Không được để trống")
    @Min(value = 0,message = "phải lớn hơn 0")
    private double serviceCost;
    @NotNull(message = "Không được để trống")
    @Min(value = 0,message = "phải lớn hơn 0")
    private int serviceMaxPeople;
    private RentType rentType;
    private ServiceType serviceType;
    private String standardRoom;
    private String desciptionOtherConvenience;
    @NotNull(message = "Không được để trống")
    @Min(value = 0,message = "phải lớn hơn 0")
    private double poolArea;
    @NotNull(message = "Không được để trống")
    @Min(value = 0,message = "phải lớn hơn 0")
    private int numberOfFloors;

    public ServiceDto() {
    }

    public ServiceDto(int serviceId, @NotBlank(message = "yêu cầu nhâp mã khách hàng!!!") @Pattern(regexp = "^DV-\\d{4}$", message = "Chưa đúng định dạng DV-xxxx") String serviceCode, @NotBlank(message = "vui lòng nhập tên dịch vụ") String serviceName, @NotNull(message = "Không được để trống") @Min(0) int serviceArea, @NotNull(message = "Không được để trống") @Min(0) double serviceCost, @NotNull(message = "Không được để trống") @Min(0) int serviceMaxPeople, RentType rentType, ServiceType serviceType, String standardRoom, String desciptionOtherConvenience, @NotNull(message = "Không được để trống") @Min(0) double poolArea, @NotNull(message = "Không được để trống") @Min(0) int numberOfFloors) {
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
