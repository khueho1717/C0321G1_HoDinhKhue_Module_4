package com.manager_phone.model.repository;

import com.manager_phone.model.entity.SmartPhone;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISmartphoneRepository extends PagingAndSortingRepository<SmartPhone,Long> {
}
