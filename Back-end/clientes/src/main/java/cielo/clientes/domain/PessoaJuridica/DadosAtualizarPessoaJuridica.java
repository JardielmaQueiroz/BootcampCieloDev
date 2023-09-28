package cielo.clientes.domain.PessoaJuridica;

import jakarta.validation.constraints.*;

public record DadosAtualizarPessoaJuridica (
        @NotNull Long id,
        @NotBlank @Size(min=14, max=14, message = "CNPJ deve ter exatamente 14 caracteres") String cnpj,
        @NotBlank @Size(min=1, max=50) String razaoSocial,
        @Positive @Max(9999) @Min(0001) Integer mcc,
        @NotBlank @Size(min=11, max=11, message = "CPF deve ter exatamente 11 caracteres") String cpf,
        @NotBlank @Size(min=1, max=50) String nome,
        @NotBlank @Email
        String email,
        @Positive Integer ativo
){
}
