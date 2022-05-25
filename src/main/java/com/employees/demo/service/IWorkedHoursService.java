package com.employees.demo.service;

import com.employees.demo.models.request.AddWorkedHoursRq;
import com.employees.demo.models.request.TotalHoursRq;
import com.employees.demo.models.response.CommonRs;
import com.employees.demo.models.response.TotalHoursRs;

public interface IWorkedHoursService {
    CommonRs addWorkedHours(AddWorkedHoursRq workedHoursRq);
    TotalHoursRs getTotalWorkedHours(TotalHoursRq totalHoursRq);
}
