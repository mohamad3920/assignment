package com.assignment.gateway.controller;

import com.assignment.common.dto.ExpenseDto;
import com.assignment.common.facade.provider.DataProviderAgent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
public class ExpenseController {

    @Autowired
    DataProviderAgent dataProviderAgent;

    @PostMapping("/saveExpense")
    public ResponseEntity<ExpenseDto> saveExpense(@RequestBody ExpenseDto requestDto) {
        log.info("entering saveExpense service");
        log.debug("with request: {}", requestDto);
        ExpenseDto result = dataProviderAgent.saveExpense(requestDto);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/getExpensesByCat/{id}")
    public ResponseEntity getExpensesByCat(@PathVariable("id") Long catId) {
        return new ResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping("deleteExpenseById/{id}")
    public ResponseEntity deleteExpenseById(@PathVariable("id") Long id) {
        log.info("entering deleteExpenseById service");
        log.debug("with request: {}", id);
        dataProviderAgent.deleteExpense(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("editExpense")
    public ResponseEntity<ExpenseDto> editExpense(@RequestBody ExpenseDto request) {
        log.info("entering editExpense service");
        log.debug("with request: {}", request);
        ExpenseDto result = dataProviderAgent.editExpense(request);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}