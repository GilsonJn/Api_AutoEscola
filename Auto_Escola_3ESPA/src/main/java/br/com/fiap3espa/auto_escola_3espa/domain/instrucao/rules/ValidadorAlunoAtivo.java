package br.com.fiap3espa.auto_escola_3espa.domain.instrucao.rules;

import br.com.fiap3espa.auto_escola_3espa.domain.aluno.AlunoRepository;
import br.com.fiap3espa.auto_escola_3espa.domain.instrucao.DadosAgendamentoInstrucao;
import br.com.fiap3espa.auto_escola_3espa.domain.instrucao.ValidacaoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidadorAlunoAtivo implements ValidacoesDeAgendamento {
    @Autowired
    private AlunoRepository repository;

    @Override
    public void validar(DadosAgendamentoInstrucao dados) {
        Boolean aluniAtivo = repository.findAtivoById(dados.idAluno());

        if (!aluniAtivo) {
            throw new ValidacaoException("Instrução não pode ser agendada por alunos inativo!");
        }
    }
}
