package com.assignment.gateway.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExpenseController {

    @GetMapping("/getExpensesByCat")
    public ResponseEntity getExpensesByCat(@RequestParam Integer Id) {
        return new ResponseEntity(HttpStatus.OK);
    }
}
