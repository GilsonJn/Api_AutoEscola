package br.com.fiap3espa.auto_escola_3espa.domain.usuario;

import jakarta.validation.constraints.NotNull;

public record DadosCadastroUsuario(

        @NotNull
        String login,

        @NotNull
        //@Pattern(regexp = "\\d{8,12}")
        //@Size(min = 8, max = 12)
        String senha,

        @NotNull
        Role perfil
) {
}
