package cielo.clientes.domain.PessoaJuridica;

public record DadosListagemPessoaJuridica (Long id, String cnpj, String razaoSocial,Integer mcc,String cpf,String nome,String email) {
    public DadosListagemPessoaJuridica(PessoaJuridica pessoaJuridica){
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
