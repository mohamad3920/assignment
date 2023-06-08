package com.assignment.common.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class ExpenseDto implements Serializable {
    private Long id;
    private Long price;
    private String desc;
    private Date entryDate;
    private Long category;
}
