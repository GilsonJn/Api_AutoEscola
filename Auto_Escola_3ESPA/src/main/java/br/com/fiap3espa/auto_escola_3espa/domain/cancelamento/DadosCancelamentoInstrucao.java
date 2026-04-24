package br.com.fiap3espa.auto_escola_3espa.domain.cancelamento;

import jakarta.validation.constraints.NotNull;

public record DadosCancelamentoInstrucao(
        @NotNull
        Long idInstrucao,

        @NotNull
        MotivoCancelamento motivo
) {
}
