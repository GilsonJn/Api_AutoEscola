package br.com.fiap3espa.auto_escola_3espa.domain.cancelamento.rules;

import br.com.fiap3espa.auto_escola_3espa.domain.cancelamento.DadosCancelamentoInstrucao;
import br.com.fiap3espa.auto_escola_3espa.domain.instrucao.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDateTime;

@Component
public class ValidadorAntecedenciaCancelamento implements ValidadorCancelamentoDeInstrucao{

    @Autowired
    private InstrucaoRepository repository;

    @Override
    public void validar(DadosCancelamentoInstrucao dados) {
        Instrucao instrucao = repository.getReferenceById(dados.idInstrucao());
        LocalDateTime agora =  LocalDateTime.now();
        Long antecedencia = Duration.between(agora,instrucao.getData()).toHours();

        if (antecedencia < 24) {
            throw new ValidacaoException("Instrução somente pode ser cancelada com 24h de antecedência!");
        }
    }
}
