package com.employees.demo.models.response;

import com.employees.demo.models.ErrorResponse;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErrorCommonRs {
    private static final long serialVersionUID = 6435945131851492431L;
    private String id;
    private boolean sucess;
    @JsonProperty("status")
    private ErrorResponse errorResponse;
}
