package br.com.fiap3espa.auto_escola_3espa.domain.aluno;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {
    Page<Aluno> findAllByAtivoTrue(Pageable paginacao);

    @Query("""
            select e.ativo
            from Aluno e
            where 
            e.id = :id
        """)
    Boolean findAtivoById(Long id);
}
