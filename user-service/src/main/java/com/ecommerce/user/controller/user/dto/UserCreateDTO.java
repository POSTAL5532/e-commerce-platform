package com.ecommerce.user.controller.user.dto;

public record UserCreateDTO(
    String email,
    String password,
    String fullName,
    String avatarFileName,
    boolean emailConfirmed
) {

}
