package cielo.clientes.domain.PessoaFisica;

import jakarta.persistence.*;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import cielo.clientes.domain.PessoaFisica.DadosCadastroPessoaFisica;

@Table(name = "pessoafisica")
@Entity(name = "PessoaFisica")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class PessoaFisica {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String cpf;

    private Boolean ativo;
    private Integer mcc;
    private String nome;
    private String email;


    public PessoaFisica(DadosCadastroPessoaFisica dados) {
        this.ativo = true;
        this.nome = dados.nome();
        this.mcc = dados.mcc();
        this.email = dados.email();
        this.cpf = dados.cpf();
    }

    public void atualizar(DadosAtualizarPessoaFisica dados){
        if (dados.nome() != null) {
            this.nome = dados.nome();
        }
        if (dados.cpf() != null) {
            this.cpf = dados.cpf();
        }
        if (dados.mcc() != null) {
            this.mcc = dados.mcc();
        }
        if (dados.email() != null) {
            this.email = dados.email();
        }
    }

    public void excluir() {
        this.ativo = false;
    }
}
