package com.example.order.dto;

public record OrderResponse(
        Long productId,
        String productName,
        int quantity,
        double unitPrice,
        double total
) {
}
