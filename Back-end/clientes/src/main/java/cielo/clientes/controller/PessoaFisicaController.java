package cielo.clientes.controller;

import jakarta.validation.Valid;
import cielo.clientes.domain.PessoaFisica.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import java.util.List;
import java.util.*;




import java.util.List;

@RestController
@RequestMapping("pessoafisica")
public class PessoaFisicaController {
    @Autowired
    private PessoaFisicaRepository repository;


    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroPessoaFisica dados, UriComponentsBuilder uriBuilder){
        //verifica se o usuário já existe
        List<PessoaFisica> verificacaoCpf = repository.findByCpf(dados.cpf());
        if(verificacaoCpf.size()==1){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Este CPF já está cadastrado!");
        }else {
            var pessoafisica = new PessoaFisica(dados);
            repository.save(pessoafisica);
            var uri = uriBuilder.path("/pessoafisica/{id}").buildAndExpand(pessoafisica.getId()).toUri();
            return ResponseEntity.created(uri).body(new DadosDetalhamentoPessoaFisica(pessoafisica));
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity detalhar(@PathVariable Long id) {
        //verifica se o usuário já existe
        var verificacaoID = repository.findById(id);
        if(verificacaoID.isEmpty()){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Usuário não encontrado!");
        }
        {
            var pessoafisica = repository.getReferenceById(id);
            return ResponseEntity.ok(new DadosDetalhamentoPessoaFisica(pessoafisica));
        }
    }

    @GetMapping
    public List<DadosListagemPessoaFisica> listar(){
        return repository.findAll().stream().map(DadosListagemPessoaFisica::new).toList();
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid DadosAtualizarPessoaFisica dados){


        var verificacaoID = repository.findById(dados.id());
        if(verificacaoID.isEmpty()){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Usuário não encontrado!");
        }
        //verifica se o usuário já existe
        List<PessoaFisica> verificacaoCpf = repository.findByCpf(dados.cpf());
        if(verificacaoCpf.size()==0){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Não foi possível fazer a atualização" +
                    "pois o CPF não pode ser alterado!");
        }else {
            var pessoafisica =repository.getReferenceById(dados.id());
            pessoafisica.atualizar(dados);
            return ResponseEntity.ok(new DadosDetalhamentoPessoaFisica(pessoafisica));
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity excluir(@PathVariable Long id) {
        //verifica se o usuário já existe
        var verificacaoID = repository.findById(id);
        if(verificacaoID.isEmpty()){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Usuário não encontrado!");
        }
        {
            var pessoafisica = repository.getReferenceById(id);
            pessoafisica.excluir();
            repository.save(pessoafisica);
            return ResponseEntity.noContent().build();
        }
    }


}
