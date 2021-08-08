package com.example.case_study_module4.dto;

import com.example.case_study_module4.model.entity.AttachService;
import com.example.case_study_module4.model.entity.Contract;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Min;

public class ContractDetailDto {

    private int contactDetailId;
    private Contract contract;
    private AttachService attachService;
    @Min(value = 0,message = "số lượng phải lớn hơn 0")
    private int quantity;

    public ContractDetailDto() {
    }

    public ContractDetailDto(int contactDetailId, Contract contract, AttachService attachService, @Min(value = 0, message = "số lượng phải lớn hơn 0") int quantity) {
        this.contactDetailId = contactDetailId;
        this.contract = contract;
        this.attachService = attachService;
        this.quantity = quantity;
    }

    public int getContactDetailId() {
        return contactDetailId;
    }

    public void setContactDetailId(int contactDetailId) {
        this.contactDetailId = contactDetailId;
    }

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }

    public AttachService getAttachService() {
        return attachService;
    }

    public void setAttachService(AttachService attachService) {
        this.attachService = attachService;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
