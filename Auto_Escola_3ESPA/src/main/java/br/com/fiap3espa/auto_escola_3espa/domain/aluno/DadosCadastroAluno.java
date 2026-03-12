package br.com.fiap3espa.auto_escola_3espa.domain.aluno;

import br.com.fiap3espa.auto_escola_3espa.domain.endereco.DadosEndereco;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record DadosCadastroAluno(

        @NotBlank
        String nome,

        @NotBlank
        @Email
        String email,

        @NotBlank
        String telefone,

        @NotBlank
        @Pattern(regexp = "\\d{9,11}")
        String cpf,

        @NotNull
        @Valid
        DadosEndereco endereco
) {
}
