package com.example.day9.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@Slf4j
@RestController
@RequestMapping(value = "employee")
public class EmployeeController {
    @GetMapping
    public ResponseEntity<List<String>> getAllEmployee() {
        return new ResponseEntity<>(Arrays.asList("HAZEL", "ANGEL", "JOHN"), HttpStatus.OK);
    }

    @PostMapping
//    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Employee> createEmp(@RequestBody Employee employee) {
        employee.setEmpId(1);
        HttpHeaders headers= new HttpHeaders();
        headers.add("ABC", String.valueOf(employee.getEmpId()));
        return new ResponseEntity<>(employee, headers, HttpStatus.CREATED);
    }

    @ExceptionHandler(NullPointerException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public HandleError errorHandler(NullPointerException e) {
        HandleError handleError = new HandleError(false, "Null pointer exception occured.");
        log.info("Error:{}", handleError);
        return handleError;
    }
}
