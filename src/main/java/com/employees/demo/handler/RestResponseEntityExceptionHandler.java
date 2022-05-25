package com.employees.demo.handler;

import com.employees.demo.exception.EmployeeApiException;
import com.employees.demo.models.ErrorResponse;
import com.employees.demo.models.response.ErrorCommonRs;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import static com.employees.demo.enums.ErrorCodesEnum.HOURS_ERROR;
import static com.employees.demo.enums.ErrorCodesEnum.VALIDATION_ERROR;

@ControllerAdvice
public class RestResponseEntityExceptionHandler {

    @ExceptionHandler(EmployeeApiException.class)
    protected ResponseEntity<ErrorResponse> handleConflict(final EmployeeApiException e) {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setMessage(e.getMessage());
        errorResponse.setErrorCode(e.getCode());
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    protected ResponseEntity<ErrorCommonRs> handleConflict(final ConstraintViolationException e) {
        ErrorResponse errorResponse = new ErrorResponse();
        ErrorCommonRs errorCommonRs = new ErrorCommonRs();
        errorResponse.setMessage(VALIDATION_ERROR.getMessage());
        errorResponse.setErrorCode(VALIDATION_ERROR.getCode().concat( " "+e.getSQLException().getMessage()));
        errorCommonRs.setErrorResponse(errorResponse);
        return new ResponseEntity<>(errorCommonRs, HttpStatus.NOT_ACCEPTABLE);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    protected ResponseEntity<ErrorCommonRs> handleConflict(final MethodArgumentNotValidException e) {
        ErrorResponse errorResponse = new ErrorResponse();
        ErrorCommonRs errorCommonRs = new ErrorCommonRs();
        errorResponse.setMessage(HOURS_ERROR.getMessage());
        errorResponse.setErrorCode(HOURS_ERROR.getCode().concat( " "+e.getMessage()));
        errorCommonRs.setErrorResponse(errorResponse);
        return new ResponseEntity<>(errorCommonRs, HttpStatus.NOT_ACCEPTABLE);
    }
}
