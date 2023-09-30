package cielo.clientes.controller;

import cielo.clientes.domain.PessoaFisica.DadosListagemAtivosPessoaFisica;
import cielo.clientes.domain.PessoaFisica.PessoaFisica;
import jakarta.validation.Valid;
import cielo.clientes.domain.PessoaJuridica.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("pessoajuridica")
public class PessoaJuridicaController {
    @Autowired
    private PessoaJuridicaRepository repository;


    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastrarPessoaJuridica dados, UriComponentsBuilder uriBuilder){
        if(!verificaEmail(dados.email())){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("E-mail inválido!");
        }
        //verifica se o usuário já existe
        List<PessoaJuridica> verificacaoCnpj = repository.findByCnpj(dados.cnpj());
        if(verificacaoCnpj.size()==1){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Este CNPJ já está cadastrado!");
        }else {
            var pessoaJuridica = new PessoaJuridica(dados);
            repository.save(pessoaJuridica);
            var uri = uriBuilder.path("/pessoajuridica/{id}").buildAndExpand(pessoaJuridica.getId()).toUri();
            return ResponseEntity.created(uri).body(new DadosDetalhamentoPessoaJuridica(pessoaJuridica));
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
            var pessoaJuridica = repository.getReferenceById(id);
            return ResponseEntity.ok(new DadosDetalhamentoPessoaJuridica(pessoaJuridica));
        }
    }

    @GetMapping
    public List<DadosListagemPessoaJuridica> listar(){
        return repository.findAll().stream().map(DadosListagemPessoaJuridica::new).toList();
    }

    @GetMapping("/ativos")
    public List<DadosListagemAtivosPessoaJuridica> listarAtivos(){
        List<PessoaJuridica> lista =repository.findAll();
        ArrayList<PessoaJuridica> retorno = new ArrayList<PessoaJuridica>();
        for(PessoaJuridica item : lista){
            if(item.getAtivo()){
                retorno.add(item);
            }
        }
        return retorno.stream().map(DadosListagemAtivosPessoaJuridica::new).toList();
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid DadosAtualizarPessoaJuridica dados){

        //verifica se o usuário já existe
        var verificacaoID = repository.findById(dados.id());
        if(verificacaoID.isEmpty()){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Usuário não encontrado!");
        }
        //verifica se o usuário já existe
        List<PessoaJuridica> verificacaoCnpj = repository.findByCnpj(dados.cnpj());
        //Verifica se o CNPJ já existe
        if(verificacaoCnpj.size()==0){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Não foi possível fazer a atualização" +
                    "pois este CNPJ não pode ser alterado!");
        }
        var pessoaJuridica = repository.getReferenceById(dados.id());
        pessoaJuridica.atualizar(dados);
        return ResponseEntity.ok(new DadosDetalhamentoPessoaJuridica(pessoaJuridica));

    }

    @DeleteMapping("/{id}")
    public ResponseEntity excluir(@PathVariable Long id) {
        //verifica se o usuário já existe
        var verificacaoID = repository.findById(id);
        if(verificacaoID.isEmpty()){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Usuário não encontrado!");
        }
        {
            var pessoaJuridica = repository.getReferenceById(id);
            pessoaJuridica.excluir();
            repository.save(pessoaJuridica);
            return ResponseEntity.noContent().build();
        }
    }
    public boolean verificaEmail(String email){
        boolean isEmailIdValid = false;
        if (email != null && email.length() > 0) {
            String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
            Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(email);
            if (matcher.matches()) {
                isEmailIdValid = true;
            }
        }
        return isEmailIdValid;
    }


}
