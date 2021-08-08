package com.example.case_study_module4.model.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "devision")
public class Division {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int divisionId;
    private String divisionname;
    @OneToMany(mappedBy = "divisions", cascade = CascadeType.ALL)
    private Set<Employee> employees;

    public Division() {
    }

    public Division(int divisionId, String divisionname, Set<Employee> employees) {
        this.divisionId = divisionId;
        this.divisionname = divisionname;
        this.employees = employees;
    }

    public int getDivisionId() {
        return divisionId;
    }

    public void setDivisionId(int divisionId) {
        this.divisionId = divisionId;
    }

    public String getDivisionname() {
        return divisionname;
    }

    public void setDivisionname(String divisionname) {
        this.divisionname = divisionname;
    }

    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }
}
