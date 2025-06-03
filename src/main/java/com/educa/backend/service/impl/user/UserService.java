package com.educa.backend.service;

import com.educa.backend.domain.model.user.User;  // <-- Aquí está el import correcto

import java.util.List;
import java.util.Optional;

public interface UserService {
    User createUser(User user);
    Optional<User> findById(Long id);
    Optional<User> findByEmail(String email);
    List<User> findAll();
    Optional<User> updateUser(Long id, User user);
    void deleteUser(Long id);
}
