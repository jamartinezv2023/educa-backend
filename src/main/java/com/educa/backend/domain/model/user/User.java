package com.educa.backend.domain.model.user.User;

package com.educa.backend.domain.model;
package com.educa.backend.domain.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;
import java.util.*;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    @Column(unique = true)
    private String email;

    private String password;
    private Boolean isVerified = false;
    private String verificationToken;
    private Boolean twoFactorEnabled = false;
    private String twoFactorSecret;
    private String profileImage;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "user_roles")
    private Set<String> roles = new HashSet<>();

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "user_permissions")
    private Set<String> permissions = new HashSet<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Student> students = new ArrayList<>();

    @ElementCollection
    private List<String> revokedTokens = new ArrayList<>();

    @ElementCollection
    private List<String> allowedDevices = new ArrayList<>();

    @ElementCollection
    @CollectionTable(name = "auth_logs")
    private List<AuthLog> authLogs = new ArrayList<>();

    @ElementCollection
    private List<String> refreshTokens = new ArrayList<>();
}