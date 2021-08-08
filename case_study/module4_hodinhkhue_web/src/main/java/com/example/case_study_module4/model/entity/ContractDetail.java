package com.example.case_study_module4.model.entity;

import javax.persistence.*;

@Entity
@Table(name = "contact_detail")
public class ContractDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int contactDetailId;
    @ManyToOne
    @JoinColumn(name = "contract_id",referencedColumnName = "contractId" )
    private Contract contract;
    @ManyToOne
    @JoinColumn(name = "attach_service_id",referencedColumnName = "attachServiceId")
    private AttachService attachService;
    private int quantity;

    public ContractDetail() {
    }

    public ContractDetail(int contactDetailId, Contract contract, AttachService attachService, int quantity) {
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
