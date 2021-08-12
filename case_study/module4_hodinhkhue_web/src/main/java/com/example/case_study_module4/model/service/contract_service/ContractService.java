package com.example.case_study_module4.model.service.contract_service;

import com.example.case_study_module4.model.entity.Contract;
import com.example.case_study_module4.model.entity.ContractDetail;
import com.example.case_study_module4.model.repository.contact_repository.IContactRepository;
import com.example.case_study_module4.model.repository.contact_repository.IContractDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContractService implements IContractService {

    @Autowired
    IContactRepository contactRepository;
    @Autowired
    IContractDetailRepository contractDetailRepository;

    @Override
    public Iterable<Contract> findAll() {
        return contactRepository.findAll();
    }

    @Override
    public Optional<Contract> findById(int id) {
        return contactRepository.findById(id);
    }

    @Override
    public void save(Contract contract) {
        contactRepository.save(contract);
    }

    @Override
    public void remove(int id) {
        contactRepository.deleteById(id);
    }

    @Override
    public void totalMoney() {
        List<ContractDetail> contractDetails = contractDetailRepository.findAll();
        List<Contract> contracts = contactRepository.findAll();

        for (Contract contract : contracts) {
            Double totalMoney = contract.getService().getServiceCost();
            for (ContractDetail contractDetail : contractDetails) {
                if (contractDetail.getContract().equals(contract)) {
                    totalMoney += contractDetail.getQuantity() * contractDetail.getAttachService().getAttachServiceCost();
                }
            }
            contract.setContractTotalMoney(totalMoney);
            contactRepository.save(contract);
        }
    }
}
