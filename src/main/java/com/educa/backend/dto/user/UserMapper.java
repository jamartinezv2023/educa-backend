package com.educa.backend.dto.user.UserMapper;

package com.educa.backend.dto;

import com.educa.backend.domain.model.User;

public class UserMapper {
    public static UserDTO toDto(User user) {
        return UserDTO.builder()
                .id(user.getId())
                .username(user.getUsername())
                .email(user.getEmail())
                .profileImage(user.getProfileImage())
                .roles(user.getRoles())
                .permissions(user.getPermissions())
                .build();
    }
}
