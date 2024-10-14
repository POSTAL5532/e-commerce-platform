package com.ecommerce.user.service;

import com.ecommerce.user.model.User;
import com.ecommerce.user.repository.UserRepository;
import java.util.List;
import java.util.NoSuchElementException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional(readOnly = true)
public class UserService {

    private final UserRepository userRepository;

    public User getUserById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> {
            log.error("User with id {} not found", id);
            return new NoSuchElementException("User not found with id: " + id);
        });
    }

    public User createUser(User user) {
        if (userRepository.existsByEmail(user.getEmail()) != null) {
            log.error("User with email {} already exists", user.getEmail());
            throw new IllegalArgumentException("User already exists with email: " + user.getEmail());
        }

        return userRepository.save(user);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Transactional
    public User updateUser(Long id, User updatedUser) {
        User existingUser = getUserById(id);

        User userWithSameEmail = userRepository.findByEmail(updatedUser.getEmail());
        if (userWithSameEmail != null && !userWithSameEmail.getId().equals(id)) {
            log.error("User with email {} already exists", updatedUser.getEmail());
            throw new RuntimeException("Email is already in use by another user: " + updatedUser.getEmail());
        }

        existingUser.setEmail(updatedUser.getEmail());
        existingUser.setPassword(updatedUser.getPassword());
        existingUser.setFullName(updatedUser.getFullName());
        existingUser.setAvatarFileName(updatedUser.getAvatarFileName());
        existingUser.setEmailConfirmed(updatedUser.isEmailConfirmed());

        return userRepository.save(existingUser);
    }

    @Transactional
    public void deleteUser(Long id) {
        if (!userRepository.existsById(id)) {
            log.error("User with id {} not found", id);
            throw new NoSuchElementException("User not found with id: " + id);
        }

        userRepository.deleteById(id);
    }
}
