package com.assignment.db.repository;

import com.assignment.db.entity.CategoryEntity;
import com.assignment.db.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<CategoryEntity, Long> {

    Boolean deleteCategoryEntitiesByIdAndUser(Long Id, UserEntity user);
    CategoryEntity getCategoryEntitiesByIdAndUser(Long Id, UserEntity user);
    List<CategoryEntity> getCategoryEntitiesByUser(UserEntity user);

}
