package br.com.fiap3espa.auto_escola_3espa.controller;

import br.com.fiap3espa.auto_escola_3espa.domain.instrutor.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/instrutores")
public class InstrutorController {

    @Autowired
    private InstrutorRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity<DadosDetalhamentoInstrutor> cadastrarInstrutor(
            @RequestBody @Valid DadosCadastroInstrutor dados,
            UriComponentsBuilder uriBuilder) {
        Instrutor instrutor = new Instrutor(dados);
        URI uri = uriBuilder.path("/instrutores/{id}").buildAndExpand(instrutor.getId()).toUri();
        repository.save(instrutor);
        return ResponseEntity.created(uri).body(new DadosDetalhamentoInstrutor(instrutor));
    }

    @GetMapping
    public ResponseEntity<Page<DadosListagemInstrutor>> listarInstrutores(
            @PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao) {
        Page page = repository.findAllByAtivoTrue(paginacao).map(DadosListagemInstrutor::new);
        return ResponseEntity.ok(page);
    }

    @PutMapping
    @Transactional
    public ResponseEntity<DadosDetalhamentoInstrutor> atualizarInstrutor(
            @RequestBody @Valid DadosAtualizacaoInstutor dados) {
        Instrutor instrutor = repository.getReferenceById(dados.id());
        instrutor.atualizarInformacoes(dados);
        return ResponseEntity.ok(new DadosDetalhamentoInstrutor(instrutor));
    }

    @DeleteMapping("/{id}") // Padrão de mercado
    @Transactional
    public ResponseEntity<Void> excluirInstrutor(@PathVariable Long id) {
        Instrutor instrutor = repository.getReferenceById(id);
        instrutor.excluir();
        return ResponseEntity.noContent().build();
    }

    /*@DeleteMapping("/{id}") // Útil para algumas estratégias de dev front-end
    @Transactional
    public ResponseEntity<DadosDetalhamentoInstrutor> excluirInstrutor(@PathVariable Long id) {
        Instrutor instrutor = repository.getReferenceById(id);
        instrutor.excluir();
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(new DadosDetalhamentoInstrutor(instrutor));
    }*/

    @GetMapping("/{id}")
    public ResponseEntity<DadosDetalhamentoInstrutor> detalharInstrutor(@PathVariable Long id) {
        Instrutor instrutor = repository.getReferenceById(id);
        return ResponseEntity.ok(new DadosDetalhamentoInstrutor(instrutor));
    }
}