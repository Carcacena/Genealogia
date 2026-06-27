package br.com.jose.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.jose.DTO.PessoaDTO;
import br.com.jose.model.Pessoa;
import br.com.jose.repository.PessoaRepository;
import jakarta.transaction.Transactional;

//Correto para Spring Boot
//import org.springframework.transaction.annotation.Transactional;


@Service
public class PessoaService {
	private final PessoaRepository pessoaRepository;

    public PessoaService(PessoaRepository pessoaRepository) {
        this.pessoaRepository = pessoaRepository;
    }

    // Buscar todas as pessoas
    public List<Pessoa> findAll() {
        return pessoaRepository.findAll();
    }

    // Buscar por nome (contendo texto)
    public List<Pessoa> findByNome(String nome) {
        return pessoaRepository.findByNomeContainingIgnoreCase(nome);
    }

    // Salvar ou atualizar
    public Pessoa save(Pessoa pessoa) {
        return pessoaRepository.save(pessoa);
    }
}
	
	
	
