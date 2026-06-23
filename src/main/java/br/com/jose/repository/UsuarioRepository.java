package br.com.jose.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.jose.model.Usuario;

	
	

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Usuario findByLogin(String login);

}


