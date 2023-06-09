package com.assignment.common.dto;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

@Data
@ToString
public class CategoryDto implements Serializable {
    private Long id;
    private String name;
    private Long expenseLimit;
//    private Long parentId;
//    private Collection<CategoryDto> childCats;
//    private List<ExpenseDto> expenses;
}