package br.com.fiap3espa.auto_escola_3espa.domain.instrucao;

import br.com.fiap3espa.auto_escola_3espa.domain.aluno.Aluno;
import br.com.fiap3espa.auto_escola_3espa.domain.aluno.AlunoRepository;
import br.com.fiap3espa.auto_escola_3espa.domain.instrutor.Instrutor;
import br.com.fiap3espa.auto_escola_3espa.domain.instrutor.InstrutorRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AgendaDeInstrucoes {

    @Autowired
    private InstrucaoRepository instrucaoRepository;

    @Autowired
    private AlunoRepository alunoRepository;

    @Autowired
    private InstrutorRepository instrutorRepository;

    @Transactional
    public DadosDetalhamentoInstrucao agendar(@Valid DadosAgendamentoInstrucao dados) {

        // Validação

        Aluno aluno = alunoRepository.getReferenceById(dados.idAluno());
        Instrutor instrutor = instrutorRepository.getReferenceById(dados.idInstrutor());
        Instrucao instrucao = new Instrucao(null, aluno, instrutor, dados.data());
        instrucaoRepository.save(instrucao);
        return new DadosDetalhamentoInstrucao(instrucao);
    }

}
