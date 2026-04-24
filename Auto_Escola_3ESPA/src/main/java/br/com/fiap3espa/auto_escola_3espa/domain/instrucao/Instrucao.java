package br.com.fiap3espa.auto_escola_3espa.domain.instrucao;

import br.com.fiap3espa.auto_escola_3espa.domain.aluno.Aluno;
import br.com.fiap3espa.auto_escola_3espa.domain.instrutor.Instrutor;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity(name = "Instrucao")
@Table(name = "instrucoes")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Instrucao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "aluno_id")
    private Aluno aluno;

    @ManyToOne
    @JoinColumn(name = "instrutor_id")
    private Instrutor instrutor;

    private LocalDateTime data;

    private Boolean ativo;

    public void cancelar() {
        this.ativo = false;
    }

}
