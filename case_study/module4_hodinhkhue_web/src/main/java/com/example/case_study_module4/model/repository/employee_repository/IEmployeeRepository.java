package com.example.case_study_module4.model.repository.employee_repository;

import com.example.case_study_module4.model.entity.Customer;
import com.example.case_study_module4.model.entity.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IEmployeeRepository extends PagingAndSortingRepository<Employee, Integer> {

    @Query(value = "select  *  from employee " +
            "join devision  on employee.division_id = devision.division_id " +
            "join positon  on employee.position_id =  positon.position_id " +
            "join education_degree on employee.education_degree_id = education_degree.education_degree_id " +
            "where employee.employee_name like %:search% " +
            " or employee.employee_address like %:search% " +
            " or devision.divisionname like %:search% " +
            " or positon.positon_name like %:search% " +
            " or education_degree.education_degree_name like %:search% ", nativeQuery = true)
    Page<Employee> findEmployees(@Param("search") String search, Pageable pageable);
}
