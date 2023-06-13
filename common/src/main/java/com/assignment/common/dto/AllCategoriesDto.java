package com.assignment.common.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class AllCategoriesDto implements Serializable {
    private List<CategoryDto> categories;
}