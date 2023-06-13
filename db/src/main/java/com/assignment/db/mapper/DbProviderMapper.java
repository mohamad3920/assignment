package com.assignment.db.mapper;

import com.assignment.common.dto.CategoryDto;
import com.assignment.common.dto.CategoryExpensesDto;
import com.assignment.common.dto.ExpenseDto;
import com.assignment.common.dto.UserDto;
import com.assignment.db.entity.CategoryEntity;
import com.assignment.db.entity.ExpenseEntity;
import com.assignment.db.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface DbProviderMapper {
    CategoryEntity categoryD2E(CategoryDto categoryDto);

    CategoryDto categoryE2D(CategoryEntity categoryEntity);

    CategoryExpensesDto categoryE2CatExp(CategoryEntity categoryEntity);

    @Mapping(target = "category.id", source = "category")
    ExpenseEntity ExpenseD2E(ExpenseDto expenseDto);

    @Mapping(target = "category", source = "category.id")
    ExpenseDto ExpenseE2D(ExpenseEntity expenseEntity);

    UserDto userE2D(UserEntity request);

    UserEntity userD2E(UserDto request);
}