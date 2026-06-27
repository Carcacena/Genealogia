package br.com.jose.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.jose.DTO.PessoaDTO;
import br.com.jose.model.Pessoa;
import br.com.jose.repository.PessoaRepository;

@RestController
@RequestMapping("/pessoas")
public class PessoaController {

    @Autowired
    private PessoaRepository pessoaRepository;

    // ==========================
    // LISTAR
    // ==========================
    @GetMapping
    public List<PessoaDTO> listarPessoas() {
        return pessoaRepository.findAll()
                .stream()
                .map(p -> new PessoaDTO(
                        p.getId(),
                        p.getNome(),
                        p.getNota(),
                        p.getNomeId()))
                .toList();
    }

    // ==========================
    // SALVAR
    // ==========================
    @PostMapping
    public PessoaDTO salvarPessoa(@RequestBody PessoaDTO pessoaDTO) {
        Pessoa p = new Pessoa();
        p.setNome(pessoaDTO.getNome());
        p.setNota(pessoaDTO.getNota());
        p.setNomeId(pessoaDTO.getNomeId());
        pessoaRepository.save(p);

        return new PessoaDTO(p.getId(), p.getNome(), p.getNota(), p.getNomeId());
    }

    // ==========================
    // MOVER
    // ==========================
    @PostMapping("/mover")
    public String mover(@RequestBody Map<String, Long> dados) {

        Long childId = dados.get("childId");
        Long newParentId = dados.get("newParentId");

        Pessoa filho = pessoaRepository.findById(childId)
                .orElseThrow(() -> new RuntimeException("Pessoa não encontrada"));

        if (childId.equals(newParentId)) return "Erro: não pode mover para si mesmo";

        if (isDescendente(childId, newParentId)) return "Erro: não pode mover para filho/neto";

        filho.setNomeId(newParentId);
        pessoaRepository.save(filho);

        return "OK";
    }

    // ==========================
    // ALTERAR NOME + NOTA
    // ==========================
    @PostMapping("/alterar")
    public ResponseEntity<String> alterar(@RequestBody Map<String, String> dados){
        try {
            Long id = Long.parseLong(dados.get("id"));
            String novoNome = dados.get("novoNome");
            String novaNota = dados.get("novaNota");

            Pessoa p = pessoaRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("Pessoa não encontrada"));

            p.setNome(novoNome);
            p.setNota(novaNota);

            pessoaRepository.save(p);

            return ResponseEntity.ok("OK");

        } catch(Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    // ==========================
    // VALIDAÇÃO DE CICLO
    // ==========================
    private boolean isDescendente(Long origemId, Long destinoId) {
        List<Pessoa> lista = pessoaRepository.findAll();
        return verificar(origemId, destinoId, lista);
    }

    private boolean verificar(Long origemId, Long destinoId, List<Pessoa> lista) {
        for (Pessoa p : lista) {
            if (origemId.equals(p.getNomeId())) {
                if (p.getId().equals(destinoId)) return true;
                if (verificar(p.getId(), destinoId, lista)) return true;
            }
        }
        return false;
    }
}