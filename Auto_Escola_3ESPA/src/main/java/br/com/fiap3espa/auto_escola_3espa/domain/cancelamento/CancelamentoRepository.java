package br.com.fiap3espa.auto_escola_3espa.domain.cancelamento;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CancelamentoRepository extends JpaRepository<CancelamentoInstrucao, Long> {
}
