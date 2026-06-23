package br.com.jose.DTO;

public class PessoaDTO {

    private Long id;
    private String nome;
    private String nota;
    private Long nomeId;

    // ✅ obrigatório para o Spring
    public PessoaDTO() {
    }

    public PessoaDTO(Long id, String nome, String nota, Long nomeId) {
        this.id = id;
        this.nome = nome;
        this.nota = nota;
        this.nomeId = nomeId;
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNota() {
		return nota;
	}

	public void setNota(String nota) {
		this.nota = nota;
	}

	public Long getNomeId() {
		return nomeId;
	}

	public void setNomeId(Long nomeId) {
		this.nomeId = nomeId;
	}
}
   