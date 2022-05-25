package com.employees.demo.models.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class EmployeeByJobIdRq implements Serializable {

    private static final long serialVersionUID = 8844960567603692883L;

    @JsonProperty("job_id")
    private Integer idJob;
}
