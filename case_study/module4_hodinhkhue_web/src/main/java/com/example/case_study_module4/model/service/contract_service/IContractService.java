package com.example.case_study_module4.model.service.contract_service;

import com.example.case_study_module4.model.entity.Contract;
import com.example.case_study_module4.model.service.GeneralService;

public interface IContractService extends GeneralService<Contract> {
    void totalMoney();
}
