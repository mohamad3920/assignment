package com.assignment.common.facade.provider;

import com.assignment.common.dto.*;

import java.util.List;

public interface DataProviderAgent {
    CategoryDto saveCategory(CategoryDto request);
    CategoryDto editCategory(CategoryDto request);
    void deleteCategory(Long catId);
    CategoryDto getCategoryById(Long id);
    CategoryExpensesDto getCategoryExpensesById(Long id);
    AllCategoriesDto getAllCategory();
    AllCategoryExpensesDto getAllCategoryExpenses();
    ExpenseDto saveExpense(ExpenseDto request);
    ExpenseDto editExpense(ExpenseDto request);
    void deleteExpense(Long expenseId);
    List<ExpenseDto> getExpensesByCat(Long id);
}