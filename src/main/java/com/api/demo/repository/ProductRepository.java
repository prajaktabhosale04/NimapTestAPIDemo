package com.api.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.demo.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}

