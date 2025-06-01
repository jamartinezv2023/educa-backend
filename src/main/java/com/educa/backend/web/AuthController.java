package com.educa.backend.web.AuthController;

package com.educa.backend.web;

import com.educa.backend.domain.model.User;
import com.educa.backend.dto.AuthRequest;
import com.educa.backend.dto.AuthResponse;
import com.educa.backend.security.JwtUtils;
import com.educa.backend.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthenticationManager authManager;
    private final JwtUtils jwtUtils;
    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody AuthRequest request) {
        Authentication auth = authManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));

        String token = jwtUtils.generateJwt(request.getEmail());
        String refreshToken = jwtUtils.generateJwt(request.getEmail());
        return ResponseEntity.ok(new AuthResponse(token, refreshToken));
    }

    @PostMapping("/register")
    public ResponseEntity<AuthResponse> register(@RequestBody AuthRequest request) {
        User newUser = User.builder()
                .email(request.getEmail())
                .username(request.getEmail().split("@")[0])
                .password(passwordEncoder.encode(request.getPassword()))
                .build();

        userService.createUser(newUser);
        String token = jwtUtils.generateJwt(newUser.getEmail());
        String refreshToken = jwtUtils.generateJwt(newUser.getEmail());
        return ResponseEntity.ok(new AuthResponse(token, refreshToken));
    }
}
