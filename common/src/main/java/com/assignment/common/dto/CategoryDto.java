package com.assignment.common.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class CategoryDto implements Serializable {
    private Long id;
    private String name;
    private Long expenseLimit;
//    private Long parentId;
//    private Collection<CategoryDto> childCats;
    private List<ExpenseDto> expenses;
}