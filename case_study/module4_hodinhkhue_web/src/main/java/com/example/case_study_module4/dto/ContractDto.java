package com.example.case_study_module4.dto;

import com.example.case_study_module4.model.entity.Customer;
import com.example.case_study_module4.model.entity.Employee;
import com.example.case_study_module4.model.entity.Service;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

public class ContractDto {

    private int contractId;
    @NotBlank(message = "yêu cầu nhập ngày bắt đầu")
    private String contractStartDate;
    @NotBlank(message = "yêu cầu nhập ngày bắt đầu")
    private String contractEndDate;
    @Min(value = 0,message = "tiền đặt cọc phải lớn hơn 0")
    private double contractDeposit;
    @Min(value = 0,message = "tổng tiền phải lớn hơn 0")
    private double contractTotalMoney;
    private Employee employee;
    private Customer customer;
    private Service service;

    public ContractDto() {
    }

    public ContractDto(int contractId, @NotBlank(message = "yêu cầu nhập ngày bắt đầu") String contractStartDate, @NotBlank(message = "yêu cầu nhập ngày bắt đầu") String contractEndDate, @Min(value = 0, message = "tiền đặt cọc phải lớn hơn 0") double contractDeposit, @Min(value = 0, message = "tổng tiền phải lớn hơn 0") double contractTotalMoney, Employee employee, Customer customer, Service service) {
        this.contractId = contractId;
        this.contractStartDate = contractStartDate;
        this.contractEndDate = contractEndDate;
        this.contractDeposit = contractDeposit;
        this.contractTotalMoney = contractTotalMoney;
        this.employee = employee;
        this.customer = customer;
        this.service = service;
    }

    public int getContractId() {
        return contractId;
    }

    public void setContractId(int contractId) {
        this.contractId = contractId;
    }

    public String getContractStartDate() {
        return contractStartDate;
    }

    public void setContractStartDate(String contractStartDate) {
        this.contractStartDate = contractStartDate;
    }

    public String getContractEndDate() {
        return contractEndDate;
    }

    public void setContractEndDate(String contractEndDate) {
        this.contractEndDate = contractEndDate;
    }

    public double getContractDeposit() {
        return contractDeposit;
    }

    public void setContractDeposit(double contractDeposit) {
        this.contractDeposit = contractDeposit;
    }

    public double getContractTotalMoney() {
        return contractTotalMoney;
    }

    public void setContractTotalMoney(double contractTotalMoney) {
        this.contractTotalMoney = contractTotalMoney;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }
}
