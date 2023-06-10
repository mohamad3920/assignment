package com.assignment.db.mapper;

import com.assignment.common.dto.CategoryDto;
import com.assignment.common.dto.ExpenseDto;
import com.assignment.db.entity.CategoryEntity;
import com.assignment.db.entity.ExpenseEntity;
import org.mapstruct.Mapper;

@Mapper
public interface DbProviderMapper {
    CategoryEntity categoryD2E(CategoryDto categoryDto);
    CategoryDto categoryE2D(CategoryEntity categoryEntity);
    ExpenseEntity ExpenseD2E(ExpenseDto expenseDto);
    ExpenseDto ExpenseE2D(ExpenseEntity expenseEntity);
}