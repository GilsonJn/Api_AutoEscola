package br.com.fiap3espa.auto_escola_3espa.domain.cancelamento;

import br.com.fiap3espa.auto_escola_3espa.domain.cancelamento.rules.ValidadorCancelamentoDeInstrucao;
import br.com.fiap3espa.auto_escola_3espa.domain.instrucao.Instrucao;
import br.com.fiap3espa.auto_escola_3espa.domain.instrucao.InstrucaoRepository;
import br.com.fiap3espa.auto_escola_3espa.domain.instrucao.ValidacaoException;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CancelarAgenda {

    @Autowired
    private InstrucaoRepository instrucaoRepository;

    @Autowired
    private CancelamentoRepository cancelamentoRepository;

    @Autowired
    private List<ValidadorCancelamentoDeInstrucao> validadoresCancelamento;

    @Transactional
    public void cancelar(@Valid  DadosCancelamentoInstrucao dados) {
        if (!instrucaoRepository.existsById(dados.idInstrucao())){
            throw new ValidacaoException("Id da instrução informado não existe!");
        }

        validadoresCancelamento.forEach(v -> v.validar(dados));

        Instrucao instrucao = instrucaoRepository.getReferenceById(dados.idInstrucao());
        CancelamentoInstrucao cancelamento = new CancelamentoInstrucao(null, instrucao, dados.motivo());
        cancelamentoRepository.save(cancelamento);

        instrucao.cancelar();
    }
}
