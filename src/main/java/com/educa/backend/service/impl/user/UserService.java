package com.educa.backend.service.impl.user.UserService;

package com.educa.backend.service.impl;

import com.educa.backend.domain.model.User;
import java.util.List;
import java.util.Optional;

public interface UserService {
    User createUser(User user);
    Optional<User> findById(Long id);
    Optional<User> findByEmail(String email);
    List<User> findAll();
    User updateUser(Long id, User user);
    void deleteUser(Long id);
}