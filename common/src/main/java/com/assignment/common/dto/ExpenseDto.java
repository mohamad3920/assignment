package com.assignment.common.dto;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

@Data
@ToString
public class ExpenseDto implements Serializable {
    private Long id;
    private Long price;
    private String desc;
    private Date entryDate;
    private Long category;
}
