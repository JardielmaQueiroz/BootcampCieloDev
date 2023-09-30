package cielo.clientes.domain.PessoaFisica;



public record DadosListagemAtivosPessoaFisica (String nome, Long id, String cpf, Integer mcc, String email, boolean ativo) {
    public DadosListagemAtivosPessoaFisica(PessoaFisica pessoaFisica){
        this(pessoaFisica.getNome(),pessoaFisica.getId(),pessoaFisica.getCpf(),pessoaFisica.getMcc(),pessoaFisica.getEmail(), pessoaFisica.getAtivo());
    }

}
