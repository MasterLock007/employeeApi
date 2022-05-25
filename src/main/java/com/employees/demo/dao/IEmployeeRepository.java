package com.employees.demo.dao;

import com.employees.demo.models.entity.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IEmployeeRepository extends CrudRepository<Employee,Long> {
    List<Employee> getEmployeeByIdJob(Integer idJob);
}
