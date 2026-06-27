package br.com.jose.DTO;

import java.util.List;

public class UsuarioDTO {
	  private Long id;
	    private String login;
	    private String perfil;
	    private int tipo;

	    public UsuarioDTO(Long id, String login, String perfil, int tipo) {
	        this.id = id;
	        this.login = login;
	        this.perfil = perfil;
	        this.tipo = tipo;
	    }

//	    public List<UsuarioDTO> listarUsuarios() {
//	        Object usuarioRepository;
//			return usuarioRepository.findAll()
//	                .stream()
//	                .map(u -> new UsuarioDTO(
//	                        u.getId(),
//	                        u.getLogin(),
//	                        u.getPerfil(),
//	                        u.getTipo()
//	                ))
//	                .toList();
//	    }
//	    public Long getId() {
//	        return id;
//	    }

	    public String getLogin() {
	        return login;
	    }

	    public String getPerfil() {
	        return perfil;
	    }

	    public int getTipo() {
	        return tipo;
	    }
	}


