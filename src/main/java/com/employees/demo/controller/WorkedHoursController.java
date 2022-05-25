package com.employees.demo.controller;

import com.employees.demo.models.request.AddWorkedHoursRq;
import com.employees.demo.models.request.TotalHoursRq;
import com.employees.demo.models.response.CommonRs;
import com.employees.demo.models.response.TotalHoursRs;
import com.employees.demo.service.IWorkedHoursService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Slf4j
@RestController
@RequestMapping("/v1/worked-hours")
@RequiredArgsConstructor
public class WorkedHoursController {

    private final IWorkedHoursService workedHoursService;

    @PostMapping(path = "/add",produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CommonRs> addNewEmployee(@RequestBody @Valid AddWorkedHoursRq workedHoursRq){
        return new ResponseEntity<>(workedHoursService.addWorkedHours(workedHoursRq), HttpStatus.CREATED);
    }

    @GetMapping(path = "/total-hours",produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TotalHoursRs> getTotalHours(@RequestBody @Valid TotalHoursRq totalHoursRq){
        return new ResponseEntity<>(workedHoursService.getTotalWorkedHours(totalHoursRq),HttpStatus.OK);
    }
}
