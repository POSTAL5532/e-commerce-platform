package com.ecommerce.common.user;

public record UserDTO(
    Long id,
    String email,
    String password,
    String fullName,
    String avatarFileName,
    boolean emailConfirmed
) {

}
