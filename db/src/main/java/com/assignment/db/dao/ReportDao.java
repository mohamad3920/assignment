package com.assignment.db.dao;

import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ReportDao {

    private EntityManager em;

    @Autowired
    public ReportDao(EntityManager em) {
        this.em = em;
    }

}
