package com.assignment.gateway.controller;

import com.assignment.common.dto.CategoryDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CategoryController {

    @PostMapping("/saveCategory")
    public ResponseEntity postAssignment(@RequestBody CategoryDto requestDto) {
        return new ResponseEntity(HttpStatus.OK);
    }
}
