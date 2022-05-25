package com.employees.demo.models.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Max;
import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
public class AddWorkedHoursRq implements Serializable {

    private static final long serialVersionUID = -1037417563853180644L;
    @JsonProperty("employee_id")
    private int idEmployee;

    @Max(value = 20,message = "Can´t add more than 20 hours")
    @JsonProperty("worked_hours")
    private int workedHours;

    @JsonProperty("worked_date")
    private LocalDate workedDate;
}
