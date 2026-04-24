package br.com.fiap3espa.auto_escola_3espa.domain.cancelamento.rules;

import br.com.fiap3espa.auto_escola_3espa.domain.cancelamento.DadosCancelamentoInstrucao;

public interface ValidadorCancelamentoDeInstrucao {
    void validar(DadosCancelamentoInstrucao dados);
}
