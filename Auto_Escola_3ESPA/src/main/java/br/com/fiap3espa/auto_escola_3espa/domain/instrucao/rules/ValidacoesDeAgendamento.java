package br.com.fiap3espa.auto_escola_3espa.domain.instrucao.rules;

import br.com.fiap3espa.auto_escola_3espa.domain.instrucao.DadosAgendamentoInstrucao;

public interface ValidacoesDeAgendamento {
    void validar(DadosAgendamentoInstrucao dados);
}
