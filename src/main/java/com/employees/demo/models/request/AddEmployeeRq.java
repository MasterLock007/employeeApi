package com.employees.demo.models.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
public class AddEmployeeRq implements Serializable {

    private static final long serialVersionUID = 8389539754945211328L;

    @JsonProperty("gender_id")
    private int genderId;

    @JsonProperty("job_id")
    private int jobId;

    private String name;

    @JsonProperty("last_name")
    private String lastName;

    private LocalDate birthdate;

}
