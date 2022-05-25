package com.employees.demo.exception;

import lombok.Getter;

@Getter
public class EmployeeApiException extends RuntimeException{

    private String code;

    private String message;

    public EmployeeApiException(final String code, final String message,Throwable ex){
        super(message,ex);
        this.code = code;
        this.message = message;
    }

    public EmployeeApiException(final String code, final String message){
        super(message);
        this.code = code;
        this.message = message;
    }

    public EmployeeApiException(final String message){
        super(message);
        this.message = message;
    }

}
