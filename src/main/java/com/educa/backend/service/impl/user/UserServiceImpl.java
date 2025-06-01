package com.educa.backend.service.impl.user.UserServiceImpl;

package com.educa.backend.service.impl;

import com.educa.backend.domain.model.User;
import com.educa.backend.domain.repository.UserRepository;
import com.educa.backend.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User updateUser(Long id, User user) {
        return userRepository.findById(id).map(existing -> {
            existing.setUsername(user.getUsername());
            existing.setEmail(user.getEmail());
            existing.setProfileImage(user.getProfileImage());
            return userRepository.save(existing);
        }).orElseThrow();
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}