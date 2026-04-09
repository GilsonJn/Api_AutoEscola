package br.com.fiap3espa.auto_escola_3espa.domain.instrucao;

import br.com.fiap3espa.auto_escola_3espa.domain.aluno.Aluno;
import br.com.fiap3espa.auto_escola_3espa.domain.aluno.AlunoNotFoundException;
import br.com.fiap3espa.auto_escola_3espa.domain.aluno.AlunoRepository;
import br.com.fiap3espa.auto_escola_3espa.domain.instrucao.rules.ValidacoesDeAgendamento;
import br.com.fiap3espa.auto_escola_3espa.domain.instrutor.Instrutor;
import br.com.fiap3espa.auto_escola_3espa.domain.instrutor.InstrutorNotFoundException;
import br.com.fiap3espa.auto_escola_3espa.domain.instrutor.InstrutorRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AgendaDeInstrucoes {

    @Autowired
    private InstrucaoRepository instrucaoRepository;

    @Autowired
    private AlunoRepository alunoRepository;

    @Autowired
    private InstrutorRepository instrutorRepository;

    @Autowired
    private List<ValidacoesDeAgendamento> validadoresAgendamento;

    @Transactional
    public DadosDetalhamentoInstrucao agendar(@Valid DadosAgendamentoInstrucao dados) {

        // Validação
        if(!alunoRepository.existsById(dados.idAluno())) {
            throw new AlunoNotFoundException("ID do auluno informado não existe!");
        }
        if(dados.idInstrutor() != null && !instrutorRepository.existsById(dados.idInstrutor())) {
            throw new InstrutorNotFoundException("ID do instrutor informado não existe!");
        }

        // Regra de negócio
        validadoresAgendamento.forEach(v -> v.validar(dados));

        Aluno aluno = alunoRepository.getReferenceById(dados.idAluno());
        Instrutor instrutor = escolherInstrutor(dados);

        if(instrutor == null) {
            throw new ValidacaoException("Não existe instrutor disponivel na data/hora informada!");
        }

        Instrucao instrucao = new Instrucao(null, aluno, instrutor, dados.data());
        instrucaoRepository.save(instrucao);
        return new DadosDetalhamentoInstrucao(instrucao);
    }

    public Instrutor escolherInstrutor(DadosAgendamentoInstrucao dados) {
        if(dados.idInstrutor() != null) {
            return instrutorRepository.getReferenceById(dados.idInstrutor());
        }
        if(dados.especialidade() == null) {
            throw new ValidacaoException("Especialidade é obrigatória, quando o isntrutor não for informado!");
        }
        return instrutorRepository.escolherInstrutorAleatorioDisponivel(dados.especialidade(), dados.data());
    }

}
