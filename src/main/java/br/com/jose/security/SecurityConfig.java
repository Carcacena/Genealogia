package br.com.jose.security;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private JwtFilter jwtFilter;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        return http
                .csrf(csrf -> csrf.disable())
                .cors(cors -> cors.configurationSource(request -> {
                    var corsConfig = new org.springframework.web.cors.CorsConfiguration();
                    // 🚨 ALINHADO: Permite o local e a URL definitiva da nuvem
                    corsConfig.setAllowedOrigins(List.of("http://localhost:8080", "https://railway.app")); 
                    corsConfig.setAllowedMethods(List.of("GET","POST","PUT","DELETE","OPTIONS"));
                    corsConfig.setAllowedHeaders(List.of("Authorization","Content-Type"));
                    return corsConfig;
                }))
                 		.authorizeHttpRequests(auth -> auth

                			    // 🚀 PORTA ABERTA: Rota de login liberada sem travar no 403
                			    .requestMatchers(HttpMethod.POST, "/auth/login").permitAll()

                			    // Recursos estáticos e rota de erro liberados
                			    .requestMatchers(
                			        "/",
                			        "/*.html",
                			        "/*.js",
                			        "/*.css",
                			        "/*.jpg",
                			        "/*.png",
                			        "/favicon.ico",
                			        "/mp3/**",
                			        "/error"
                			    ).permitAll()

                			    // Rotas protegidas que exigirão o Token JWT
                			    .requestMatchers("/admin/**").authenticated()
                			    .requestMatchers("/pessoas/**").authenticated()

                			    .anyRequest().authenticated()
                		) 		
                .sessionManagement(sess ->
                        sess.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                )
                .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class)
                .build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
