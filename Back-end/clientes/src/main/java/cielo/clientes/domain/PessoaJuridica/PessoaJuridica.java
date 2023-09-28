package cielo.clientes.domain.PessoaJuridica;

import jakarta.persistence.*;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import cielo.clientes.domain.PessoaJuridica.DadosCadastrarPessoaJuridica;

@Table(name = "pessoajuridica")
@Entity(name = "PessoaJuridica")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class PessoaJuridica {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String cnpj;
    private String razaoSocial;
    private Integer mcc;
    private String cpf;
    private String nome;
    private String email;
    private Boolean ativo;

    public PessoaJuridica(DadosCadastrarPessoaJuridica dados) {
        this.cnpj = dados.cnpj();
        this.razaoSocial = dados.razaoSocial();
        this.mcc = dados.mcc();
        this.cpf = dados.cpf();
        this.nome = dados.nome();
        this.email = dados.email();
        this.ativo = true;
    }

    public void atualizar(DadosAtualizarPessoaJuridica dados){
        if (dados.cnpj() != null) {
            this.cnpj = dados.cnpj();
        }
        if (dados.razaoSocial() != null) {
            this.razaoSocial = dados.razaoSocial();
        }
        if (dados.mcc() != null) {
            this.mcc = dados.mcc();
        }
        if (dados.cpf() != null) {
            this.cpf = dados.cpf();
        }
        if (dados.nome() != null) {
            this.nome = dados.nome();
        }
        if (dados.email() != null) {
            this.email = dados.email();
        }
    }




    public void excluir() {
        this.ativo = false;
    }
}
