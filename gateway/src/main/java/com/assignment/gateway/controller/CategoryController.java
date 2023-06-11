package com.assignment.gateway.controller;

import com.assignment.common.dto.CategoryDto;
import com.assignment.common.facade.provider.DataProviderAgent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
public class CategoryController {

    @Autowired
    DataProviderAgent dataProviderAgent;

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

    @GetMapping("getAllCategory")
    public ResponseEntity<List<CategoryDto>> getAllCategory() {
        log.info("entering getAllCategory service");
        List<CategoryDto> result = dataProviderAgent.getAllCategory();
        return new ResponseEntity(result, HttpStatus.OK);
    }

    @DeleteMapping("deleteCategoryById/{id}")
    public ResponseEntity<CategoryDto> deleteCategoryById(@PathVariable("id") Long id) {
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