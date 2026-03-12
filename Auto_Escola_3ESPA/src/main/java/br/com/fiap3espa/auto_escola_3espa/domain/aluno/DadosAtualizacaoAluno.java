package br.com.fiap3espa.auto_escola_3espa.domain.aluno;

import br.com.fiap3espa.auto_escola_3espa.domain.endereco.DadosEndereco;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoAluno(
        @NotNull
        Long id,
        String nome,
        String telefone,
        DadosEndereco endereco
) {
}
