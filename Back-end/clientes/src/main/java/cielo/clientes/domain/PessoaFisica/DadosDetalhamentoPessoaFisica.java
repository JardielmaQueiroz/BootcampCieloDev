package cielo.clientes.domain.PessoaFisica;

public record DadosDetalhamentoPessoaFisica (Long id, String nome, String email, Integer mcc, String cpf){
    public DadosDetalhamentoPessoaFisica(PessoaFisica pessoafisica){
        this(pessoafisica.getId(), pessoafisica.getNome(), pessoafisica.getEmail(), pessoafisica.getMcc(), pessoafisica.getCpf());
    }
}
