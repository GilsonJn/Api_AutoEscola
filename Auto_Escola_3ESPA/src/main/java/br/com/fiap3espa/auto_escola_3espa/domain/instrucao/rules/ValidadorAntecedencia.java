package br.com.fiap3espa.auto_escola_3espa.domain.instrucao.rules;

import br.com.fiap3espa.auto_escola_3espa.domain.instrucao.DadosAgendamentoInstrucao;
import br.com.fiap3espa.auto_escola_3espa.domain.instrucao.ValidacaoException;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDateTime;

@Component
public class ValidadorAntecedencia implements ValidacoesDeAgendamento{
    @Override
    public void validar(DadosAgendamentoInstrucao dados) {
        LocalDateTime dataInstrucao = dados.data();
        LocalDateTime agora = LocalDateTime.now();

        Long antecedencia = Duration.between(agora, dataInstrucao).toMinutes();

        if(antecedencia < 30){
            throw new ValidacaoException("Instrução deve ser agendada com antecedencia minina de 30 minutos");
        }
    }
}
