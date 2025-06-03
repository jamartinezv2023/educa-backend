package com.educa.backend.security;

import io.jsonwebtoken.*;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtUtils {

    private final JwtProperties jwtProperties;

    public JwtUtils(JwtProperties jwtProperties) {
        this.jwtProperties = jwtProperties;
    }

    public String generateJwt(String subject) {
        return Jwts.builder()
                .setSubject(subject)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + jwtProperties.getExpiration()))
                .signWith(SignatureAlgorithm.HS512, jwtProperties.getSecret())
                .compact();
    }

    public String getUsernameFromJwt(String token) {
        return parseClaims(token).getSubject();
    }

    public boolean validateJwt(String token) {
        try {
            parseClaims(token);
            return true;
        } catch (ExpiredJwtException e) {
            System.out.println("JWT expirado: " + e.getMessage());
        } catch (UnsupportedJwtException e) {
            System.out.println("JWT no soportado: " + e.getMessage());
        } catch (MalformedJwtException e) {
            System.out.println("JWT malformado: " + e.getMessage());
        } catch (SignatureException e) {
            System.out.println("Firma inválida: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println("JWT vacío o nulo: " + e.getMessage());
        }
        return false;
    }

    private Claims parseClaims(String token) {
        return Jwts.parser()
                .setSigningKey(jwtProperties.getSecret())
                .parseClaimsJws(token)
                .getBody();
    }
}
