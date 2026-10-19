package com.dr.backend.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;

@Component

public class JwtUtils {

    @Value("${dr.app.jwtSecret}")
    private String jwtSecret;

    @Value("${dr.app.jwtExpirationMs}")
    private int jwtExpirationMs;

    // Secret Key ko secure format me convert karna
    private Key key() {
        return Keys.hmacShaKeyFor(jwtSecret.getBytes());
    }

    // 1. Naya Token Generate karna (Login ke baad)
    public String generateJwtToken(String email, String role) {
        return Jwts.builder()
                .setSubject(email)
                .claim("role", role) // Token me User ka Role bhi daal diya
                .setIssuedAt(new Date())
                .setExpiration(new Date((new Date()).getTime() + jwtExpirationMs))
                .signWith(key(), SignatureAlgorithm.HS256)
                .compact();
    }

    // 2. Token me se Email nikalna
    public String getEmailFromJwtToken(String token) {
        return Jwts.parserBuilder().setSigningKey(key()).build()
                .parseClaimsJws(token).getBody().getSubject();
    }

    // 3. Token check karna (Asli hai ya Expire ho gaya)
    public boolean validateJwtToken(String authToken) {
        try {
            Jwts.parserBuilder().setSigningKey(key()).build().parseClaimsJws(authToken);
            return true;
        } catch (Exception e) {
            System.out.println("Invalid JWT token: " + e.getMessage());
        }
        return false;
    }
}
