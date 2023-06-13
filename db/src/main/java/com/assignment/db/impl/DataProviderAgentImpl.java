package com.assignment.db.impl;

import com.assignment.common.dto.*;
import com.assignment.common.exeption.UserNotLogin;
import com.assignment.common.facade.provider.DataProviderAgent;
import com.assignment.db.entity.ExpenseEntity;
import com.assignment.db.entity.UserEntity;
import com.assignment.db.repository.CategoryRepository;
import com.assignment.db.repository.ExpenseRepository;
import com.assignment.db.repository.ReportRepository;
import com.assignment.db.entity.CategoryEntity;
import com.assignment.db.mapper.DbProviderMapper;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@Transactional
public class DataProviderAgentImpl implements DataProviderAgent {
    @Autowired
    CategoryRepository categoryRepository;
    @Autowired
    ExpenseRepository expenseRepository;
    @Autowired
    ReportRepository reportRepository;

    @SneakyThrows
    private UserEntity getUser() {
        var result = new UserEntity();
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null) {
            if (authentication instanceof AnonymousAuthenticationToken) {
                throw new UserNotLogin("user need to get login first");
            } else {
                result = (UserEntity) authentication.getPrincipal();
            }
        }
        return result;
    }

    private DbProviderMapper dbProviderMapper = Mappers.getMapper(DbProviderMapper.class);

    @Override
    public CategoryDto saveCategory(CategoryDto request) {
        log.info("entering saveCategory dao");
        CategoryEntity catReq = dbProviderMapper.categoryD2E(request);
        catReq.setUser(getUser());
        CategoryEntity cat = categoryRepository.save(catReq);
        return dbProviderMapper.categoryE2D(cat);
    }

    @Override
    public CategoryDto editCategory(CategoryDto request) {
        return saveCategory(request);
    }

    @Override
    public void deleteCategory(Long catId) {
        log.info("entering removeCategory dao");
        categoryRepository.deleteCategoryEntitiesByIdAndUser(catId, getUser());
    }

    public CategoryDto getCategoryById(Long id) {
        log.info("entering getCategoryById dao");
        CategoryEntity cat = categoryRepository.getCategoryEntitiesByIdAndUser(id, getUser());
        return dbProviderMapper.categoryE2D(cat);
    }

    @Override
    public CategoryExpensesDto getCategoryExpensesById(Long id) {
        log.info("entering getCategoryExpensesById dao");
        CategoryEntity cat = categoryRepository.getCategoryEntitiesByIdAndUser(id, getUser());
        return dbProviderMapper.categoryE2CatExp(cat);
    }

    @Override
    public AllCategoriesDto getAllCategory() {
        log.info("entering getAllCategory dao");
        List<CategoryEntity> all = categoryRepository.getCategoryEntitiesByUser(getUser());
        var result = new AllCategoriesDto();
        result.setCategories(new ArrayList<>());
        all.forEach(x -> result.getCategories().add(dbProviderMapper.categoryE2D(x)));
        return result;
    }

    @Override
    public AllCategoryExpensesDto getAllCategoryExpenses() {
        log.info("entering getAllCategoryExpenses dao");
        List<CategoryEntity> all = categoryRepository.getCategoryEntitiesByUser(getUser());
        var result = new AllCategoryExpensesDto();
        result.setCategoryExpenses(new ArrayList<>());
        all.forEach(x -> result.getCategoryExpenses().add(dbProviderMapper.categoryE2CatExp(x)));
        return result;
    }

    @Override
    public ExpenseDto saveExpense(ExpenseDto request) {
        log.info("entering saveExpense dao");
        ExpenseEntity expReq = dbProviderMapper.ExpenseD2E(request);
        ExpenseEntity exp = expenseRepository.save(expReq);
        return dbProviderMapper.ExpenseE2D(exp);
    }

    @Override
    public ExpenseDto editExpense(ExpenseDto request) {
        return saveExpense(request);
    }

    @Override
    public void deleteExpense(Long expenseId) {
        log.info("entering removeExpense dao");
        expenseRepository.deleteById(expenseId);
    }

    @Override
    public List<ExpenseDto> getExpensesByCat(Long id) {
        log.info("entering getExpensesByCat dao");
        List<ExpenseEntity> exp = expenseRepository.findExpenseEntitiesByCategory_Id(id);
        List<ExpenseDto> result = new ArrayList<>();
        exp.forEach(x -> result.add(dbProviderMapper.ExpenseE2D(x)));
        return null;
    }
}