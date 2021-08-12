package com.example.case_study_module4.dto;

import com.example.case_study_module4.model.entity.CustomerType;
import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.*;
import javax.validation.constraints.*;

public class CustomerDto {
    private int customerId;
    @NotBlank(message = "yêu cầu nhâp mã khách hàng!!!")
    @Pattern(regexp = "^KH-\\d{4}$", message = "Chưa đúng định dạng KH-xxxx")
    private String customerCode;
    private CustomerType customerType;
    @NotBlank(message = "yêu cầu nhâp tên khách hàng!!!")
    @Pattern(regexp = "([\\p{Lu}][\\p{Ll}]{1,8})(\\s([\\p{Lu}]|[\\p{Lu}][\\p{Ll}]{1,10})){0,5}$",
            message = "Nhập đúng định dạng tên")
    private String customerName;
    @NotBlank(message = "ngày sinh không được để trống")
    private String customerBirthday;
    private byte customerGender;
    @NotBlank(message = "yêu cầu nhập số CMND")
    @Pattern(regexp = "^\\d{9}|\\d{12}$", message = "CMND phải đúng định dạng có 9 hoặc 12 số")
    private String customerIdCard;
    @NotBlank(message = "yêu cầu nhập số điẹnn thoại")
    @Pattern(regexp = "(([(]84[)][+])|0)9[01]\\d\\d\\d\\d\\d\\d\\d",message = "nhập đúng định đạng số điệ thoại (84)+ | 09[X]XXXXXXX")
    private String customerPhone;
    @NotBlank(message = "yêu cầu nhập email")
    @Email(message = "yêu cầu nhập đúng định dạng email")
    private String customerEmail;
    @NotBlank(message = "yêu cầu nhập địa chỉ")
    private String customerAddress;

    public CustomerDto() {
    }

    public CustomerDto(int customerId, @NotBlank(message = "yêu cầu nhâp mã khách hàng!!!") @Pattern(regexp = "^KH-\\d{4}$", message = "Chưa đúng định dạng KH-xxxx") String customerCode, CustomerType customerType, @NotBlank(message = "yêu cầu nhâp tên khách hàng!!!") @Pattern(regexp = "([\\p{Lu}][\\p{Ll}]{1,8})(\\s([\\p{Lu}]|[\\p{Lu}][\\p{Ll}]{1,10})){0,5}$",
            message = "Nhập đúng định dạng tên") String customerName, @NotBlank(message = "ngày sinh không được để trống") @Past(message = "yêu cầu nhập đúng ngày sinh") String customerBirthday, byte customerGender, @NotBlank(message = "yêu cầu nhập số CMND") @Pattern(regexp = "^\\d{9}|\\d{12}$", message = "CMND phải đúng định dạng có 9 hoặc 12 số") String customerIdCard, @NotBlank(message = "yêu cầu nhập số điẹnn thoại") @Pattern(regexp = "(([(]84[)][+])|0)9[01]\\d\\d\\d\\d\\d\\d\\d", message = "nhập đúng định đạng số điệ thoại (84)+ | 09[X]XXXXXXX") String customerPhone, @NotBlank(message = "yêu cầu nhập email") @Email(message = "yêu cầu nhập đúng định dạng email") String customerEmail, @NotBlank(message = "yêu cầu nhập địa chỉ") String customerAddress) {
        this.customerId = customerId;
        this.customerCode = customerCode;
        this.customerType = customerType;
        this.customerName = customerName;
        this.customerBirthday = customerBirthday;
        this.customerGender = customerGender;
        this.customerIdCard = customerIdCard;
        this.customerPhone = customerPhone;
        this.customerEmail = customerEmail;
        this.customerAddress = customerAddress;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
    }

    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerBirthday() {
        return customerBirthday;
    }

    public void setCustomerBirthday(String customerBirthday) {
        this.customerBirthday = customerBirthday;
    }

    public byte getCustomerGender() {
        return customerGender;
    }

    public void setCustomerGender(byte customerGender) {
        this.customerGender = customerGender;
    }

    public String getCustomerIdCard() {
        return customerIdCard;
    }

    public void setCustomerIdCard(String customerIdCard) {
        this.customerIdCard = customerIdCard;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }
}
