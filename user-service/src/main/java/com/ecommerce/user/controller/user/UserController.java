package com.ecommerce.user.controller.user;

import com.ecommerce.user.controller.user.dto.UserCreateDTO;
import com.ecommerce.user.controller.user.dto.UserUpdateDTO;
import com.ecommerce.user.model.User;
import com.ecommerce.user.service.UserService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody UserCreateDTO userCreateDTO) {
        User user = new User();
        user.setEmail(userCreateDTO.email());
        user.setPassword(userCreateDTO.password());
        user.setFullName(userCreateDTO.fullName());
        user.setAvatarFileName(userCreateDTO.avatarFileName());
        user.setEmailConfirmed(userCreateDTO.emailConfirmed());

        User createdUser = userService.createUser(user);
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        User user = userService.getUserById(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userService.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody UserUpdateDTO userUpdateDTO) {
        User updatedUser = new User();
        updatedUser.setEmail(userUpdateDTO.email());
        updatedUser.setPassword(userUpdateDTO.password());
        updatedUser.setFullName(userUpdateDTO.fullName());
        updatedUser.setAvatarFileName(userUpdateDTO.avatarFileName());
        updatedUser.setEmailConfirmed(userUpdateDTO.emailConfirmed());

        User user = userService.updateUser(id, updatedUser);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
