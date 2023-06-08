package com.assignment.db.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Collection;
import java.util.List;

@Table(name = "category")
@Entity
@Data
public class CategoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "catId", nullable = false)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "expenseLimit")
    private Long expenseLimit;

//    @ManyToOne()
//    @JoinColumn(name = "cat_id", referencedColumnName = "catId")
//    private CategoryEntity parentId;
//
//    @OneToMany(mappedBy = "parentId")
//    private Collection<CategoryEntity> childCats;

    @OneToMany(mappedBy = "category")
    private List<ExpenseEntity> expenses;
}
