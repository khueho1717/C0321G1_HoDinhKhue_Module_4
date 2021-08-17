package com.example.exam_module4.model.repository;

import com.example.exam_module4.model.entity.Deal;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface DealRepository extends PagingAndSortingRepository<Deal,Integer> {
    @Query(value="SELECT * FROM deal " +
            "join customer_deal on deal.id_customer=customer_deal.id " +
            "where deal.service_type like %:search% or customer_deal.name_customer like %:search%",nativeQuery=true)
    Page<Deal> findDeal(@Param("search") String search, Pageable pageable);
}
