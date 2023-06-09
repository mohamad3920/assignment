package com.assignment.db;

import com.assignment.common.dto.CategoryDto;
import com.assignment.common.dto.ExpenseDto;
import com.assignment.common.facade.provider.DataProviderAgent;
import com.assignment.db.dao.CategoryDao;
import com.assignment.db.dao.ExpenseDao;
import com.assignment.db.dao.ReportDao;
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
    CategoryDao categoryDao;
    @Autowired
    ExpenseDao expenseDao;
    @Autowired
    ReportDao reportDao;

    private DbProviderMapper dbProviderMapper = Mappers.getMapper(DbProviderMapper.class);

    @Override
    public CategoryDto saveCategory(CategoryDto request) {
        log.info("entering saveCategory dao");
        CategoryEntity catReq = dbProviderMapper.categoryD2E(request);
        CategoryEntity cat = categoryDao.save(catReq);
        return dbProviderMapper.categoryE2D(cat);
    }

    @Override
    public CategoryDto editCategory(CategoryDto request) {
        return null;
    }

    @Override
    public void removeCategory(Integer catId) {

    }

    @Override
    public ExpenseDto saveExpense(ExpenseDto request) {
        return null;
    }

    @Override
    public ExpenseDto editExpense(ExpenseDto request) {
        return null;
    }

    @Override
    public void removeExpense(Integer expenseId) {

    }
}
