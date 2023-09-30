package cielo.clientes.domain.PessoaJuridica;



public record DadosListagemAtivosPessoaJuridica (Long id, String cnpj, String razaoSocial,Integer mcc,String cpf,String nome,String email, boolean ativo) {
    public DadosListagemAtivosPessoaJuridica(PessoaJuridica pessoaJuridica){
        this(
                pessoaJuridica.getId(),
                pessoaJuridica.getCnpj(),
                pessoaJuridica.getRazaoSocial(),
                pessoaJuridica.getMcc(),
                pessoaJuridica.getCpf(),
                pessoaJuridica.getNome(),
                pessoaJuridica.getEmail(),
                pessoaJuridica.getAtivo());
    }

}