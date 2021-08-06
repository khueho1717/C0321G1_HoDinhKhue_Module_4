package com.example.case_study_module4.model.entity;

import javax.persistence.*;

@Entity
@Table(name = "service_type")
public class ServiceType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int serviceTypeId;
    private String serviceTypeName;

    public ServiceType() {
    }

    public ServiceType(int serviceTypeId, String serviceTypeName) {
        this.serviceTypeId = serviceTypeId;
        this.serviceTypeName = serviceTypeName;
    }

    public int getServiceTypeId() {
        return serviceTypeId;
    }

    public void setServiceTypeId(int serviceTypeId) {
        this.serviceTypeId = serviceTypeId;
    }

    public String getServiceTypeName() {
        return serviceTypeName;
    }

    public void setServiceTypeName(String serviceTypeName) {
        this.serviceTypeName = serviceTypeName;
    }
}
