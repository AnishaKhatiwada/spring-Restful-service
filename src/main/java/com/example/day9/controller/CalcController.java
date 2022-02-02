package com.example.day9.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping
public class CalcController {


    @GetMapping(value = "calculation/addition")
    public ResponseEntity<Integer> add() {
        Integer s = 2 + 3;
        return new ResponseEntity<>(s, HttpStatus.OK);
    }

    @PostMapping(value = "calculation/multiply")
    public ResponseEntity<Integer> mul(@RequestBody VarClass varClass) {
        Integer m = varClass.getA() * varClass.getB();
        return new ResponseEntity<>(m, HttpStatus.OK);
    }

    @RequestMapping(value = "calculation/subtract", method = RequestMethod.GET)
    public double sub() {
        return 5 - 6;
    }

    @RequestMapping(value = "calculation/divide/{a}/{b}", method = RequestMethod.GET)
    public ResponseEntity<Integer> div(@PathVariable Integer a, @PathVariable Integer b) {
        log.info("Path variables : a{}, b{}", a, b);
        Integer d = a / b;
        return new ResponseEntity<>(d, HttpStatus.OK);
    }


    @RequestMapping(value = {"calculation/simplify", "calculation/simplify/{b}"}, method = RequestMethod.GET)
    public int simp(@PathVariable(required = false) Integer b) {

        if (b != null) {
            int num1 = 1;
            log.info("Path variables : a{}, b{}", num1, b);
            int d = -(num1 + b);
            return d;
        } else {
            return 0;
        }
    }

    @RequestMapping(value = "dialog")
    public String message(@RequestParam(name = "name", defaultValue = "Anisha") String name) {
        return name;
    }

    @GetMapping(value = "student/billamount")
    public String Fees() {
        String StudentName = null;
        StudentName.toLowerCase();
        return String.valueOf(50000);
    }

    @ExceptionHandler(NullPointerException.class)
    public HandleError errorHandler(NullPointerException e) {
        HandleError handleError = new HandleError(false, "Null pointer exception occured.");
        log.info("Error:{}", handleError);
        return handleError;
    }


}