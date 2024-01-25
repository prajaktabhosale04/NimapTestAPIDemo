package com.api.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.api.demo.entity.Product;
import com.api.demo.service.ProductService;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

 @Autowired
 private ProductService productService;

 @GetMapping
 public ResponseEntity<Page<Product>> getAllProducts( @RequestParam(value = "page", required = true) int page,
         @RequestParam(defaultValue = "2") int size) {
	 Page<Product> products = productService.getAllProducts(page, size);
     return ResponseEntity.ok(products);
 }

 @PostMapping
 public ResponseEntity<Product> createProduct(@RequestBody Product product) {
     Product createdProduct = productService.createProduct(product);
     return ResponseEntity.ok(createdProduct);
 }

 @GetMapping("/{id}")
 public ResponseEntity<Product> getProductById(@PathVariable Long id) {
     Product product = productService.getProductById(id);
     return ResponseEntity.ok(product);
 }

 @PutMapping("/{id}")
 public ResponseEntity<Product> updateProduct(@PathVariable Long id, @RequestBody Product updatedProduct) {
     Product product = productService.updateProduct(id, updatedProduct);
     return ResponseEntity.ok(product);
 }

 @DeleteMapping("/{id}")
 public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
     productService.deleteProduct(id);
     return ResponseEntity.noContent().build();
 }
}

