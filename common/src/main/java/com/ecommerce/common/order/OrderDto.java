package com.ecommerce.common.order;

public record OrderDto(
    Long id,
    Long userId,
    Long itemId,
    String currency,
    double amount
) {

}
