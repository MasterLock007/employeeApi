package com.employees.demo.dao;

import com.employees.demo.models.entity.EmpWorkedHours;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface IWorkedHoursRepository extends CrudRepository<EmpWorkedHours,Long> {
    @Query(value = "select sum(e.workedHours) from EmpWorkedHours e where e.idEmployee = :id and e.workedDate between :startDate and :endDate")
    Integer countByWorkedDateAndEmployeeId(@Param("id") Integer idEmployee, @Param("startDate")LocalDate startDate,@Param("endDate")LocalDate endDate);

}
