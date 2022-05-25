package com.employees.demo.models.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class TotalHoursRs implements Serializable {
    private static final long serialVersionUID = 992223156481844604L;
    @JsonProperty("total_worked_hours")
    private Integer totalHours;
    private boolean success;

}
