package com.assignment.db.impl;

import com.assignment.common.dto.CategoryDto;
import com.assignment.common.dto.ExpenseDto;
import com.assignment.common.facade.provider.DataProviderAgent;
import com.assignment.db.entity.ExpenseEntity;
import com.assignment.db.repository.CategoryRepository;
import com.assignment.db.repository.ExpenseRepository;
import com.assignment.db.repository.ReportRepository;
import com.assignment.db.entity.CategoryEntity;
import com.assignment.db.mapper.DbProviderMapper;
import lombok.extern.slf4j.Slf4j;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    private DbProviderMapper dbProviderMapper = Mappers.getMapper(DbProviderMapper.class);

    @Override
    public CategoryDto saveCategory(CategoryDto request) {
        log.info("entering saveCategory dao");
        CategoryEntity catReq = dbProviderMapper.categoryD2E(request);
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
        categoryRepository.deleteById(catId);
    }

    public CategoryDto getCategoryById(Long id) {
        log.info("entering getCategoryById dao");
        CategoryEntity cat = categoryRepository.getReferenceById(id);
        return dbProviderMapper.categoryE2D(cat);
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
}