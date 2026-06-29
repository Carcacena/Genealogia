package br.com.jose.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;

@Component
public class JwtUtils {

    @Value("${jwt.secret}")
    private String jwtSecret;

    @Value("${jwt.expiration}")
    private int jwtExpirationMs;

    @PostConstruct
    public void debug() {
        System.out.println("SECRET=" + jwtSecret);
        System.out.println("EXP=" + jwtExpirationMs);
    }
    // Inject these values directly into your JwtService/JwtUtil
//@Value("${jwt.expiration:3600000}") // Default: 1 hour in milliseconds (3600000 ms = 1 hr)//
//private long jwtExpiration;

//public String generateToken(UserDetails userDetails) {
//    return Jwts.builder()
//            .setSubject(userDetails.getUsername())
//            .setIssuedAt(new Date(System.currentTimeMillis()))
//            .setExpiration(new Date(System.currentTimeMillis() + jwtExpiration))
//            .signWith(getSignInKey(), SignatureAlgorithm.HS256)
//            .compact();
    }
    
}
