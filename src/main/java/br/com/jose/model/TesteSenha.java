package br.com.jose.model;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class TesteSenha {
    public static void main(String[] args) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        // Hash que está no banco
        String hashBanco = "$2a$10$R5eYlXDMNTmio8SElW/E2.zH53Tbnh/E2O5M2yMtey5cWBmXLmJPi";

        // Testa se "123" corresponde ao hash
        boolean confere = encoder.matches("123", hashBanco);
        System.out.println("Senha '123' confere? " + confere);

        // Se quiser gerar um novo hash para "123"
        String novoHash = encoder.encode("123");
        System.out.println("Novo hash para '123': " + novoHash);
    }
}