package com.employees.demo.service;

import com.employees.demo.dao.IWorkedHoursRepository;
import com.employees.demo.exception.EmployeeApiException;
import com.employees.demo.models.entity.EmpWorkedHours;
import com.employees.demo.models.request.AddWorkedHoursRq;
import com.employees.demo.models.request.TotalHoursRq;
import com.employees.demo.models.response.CommonRs;
import com.employees.demo.models.response.TotalHoursRs;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import static com.employees.demo.enums.ErrorCodesEnum.RANGE_ERROR;
import static com.employees.demo.enums.ErrorCodesEnum.RANGE_ERROR_001;

@Slf4j
@Service
@RequiredArgsConstructor
public class WorkedHoursService implements IWorkedHoursService{

    private final IWorkedHoursRepository workedHoursRepository;

    @Override
    public CommonRs addWorkedHours(AddWorkedHoursRq workedHoursRq){
        EmpWorkedHours workedHoursToSave = new EmpWorkedHours();
        EmpWorkedHours workedHoursSaved = new EmpWorkedHours();
        CommonRs commonRs = new CommonRs();

        //ToDo se puede mejorar este mapeo con mapStruct
        workedHoursToSave.setWorkedHours(workedHoursRq.getWorkedHours());
        workedHoursToSave.setWorkedDate(workedHoursRq.getWorkedDate());
        workedHoursToSave.setIdEmployee(workedHoursRq.getIdEmployee());

        workedHoursSaved = workedHoursRepository.save(workedHoursToSave);

        if(workedHoursSaved.getId()!=null){
            commonRs.setId(String.valueOf(workedHoursSaved.getId()));
            commonRs.setSucess(true);
        }
        return commonRs;
    }

    public TotalHoursRs getTotalWorkedHours(TotalHoursRq totalHoursRq){
        TotalHoursRs totalHoursRs = new TotalHoursRs();
        Integer total = 0;
        boolean isBefore = totalHoursRq.getStartDate().isBefore(totalHoursRq.getEndDate());
        if(isBefore){
           total = workedHoursRepository.countByWorkedDateAndEmployeeId(totalHoursRq.getIdEmployee(),totalHoursRq.getStartDate(),totalHoursRq.getEndDate());
        }else{
            throw new EmployeeApiException(RANGE_ERROR.getCode(),RANGE_ERROR.getMessage());
        }
        if(total!=null){
            totalHoursRs.setTotalHours(total);
            totalHoursRs.setSuccess(true);
        }else{
            throw new EmployeeApiException(RANGE_ERROR_001.getCode(),RANGE_ERROR_001.getMessage());
        }
        return totalHoursRs;
    }


}
