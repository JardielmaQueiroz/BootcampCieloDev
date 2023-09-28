package cielo.clientes.controller;

import jakarta.validation.Valid;
import cielo.clientes.domain.PessoaJuridica.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("pessoajuridica")
public class PessoaJuridicaController {
    @Autowired
    private PessoaJuridicaRepository repository;


    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastrarPessoaJuridica dados, UriComponentsBuilder uriBuilder){
        var pessoaJuridica = new PessoaJuridica(dados);
        repository.save(pessoaJuridica);

        var uri = uriBuilder.path("/pessoajuridica/{id}").buildAndExpand(pessoaJuridica.getId()).toUri();

        return ResponseEntity.created(uri).body(new DadosDetalhamentoPessoaJuridica(pessoaJuridica));
    }

    @GetMapping("/{id}")
    public ResponseEntity detalhar(@PathVariable Long id) {
        var pessoaJuridica =repository.getReferenceById(id);
        return ResponseEntity.ok(new DadosDetalhamentoPessoaJuridica(pessoaJuridica));
    }

    @GetMapping
    public List<DadosListagemPessoaJuridica> listar(){
        return repository.findAll().stream().map(DadosListagemPessoaJuridica::new).toList();
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid DadosAtualizarPessoaJuridica dados){
        var pessoaJuridica =repository.getReferenceById(dados.id());
        pessoaJuridica.atualizar(dados);
        return ResponseEntity.ok(new DadosDetalhamentoPessoaJuridica(pessoaJuridica));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity excluir(@PathVariable Long id) {
        var pessoaJuridica =repository.getReferenceById(id);
        pessoaJuridica.excluir();
        repository.save(pessoaJuridica);
        return ResponseEntity.noContent().build();
    }


}
