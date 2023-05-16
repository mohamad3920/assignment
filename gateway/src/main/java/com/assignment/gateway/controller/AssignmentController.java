package com.assignment.gateway.controller;

import com.assignment.common.dto.AssignmentDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AssignmentController {

    @PostMapping()
    public ResponseEntity postAssignment(@RequestBody AssignmentDto assignmentDto) {
        return new ResponseEntity(HttpStatus.ACCEPTED);
    }
}
