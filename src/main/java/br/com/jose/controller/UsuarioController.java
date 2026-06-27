package br.com.jose.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.crypto.password.PasswordEncoder;
import br.com.jose.model.Usuario;

import br.com.jose.repository.UsuarioRepository;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/usuario")


public class UsuarioController {
	@GetMapping("/teste")
	public String teste() {
	    return "ok";
	}
	
	@Autowired
	private PasswordEncoder encoder;
	
	@Autowired
    private UsuarioRepository usuarioRepository;

    // LISTAR
    @GetMapping
    public List<Usuario> listarUsuarios() {
        return usuarioRepository.findAll();
    }

    // INCLUIR
    @PostMapping
    public Usuario incluirUsuario(@RequestBody Usuario usuario) {

        usuario.setSenha(
            encoder.encode(usuario.getSenha())
        );

        return usuarioRepository.save(usuario);
    }
    
    
    
    
    
    

    // ALTERAR
    //@PutMapping("/{id}")
    //public Usuario alterarUsuario(@PathVariable Long id, @RequestBody Usuario usuarioAtualizado) {
    //    return usuarioRepository.findById(id)
    //        .map(u -> {
    //            u.setLogin(usuarioAtualizado.getLogin());
    //            u.setSenha(usuarioAtualizado.getSenha());
    //            u.setPerfil(usuarioAtualizado.getPerfil());
    //            u.setTipo(usuarioAtualizado.getTipo()); // ⭐ FALTAVA ISSO
    //            return usuarioRepository.save(u);
    //        })
    //        .orElseThrow(() -> new RuntimeException("Usuário não encontrado: " + id));
    //}

    @PutMapping("/{id}")
    public Usuario alterar(
            @PathVariable Long id,
            @RequestBody Usuario usuario){

        Usuario u =
            usuarioRepository.findById(id)
            .orElseThrow(() ->
                new RuntimeException("Usuário não encontrado")
            );

        u.setLogin(usuario.getLogin());

        u.setSenha(
            encoder.encode(usuario.getSenha())
        );

        u.setPerfil(usuario.getPerfil());

        u.setTipo(usuario.getTipo());

        return usuarioRepository.save(u);
    }
    // EXCLUIR
    @DeleteMapping("/{id}")
    public void excluirUsuario(@PathVariable Long id) {
        usuarioRepository.deleteById(id);
    }
	

}
