package cielo.clientes.domain.PessoaJuridica;

public record DadosDetalhamentoPessoaJuridica (Long id, String cnpj, String razaoSocial,Integer mcc,String cpf,String nome,String email) {
    public DadosDetalhamentoPessoaJuridica(PessoaJuridica pessoaJuridica){
        this(
                pessoaJuridica.getId(),
                pessoaJuridica.getCnpj(),
                pessoaJuridica.getRazaoSocial(),
                pessoaJuridica.getMcc(),
                pessoaJuridica.getCpf(),
                pessoaJuridica.getNome(),
                pessoaJuridica.getEmail());
    }

}