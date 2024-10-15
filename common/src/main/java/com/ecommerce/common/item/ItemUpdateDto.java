package com.ecommerce.common.item;

public record ItemUpdateDto(
    String name,
    String description,
    double price,
    String type
) {

}
