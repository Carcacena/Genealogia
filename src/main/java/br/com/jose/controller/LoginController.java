package br.com.jose.controller;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.jose.DTO.LoginDTO;
import br.com.jose.service.BlacklistService;
import br.com.jose.model.Usuario;
import br.com.jose.repository.UsuarioRepository;
import br.com.jose.security.JwtService;

@RestController
@RequestMapping("/auth")
public class LoginController {

   
    private UsuarioRepository usuarioRepository;

  
    private PasswordEncoder encoder;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private BlacklistService blacklistService;

    @PostMapping("/logout")
    public ResponseEntity<Void> logout(@RequestHeader("Authorization") String token) {
        blacklistService.add(token);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/login")
    public ResponseEntity<Map<String, String>> login(@RequestBody LoginDTO login) {
        Usuario user = usuarioRepository.findByLogin(login.getLogin());

        if (user != null && encoder.matches(login.getSenha(), user.getSenha())) {
            String token = jwtService.gerarToken(user.getLogin(), user.getPerfil());
            Map<String, String> response = new HashMap<>();
            response.put("token", token);
            return ResponseEntity.ok(response);
        }

        return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                             .body(Collections.singletonMap("error", "Login inválido"));
    }
}
