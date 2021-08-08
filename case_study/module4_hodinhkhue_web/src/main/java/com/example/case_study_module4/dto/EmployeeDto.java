package com.example.case_study_module4.dto;

import com.example.case_study_module4.model.entity.Division;
import com.example.case_study_module4.model.entity.EducationDegree;
import com.example.case_study_module4.model.entity.Position;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.*;

public class EmployeeDto {

    private int employeeId;
    @NotBlank(message = "yêu cầu nhâp tên nhân viên !!!")
    @Pattern(regexp = "([\\p{Lu}][\\p{Ll}]{1,8})(\\s([\\p{Lu}]|[\\p{Lu}][\\p{Ll}]{1,10})){0,5}$",
            message = "Nhập đúng định dạng tên")
    private String employeeName;
    @NotBlank(message = "ngày sinh không được để trống")
    private String employeeBirthday;
    @NotBlank(message = "yêu cầu nhập số CMND")
    @Pattern(regexp = "^\\d{9}|\\d{12}$", message = "CMND phải đúng định dạng có 9 hoặc 12 số")
    private String employeeIdCard;
    @Min(value = 0,message = "lương phải lớn hơn 0")
    private double employeeSalary;
    @NotBlank(message = "yêu cầu nhập số điẹnn thoại")
    @Pattern(regexp = "(([(]84[)][+])|0)9[01]\\d\\d\\d\\d\\d\\d\\d",message = "nhập đúng định đạng số điệ thoại (84)+ | 09[X]XXXXXXX")
    private String employeePhone;
    @NotBlank(message = "yêu cầu nhập email")
    @Email(message = "nhập đúng định dạng email")
    private String employeeEmail;
    @NotBlank(message = "yêu cầu nhập địa chỉ")
    private String employeeAddress;
    private Position position;
    private EducationDegree educationDegree;
    private Division divisions;

    public EmployeeDto() {
    }

    public EmployeeDto(int employeeId, @NotBlank(message = "yêu cầu nhâp tên nhân viên !!!") @Pattern(regexp = "([\\p{Lu}][\\p{Ll}]{1,8})(\\s([\\p{Lu}]|[\\p{Lu}][\\p{Ll}]{1,10})){0,5}$",
            message = "Nhập đúng định dạng tên") String employeeName, @NotBlank(message = "ngày sinh không được để trống") String employeeBirthday, @NotBlank(message = "yêu cầu nhập số CMND") @Pattern(regexp = "^\\d{9}|\\d{12}$", message = "CMND phải đúng định dạng có 9 hoặc 12 số") String employeeIdCard, @Min(value = 0, message = "lương phải lớn hơn 0") double employeeSalary, @NotBlank(message = "yêu cầu nhập số điẹnn thoại") @Pattern(regexp = "(([(]84[)][+])|0)9[01]\\d\\d\\d\\d\\d\\d\\d", message = "nhập đúng định đạng số điệ thoại (84)+ | 09[X]XXXXXXX") String employeePhone, @NotBlank(message = "yêu cầu nhập email") @Email(message = "nhập đúng định dạng email") String employeeEmail, @NotBlank(message = "yêu cầu nhập địa chỉ") String employeeAddress, Position position, EducationDegree educationDegree, Division divisions) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.employeeBirthday = employeeBirthday;
        this.employeeIdCard = employeeIdCard;
        this.employeeSalary = employeeSalary;
        this.employeePhone = employeePhone;
        this.employeeEmail = employeeEmail;
        this.employeeAddress = employeeAddress;
        this.position = position;
        this.educationDegree = educationDegree;
        this.divisions = divisions;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeeBirthday() {
        return employeeBirthday;
    }

    public void setEmployeeBirthday(String employeeBirthday) {
        this.employeeBirthday = employeeBirthday;
    }

    public String getEmployeeIdCard() {
        return employeeIdCard;
    }

    public void setEmployeeIdCard(String employeeIdCard) {
        this.employeeIdCard = employeeIdCard;
    }

    public double getEmployeeSalary() {
        return employeeSalary;
    }

    public void setEmployeeSalary(double employeeSalary) {
        this.employeeSalary = employeeSalary;
    }

    public String getEmployeePhone() {
        return employeePhone;
    }

    public void setEmployeePhone(String employeePhone) {
        this.employeePhone = employeePhone;
    }

    public String getEmployeeEmail() {
        return employeeEmail;
    }

    public void setEmployeeEmail(String employeeEmail) {
        this.employeeEmail = employeeEmail;
    }

    public String getEmployeeAddress() {
        return employeeAddress;
    }

    public void setEmployeeAddress(String employeeAddress) {
        this.employeeAddress = employeeAddress;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public EducationDegree getEducationDegree() {
        return educationDegree;
    }

    public void setEducationDegree(EducationDegree educationDegree) {
        this.educationDegree = educationDegree;
    }

    public Division getDivisions() {
        return divisions;
    }

    public void setDivisions(Division divisions) {
        this.divisions = divisions;
    }
}
