package com.ecommerce.common.order;

public record OrderCreateDto(
    Long userId,
    Long itemId,
    String currency,
    double amount
) {

}
