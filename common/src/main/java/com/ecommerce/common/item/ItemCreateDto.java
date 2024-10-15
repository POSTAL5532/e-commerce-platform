package com.ecommerce.common.item;

public record ItemCreateDto(
    String name,
    String description,
    double price,
    String type
) {

}
