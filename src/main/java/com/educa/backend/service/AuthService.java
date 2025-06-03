package com.educa.backend.service;

import com.educa.backend.dto.AuthRequest;
import com.educa.backend.dto.AuthResponse;

public interface AuthService {
    AuthResponse authenticate(AuthRequest request);
}
