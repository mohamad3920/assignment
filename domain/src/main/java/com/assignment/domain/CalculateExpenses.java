package com.assignment.domain;

import com.assignment.common.dto.AllCategoryExpensesDto;
import com.assignment.common.dto.CategoryExpensesDto;
import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicReference;

@Component
public class CalculateExpenses {
    public CategoryExpensesDto calculate(CategoryExpensesDto categoryExpenses) {

        if (categoryExpenses != null && categoryExpenses.getExpenses() != null) {
            AtomicReference<Long> totalExpenses = new AtomicReference<>(0L);
            categoryExpenses.getExpenses().forEach(x ->
                    totalExpenses.updateAndGet(v -> v + x.getPrice())
            );
            if (totalExpenses.get() > categoryExpenses.getExpenseLimit())
                categoryExpenses.setInfo("Expense limit has reached. TotalExpense is: " + totalExpenses);
            else
                categoryExpenses.setInfo("Expense limit hasn't reached yet. TotalExpense is: " + totalExpenses);
        }

        return categoryExpenses;
    }

    public AllCategoryExpensesDto calculateAll(AllCategoryExpensesDto categoryExpenses) {

        if (categoryExpenses != null && categoryExpenses.getCategoryExpenses() != null) {
            categoryExpenses.getCategoryExpenses().forEach(x -> x = calculate(x));
        }
        return categoryExpenses;
    }
}