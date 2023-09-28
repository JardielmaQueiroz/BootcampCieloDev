package cielo.clientes.domain.PessoaFisica;

import jakarta.validation.constraints.*;

public record DadosCadastroPessoaFisica (@NotBlank @Size(min=11, max=11, message = "CPF deve ter exatamente 11 caracteres") String cpf,
                                         @Positive @Max(9999) @Min(0001) Integer mcc,
                                         @NotBlank @Size(min=1, max=50) String nome,
                                        @NotBlank @Email
                                        String email){
}
