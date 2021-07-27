package com.validateform.dto;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.*;

public class UserDto {
    private Long id;
    @NotBlank(message = "Ten khong duoc de trong")
    @Size(min = 5, max = 45,message = "do dai ten phai it nhat 5 ki tu, nhieu nhat 45 ki tu")
    private String firstName;
    @NotBlank(message = "Ten dem khong duoc de trong")
    @Size(min = 5, max = 45,message = "do dai ten phai it nhat 5 ki tu, nhieu nhat 45 ki tu")
    private String lastName;
    @Min(18)
    private int age;
    @NotBlank(message = "khong duoc de trong")
    @Pattern(regexp = "(^[0-9]{10}$)",message = "nhap chua dung dinh dang")
    private String numberPhone;
    @NotBlank(message = "Email khong duoc de trong")
    @Email(message = "chua dung dinh dang email")
    private String email;

    public UserDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getNumberPhone() {
        return numberPhone;
    }

    public void setNumberPhone(String numberPhone) {
        this.numberPhone = numberPhone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
