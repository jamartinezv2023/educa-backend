package com.educa.backend.domain.model.user;

import com.educa.backend.domain.model.AuthLog;
import com.educa.backend.domain.model.Student;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

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

    @NotBlank
    private String username;

    @Email
    @NotBlank
    @Column(unique = true)
    private String email;

    @NotBlank
    private String password;

    private Boolean isVerified = false;
    private String verificationToken;
    private Boolean twoFactorEnabled = false;
    private String twoFactorSecret;
    private String profileImage;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"))
    private Set<String> roles = new HashSet<>();

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "user_permissions", joinColumns = @JoinColumn(name = "user_id"))
    private Set<String> permissions = new HashSet<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Student> students = new ArrayList<>();

    @ElementCollection
    @CollectionTable(name = "revoked_tokens", joinColumns = @JoinColumn(name = "user_id"))
    private List<String> revokedTokens = new ArrayList<>();

    @ElementCollection
    @CollectionTable(name = "allowed_devices", joinColumns = @JoinColumn(name = "user_id"))
    private List<String> allowedDevices = new ArrayList<>();

    @ElementCollection
    @CollectionTable(name = "auth_logs", joinColumns = @JoinColumn(name = "user_id"))
    private List<AuthLog> authLogs = new ArrayList<>();

    @ElementCollection
    @CollectionTable(name = "refresh_tokens", joinColumns = @JoinColumn(name = "user_id"))
    private List<String> refreshTokens = new ArrayList<>();
}
