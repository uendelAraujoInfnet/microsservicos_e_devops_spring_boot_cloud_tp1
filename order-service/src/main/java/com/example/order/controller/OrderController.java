package com.example.order.controller;

import com.example.order.client.CatalogClient;
import com.example.order.dto.CreateOrderRequest;
import com.example.order.dto.OrderResponse;
import com.example.order.dto.ProductDTO;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private final CatalogClient catalogClient;

    public OrderController(CatalogClient catalogClient) {
        this.catalogClient = catalogClient;
    }

    @PostMapping
    public ResponseEntity<OrderResponse> create(@Valid @RequestBody CreateOrderRequest req){
        ProductDTO product = catalogClient.findById(req.productId());
        if(product == null){
            return ResponseEntity.notFound().build();
        }
        double total = product.price() * req.quantity();
        OrderResponse resp = new OrderResponse(
                product.id(), product.name(), req.quantity(), product.price(), total
        );
        return ResponseEntity.ok(resp);
    }
}
