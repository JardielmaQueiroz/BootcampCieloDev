package cielo.clientes.domain.PessoaFisica;

public record DadosListagemPessoaFisica (String nome, Long id, String cpf, Integer mcc, String email) {
    public DadosListagemPessoaFisica(PessoaFisica pessoaFisica){
        this(pessoaFisica.getNome(),pessoaFisica.getId(),pessoaFisica.getCpf(),pessoaFisica.getMcc(),pessoaFisica.getEmail());
    }

}
