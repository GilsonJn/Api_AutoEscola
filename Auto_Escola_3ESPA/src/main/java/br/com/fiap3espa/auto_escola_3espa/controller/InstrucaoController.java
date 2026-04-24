package br.com.fiap3espa.auto_escola_3espa.controller;

import br.com.fiap3espa.auto_escola_3espa.domain.cancelamento.CancelarAgenda;
import br.com.fiap3espa.auto_escola_3espa.domain.cancelamento.DadosCancelamentoInstrucao;
import br.com.fiap3espa.auto_escola_3espa.domain.instrucao.AgendaDeInstrucoes;
import br.com.fiap3espa.auto_escola_3espa.domain.instrucao.DadosAgendamentoInstrucao;
import br.com.fiap3espa.auto_escola_3espa.domain.instrucao.DadosDetalhamentoInstrucao;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/instrucoes")
public class InstrucaoController {

    @Autowired
    private AgendaDeInstrucoes agenda;

    @Autowired
    private CancelarAgenda cancelamento;

    @PostMapping
    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    public ResponseEntity agendarInstrucoes(@RequestBody @Valid DadosAgendamentoInstrucao dados){
        DadosDetalhamentoInstrucao dto = agenda.agendar(dados);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping
    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    public ResponseEntity cancelarInstrucao(@RequestBody @Valid DadosCancelamentoInstrucao dados){
        cancelamento.cancelar(dados);
        return ResponseEntity.noContent().build();
    }

}
