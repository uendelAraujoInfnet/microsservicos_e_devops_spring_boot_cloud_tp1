package com.example.order.client;

import com.example.order.dto.ProductDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "catalogClient", url = "${catalog.base-url}")
public interface CatalogClient {
    @GetMapping("/api/products/{id}")
    ProductDTO findById(@PathVariable("id") Long id);
}
