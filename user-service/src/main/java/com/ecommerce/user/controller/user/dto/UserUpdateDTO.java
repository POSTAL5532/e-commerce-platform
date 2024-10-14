package com.ecommerce.user.controller.user.dto;

public record UserUpdateDTO(
    String email,
    String password,
    String fullName,
    String avatarFileName,
    boolean emailConfirmed
) {

}
