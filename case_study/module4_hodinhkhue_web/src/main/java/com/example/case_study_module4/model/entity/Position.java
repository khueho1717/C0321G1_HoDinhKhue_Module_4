package com.example.case_study_module4.model.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name ="positon")
public class Position {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int positionId;
    private String positonName;
    @OneToMany(mappedBy = "position", cascade = CascadeType.ALL)
    private Set<Employee> employee;

    public Position() {
    }

    public Position(int positionId, String positonName, Set<Employee> employee) {
        this.positionId = positionId;
        this.positonName = positonName;
        this.employee = employee;
    }

    public int getPositionId() {
        return positionId;
    }

    public void setPositionId(int positionId) {
        this.positionId = positionId;
    }

    public String getPositonName() {
        return positonName;
    }

    public void setPositonName(String positonName) {
        this.positonName = positonName;
    }

    public Set<Employee> getEmployee() {
        return employee;
    }

    public void setEmployee(Set<Employee> employee) {
        this.employee = employee;
    }
}
