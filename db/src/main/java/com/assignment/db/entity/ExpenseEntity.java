package com.assignment.db.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Table(name = "expense")
@Entity
@Data
public class ExpenseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "expenseId", nullable = false)
    private Long id;
    @Column(name = "price")
    private Long price;
    @Column(name = "desc")
    private String desc;
    @Column(name = "entryDate")
    private Date entryDate;

    @ManyToOne()
    @JoinColumn(name = "catId", referencedColumnName = "catId")
    private CategoryEntity category;
}
