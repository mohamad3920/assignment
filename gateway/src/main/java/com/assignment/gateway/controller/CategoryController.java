package com.assignment.gateway.controller;

import com.assignment.common.dto.CategoryDto;
import com.assignment.common.facade.provider.DataProviderAgent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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
}
