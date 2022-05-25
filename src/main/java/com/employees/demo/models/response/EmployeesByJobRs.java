package com.employees.demo.models.response;

import com.employees.demo.models.entity.Employee;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
public class EmployeesByJobRs implements Serializable {

    private static final long serialVersionUID = -5314209065854194679L;

    private List<Employee> employees;
    private boolean sucess;
}
