package com.assignment.db.mapper;

import com.assignment.common.dto.CategoryDto;
import com.assignment.db.entity.CategoryEntity;
import org.mapstruct.Mapper;

@Mapper
public interface DbProviderMapper {
    CategoryEntity categoryD2E(CategoryDto categoryDto);
    CategoryDto categoryE2D(CategoryEntity categoryEntity);
}
