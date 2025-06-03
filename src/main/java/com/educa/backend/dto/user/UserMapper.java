package com.educa.backend.dto.user;

import com.educa.backend.domain.model.user.User;

public class UserMapper {
    public static UserDTO toDto(User user) {
        return UserDTO.builder()
                .id(user.getId())
                .username(user.getUsername())
                .email(user.getEmail())
                .profileImage(user.getProfileImage())
                .roles(user.getRoles())             // roles son Set<String>
                .permissions(user.getPermissions()) // permisos son Set<String>
                .build();
    }
}
