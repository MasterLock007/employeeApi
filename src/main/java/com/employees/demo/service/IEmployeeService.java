package com.employees.demo.service;

import com.employees.demo.models.request.AddEmployeeRq;
import com.employees.demo.models.request.EmployeeByJobIdRq;
import com.employees.demo.models.response.CommonRs;
import com.employees.demo.models.response.EmployeesByJobRs;

public interface IEmployeeService {
     CommonRs addEmployee(AddEmployeeRq employeeRequest);

     EmployeesByJobRs getEmployeesByJobId(EmployeeByJobIdRq idJob);
}
