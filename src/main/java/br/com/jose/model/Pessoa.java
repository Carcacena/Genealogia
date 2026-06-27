package br.com.jose.model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;


import jakarta.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import br.com.jose.DTO.PessoaDTO;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "pessoa")
public class Pessoa {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;  // casal ou pessoa única

    @Column(length = 255)
    private String nota;

    @Column(name = "nome_id")
    private Long nomeId;  // referência ao pai/casal anterior

    // Getters e Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getNota() { return nota; }
    public void setNota(String nota) { this.nota = nota; }

    public Long getNomeId() { return nomeId; }
    public void setNomeId(Long nomeId) { this.nomeId = nomeId; }
}
