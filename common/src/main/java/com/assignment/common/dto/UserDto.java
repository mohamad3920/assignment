package com.assignment.common.dto;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

@Data
@ToString
public class UserDto implements Serializable {

    private Long id;
    private String username;
    private String password;
}