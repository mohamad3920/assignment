package com.assignment.gateway.controller;

import com.assignment.common.dto.AllCategoriesDto;
import com.assignment.common.dto.AllCategoryExpensesDto;
import com.assignment.common.dto.CategoryDto;
import com.assignment.common.dto.CategoryExpensesDto;
import com.assignment.common.facade.provider.DataProviderAgent;
import com.assignment.domain.CalculateExpenses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
public class CategoryController {

    @Autowired
    DataProviderAgent dataProviderAgent;
    @Autowired
    CalculateExpenses calculateExpenses;

    @PostMapping("/saveCategory")
    public ResponseEntity<CategoryDto> saveCategory(@RequestBody CategoryDto requestDto) {
        log.info("entering saveCategory service");
        log.debug("with request: {}", requestDto);
        CategoryDto result = dataProviderAgent.saveCategory(requestDto);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("getCategoryById/{id}")
    public ResponseEntity<CategoryDto> getCategoryById(@PathVariable("id") Long id) {
        log.info("entering getCategoryById service");
        log.debug("with request: {}", id);
        CategoryDto result = dataProviderAgent.getCategoryById(id);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("getCategoryExpensesById/{id}")
    public ResponseEntity<CategoryExpensesDto> getCategoryExpensesById(@PathVariable("id") Long id) {
        log.info("entering getCategoryById service");
        log.debug("with request: {}", id);
        CategoryExpensesDto result = dataProviderAgent.getCategoryExpensesById(id);
        result = calculateExpenses.calculate(result);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("getAllCategory")
    public ResponseEntity<AllCategoriesDto> getAllCategory() {
        log.info("entering getAllCategory service");
        AllCategoriesDto result = dataProviderAgent.getAllCategory();
        return new ResponseEntity(result, HttpStatus.OK);
    }

    @GetMapping("getAllCategoryExpenses")
    public ResponseEntity<AllCategoryExpensesDto> getAllCategoryExpenses() {
        log.info("entering getAllCategoryExpenses service");
        AllCategoryExpensesDto result = dataProviderAgent.getAllCategoryExpenses();
        result = calculateExpenses.calculateAll(result);
        return new ResponseEntity(result, HttpStatus.OK);
    }

    @DeleteMapping("deleteCategoryById/{id}")
    public ResponseEntity deleteCategoryById(@PathVariable("id") Long id) {
        log.info("entering deleteCategoryById service");
        log.debug("with request: {}", id);
        dataProviderAgent.deleteCategory(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("editCategory")
    public ResponseEntity<CategoryDto> editCategory(@RequestBody CategoryDto request) {
        log.info("entering CategoryDto service");
        log.debug("with request: {}", request);
        CategoryDto result = dataProviderAgent.editCategory(request);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}