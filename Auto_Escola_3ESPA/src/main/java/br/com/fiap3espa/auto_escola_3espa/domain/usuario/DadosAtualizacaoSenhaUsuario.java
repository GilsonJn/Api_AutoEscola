package br.com.fiap3espa.auto_escola_3espa.domain.usuario;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoSenhaUsuario(
        @NotNull
        Long id,
        String senha
) {
}
