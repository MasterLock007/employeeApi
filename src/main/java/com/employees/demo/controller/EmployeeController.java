package com.employees.demo.controller;

import com.employees.demo.models.request.AddEmployeeRq;
import com.employees.demo.models.request.EmployeeByJobIdRq;
import com.employees.demo.models.response.CommonRs;
import com.employees.demo.models.response.EmployeesByJobRs;
import com.employees.demo.service.IEmployeeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Slf4j
@RestController
@RequestMapping("/v1/employees")
@RequiredArgsConstructor
public class EmployeeController {

    private final IEmployeeService employeeService;

    @PostMapping(path = "/add",produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CommonRs> addNewEmployee(@RequestBody AddEmployeeRq addEmployeeRq){
        return new ResponseEntity<>(employeeService.addEmployee(addEmployeeRq),HttpStatus.CREATED);
    }


    @GetMapping(path = "/collect-by-jobs",produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<EmployeesByJobRs> getEmployeesByJob(@RequestBody @Valid EmployeeByJobIdRq employeeByJobIdRq){
        return new ResponseEntity<>(employeeService.getEmployeesByJobId(employeeByJobIdRq),HttpStatus.OK);
    }




}
