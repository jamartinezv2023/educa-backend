package com.educa.backend.service.impl;

import com.educa.backend.dto.AuthRequest;
import com.educa.backend.dto.AuthResponse;
import com.educa.backend.service.AuthService;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    @Override
    public AuthResponse authenticate(AuthRequest request) {
        // Simulación de lógica de autenticación (reemplazar con lógica real)
        if ("admin".equals(request.getUsername()) && "password".equals(request.getPassword())) {
            return new AuthResponse("token_simulado", "admin");
        } else {
            throw new RuntimeException("Credenciales inválidas");
        }
    }
}
