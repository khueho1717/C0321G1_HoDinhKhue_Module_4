package com.example.case_study_module4.model.entity;

import javax.persistence.*;

@Entity
@Table(name = "rent_type")
public class RentType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int rentTypeId;
    private String rentTypeName;
    private double rentTypeCost;

    public RentType() {
    }

    public RentType(int rentTypeId, String rentTypeName, double rentTypeCost) {
        this.rentTypeId = rentTypeId;
        this.rentTypeName = rentTypeName;
        this.rentTypeCost = rentTypeCost;
    }

    public int getRentTypeId() {
        return rentTypeId;
    }

    public void setRentTypeId(int rentTypeId) {
        this.rentTypeId = rentTypeId;
    }

    public String getRentTypeName() {
        return rentTypeName;
    }

    public void setRentTypeName(String rentTypeName) {
        this.rentTypeName = rentTypeName;
    }

    public double getRentTypeCost() {
        return rentTypeCost;
    }

    public void setRentTypeCost(double rentTypeCost) {
        this.rentTypeCost = rentTypeCost;
    }
}
