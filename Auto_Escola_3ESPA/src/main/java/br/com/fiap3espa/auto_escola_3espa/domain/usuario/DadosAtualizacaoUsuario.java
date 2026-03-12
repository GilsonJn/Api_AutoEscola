package br.com.fiap3espa.auto_escola_3espa.domain.usuario;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoUsuario(
        @NotNull
        Long id,
        String login,
        String senha,
        Role perfil
) {
}
