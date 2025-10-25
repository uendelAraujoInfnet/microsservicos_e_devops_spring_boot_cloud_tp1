package com.example.catalog.controller;

import com.example.catalog.model.Product;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private static final Map<Long, Product> DB = Map.of(
            1L, new Product(1L, "Teclado Mecânico", 299.90),
            2L, new Product(2L, "Mouse Gamer", 199.90),
            3L, new Product(3L, "Headset", 449.00)
    );

    @GetMapping("/{id}")
    public ResponseEntity<Product> findById(@PathVariable Long id) {
        Product p = DB.get(id);
        return (p == null) ? ResponseEntity.notFound().build() : ResponseEntity.ok(p);
    }
}
