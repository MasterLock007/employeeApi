package com.employees.demo.service;

import com.employees.demo.dao.IEmployeeRepository;
import com.employees.demo.exception.EmployeeApiException;
import com.employees.demo.models.entity.Employee;
import com.employees.demo.models.request.AddEmployeeRq;
import com.employees.demo.models.request.EmployeeByJobIdRq;
import com.employees.demo.models.response.CommonRs;
import com.employees.demo.models.response.EmployeesByJobRs;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

import static com.employees.demo.enums.ErrorCodesEnum.AGE_ERROR;

@Slf4j
@Service
@RequiredArgsConstructor
public class EmployeeService implements IEmployeeService {

    private final IEmployeeRepository employeeRepository;

    @Override
    public CommonRs addEmployee(AddEmployeeRq employeeRequest){
        Employee employeeToSave = new Employee();
        Employee employeeSaved;
        CommonRs commonRs = new CommonRs();
        if(getAge(employeeRequest.getBirthdate(),LocalDate.now())<=18){
            throw new EmployeeApiException(AGE_ERROR.getCode(), AGE_ERROR.getMessage());
        }
        //ToDo se puede mejorar este mapeo con mapStruct
        employeeToSave.setBirthdate(employeeRequest.getBirthdate());
        employeeToSave.setIdGender(employeeRequest.getGenderId());
        employeeToSave.setIdJob(employeeRequest.getJobId());
        employeeToSave.setName(employeeRequest.getName());
        employeeToSave.setLastName(employeeRequest.getLastName());

            employeeSaved = employeeRepository.save(employeeToSave);
            log.debug("Employee {}",employeeSaved);
            if(employeeSaved.getId()!=null){
                commonRs.setId(String.valueOf(employeeSaved.getId()));
                commonRs.setSucess(true);
            }
        return commonRs;
    }

    private int getAge(LocalDate birthdate,LocalDate currentDate){
        return Period.between(birthdate,currentDate).getYears();
    }


    @Override
    public EmployeesByJobRs getEmployeesByJobId(EmployeeByJobIdRq idJob){
        EmployeesByJobRs employees = new EmployeesByJobRs();
        List<Employee> employeeList = employeeRepository.getEmployeeByIdJob(idJob.getIdJob());
        if(employeeList.size()!=0){
            employees.setEmployees(employeeList);
            employees.setSucess(true);
        }else{
            log.info("Not exist Employees or the job_id");
        }
        return employees;
    }

}
