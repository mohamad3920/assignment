package com.assignment.db.repository;

import com.assignment.db.entity.ExpenseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExpenseRepository extends JpaRepository<ExpenseEntity, Long> {
    List<ExpenseEntity> findExpenseEntitiesByCategory_Id(Long id);
}
