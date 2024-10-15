package com.ecommerce.common.item;

public record ItemDTO(
    Long id,
    String name,
    String description,
    double price,
    String type
) {

}
