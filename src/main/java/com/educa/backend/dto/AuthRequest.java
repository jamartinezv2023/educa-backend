package com.educa.backend.dto.AuthRequest;

package com.educa.backend.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class AuthRequest {
    @NotBlank(message = "El correo no puede estar vacío")
    @Email(message = "El correo debe tener un formato válido")
    private String email;

    @NotBlank(message = "La contraseña no puede estar vacía")
    private String password;
}

