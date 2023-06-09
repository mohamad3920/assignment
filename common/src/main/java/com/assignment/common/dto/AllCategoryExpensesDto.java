package com.assignment.common.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class AllCategoryExpensesDto implements Serializable {
    private List<CategoryExpensesDto> categoryExpenses;
}