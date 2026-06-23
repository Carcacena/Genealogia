package br.com.jose.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.jose.model.Pessoa;


public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
	
	    // Buscar por nome (ignore case)
	    List<Pessoa> findByNomeContainingIgnoreCase(String nome);
	}


	
