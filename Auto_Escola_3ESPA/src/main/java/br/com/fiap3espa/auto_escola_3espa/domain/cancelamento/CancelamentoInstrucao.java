package br.com.fiap3espa.auto_escola_3espa.domain.cancelamento;

import br.com.fiap3espa.auto_escola_3espa.domain.instrucao.Instrucao;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity(name = "CancelamentoInstrucao")
@Table(name = "cancelamento_instrucao")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class CancelamentoInstrucao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "instrucao_id")
    private Instrucao instrucao;

    @Enumerated(EnumType.STRING)
    private MotivoCancelamento motivo;

}
