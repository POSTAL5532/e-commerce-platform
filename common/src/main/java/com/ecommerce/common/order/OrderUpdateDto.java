package com.ecommerce.common.order;

public record OrderUpdateDto(
    Long userId,
    Long itemId,
    String currency,
    double amount
) {

}
