package com.assignment.db.repository;

import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ReportRepository {

    private EntityManager em;

    @Autowired
    public ReportRepository(EntityManager em) {
        this.em = em;
    }

}
