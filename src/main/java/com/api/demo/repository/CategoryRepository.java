package com.api.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.demo.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
