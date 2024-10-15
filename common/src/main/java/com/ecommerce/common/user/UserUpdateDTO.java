package com.ecommerce.common.user;

public record UserUpdateDTO(
    String email,
    String password,
    String fullName,
    String avatarFileName,
    boolean emailConfirmed
) {

}
