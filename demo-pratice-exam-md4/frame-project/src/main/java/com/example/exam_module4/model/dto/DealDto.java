package com.example.exam_module4.model.dto;

import com.example.exam_module4.model.entity.Customer;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;

public class DealDto implements Validator {

    private int idDeal;
    @NotBlank(message = "yêu cầu nhập mã giao dịch")
    private String dealCode;
    private Customer customer;
    private String dateDeal;
    @Min(value = 1,message = "yêu cầu chọn dịch vụ")
    private int serviceType;
    @Min(value = 1,message = "yêu cầu phải lớn hơn 0")
    private double unitPrice;
    @Min(value = 1,message = "yêu cầu phải lớn hơn 0")
    private double areaUse;

    public DealDto() {
    }

    public DealDto(int idDeal, @NotBlank(message = "yêu cầu nhập mã giao dịch") String dealCode, Customer customer, @NotBlank(message = "yêu cầu nhập ngày") String dateDeal, @Min(value = 1, message = "yêu cầu chọn dịch vụ") int serviceType, @Min(value = 1, message = "yêu cầu phải lớn hơn 0") double unitPrice, @Min(value = 1, message = "yêu cầu phải lớn hơn 0") double areaUse) {
        this.idDeal = idDeal;
        this.dealCode = dealCode;
        this.customer = customer;
        this.dateDeal = dateDeal;
        this.serviceType = serviceType;
        this.unitPrice = unitPrice;
        this.areaUse = areaUse;
    }

    public int getIdDeal() {
        return idDeal;
    }

    public void setIdDeal(int idDeal) {
        this.idDeal = idDeal;
    }

    public String getDealCode() {
        return dealCode;
    }

    public void setDealCode(String dealCode) {
        this.dealCode = dealCode;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getDateDeal() {
        return dateDeal;
    }

    public void setDateDeal(String dateDeal) {
        this.dateDeal = dateDeal;
    }

    public int getServiceType() {
        return serviceType;
    }

    public void setServiceType(int serviceType) {
        this.serviceType = serviceType;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public double getAreaUse() {
        return areaUse;
    }

    public void setAreaUse(double areaUse) {
        this.areaUse = areaUse;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        DealDto dealDto=(DealDto) target;

        if (!dealDto.dealCode.equals("")){
            if (!Pattern.matches("^MGD-\\d{4}$",dealDto.dealCode)){
                errors.rejectValue("dealCode","","Chưa đúng định dạng MGD-xxxx");
            }
        }

        java.sql.Date dateNow = new java.sql.Date(System.currentTimeMillis());
        Date dateCreate = null;

        try {
            if (dealDto.getDateDeal().equals("")) {
                errors.rejectValue("dateDeal", "", "yêu cầu chọn ngày");
            } else {
                dateCreate = new SimpleDateFormat("yyyy-MM-dd").parse(dealDto.getDateDeal());
                if (dateCreate.before(dateNow)) {
                    errors.rejectValue("dateDeal", "", "ngày giao dịch phải là ngày tương lai");
                }
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }

        if (dealDto.customer.getId()==-1){

            errors.rejectValue("customer.id","","hãy chọn tên khách hàng");

        }
    }
}
