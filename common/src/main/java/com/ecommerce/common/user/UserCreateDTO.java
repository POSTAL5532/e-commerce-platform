package com.ecommerce.common.user;

public record UserCreateDTO(
    String email,
    String password,
    String fullName,
    String avatarFileName,
    boolean emailConfirmed
) {

}
