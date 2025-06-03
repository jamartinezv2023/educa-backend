package com.educa.backend.dto.user;

import lombok.*;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDTO {
    private Long id;
    private String username;
    private String email;
    private String profileImage;
    private Set<String> roles;
    private Set<String> permissions;
}
