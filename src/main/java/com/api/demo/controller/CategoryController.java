package com.api.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.api.demo.entity.Category;
import com.api.demo.service.CategoryService;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

 @Autowired
 private CategoryService categoryService;

 @GetMapping
 public ResponseEntity<Page<Category>> getAllCategories(
         @RequestParam(value = "page", required = true) int page,
         @RequestParam(defaultValue = "2") int size
 ) {
     Page<Category> categories = categoryService.getAllCategories(page, size);
     return ResponseEntity.ok(categories);
 }
 
 @PostMapping
 public ResponseEntity<Category> createCategory(@RequestBody Category category) {
     Category createdCategory = categoryService.createCategory(category);
     return ResponseEntity.ok(createdCategory);
 }
 
 @GetMapping("/{id}")
 public ResponseEntity<Category> getCategoryById(@PathVariable Long id) {
     Category category = categoryService.getCategoryById(id);
     return ResponseEntity.ok(category);
 }
 
 @PutMapping("/{id}")
 public ResponseEntity<Category> updateCategory(@PathVariable Long id, @RequestBody Category updatedCategory) {
     Category category = categoryService.updateCategory(id, updatedCategory);
     return ResponseEntity.ok(category);
 }
 
 @DeleteMapping("/{id}")
 public ResponseEntity<Void> deleteCategory(@PathVariable Long id) {
     categoryService.deleteCategory(id);
     return ResponseEntity.noContent().build();
 }
}
