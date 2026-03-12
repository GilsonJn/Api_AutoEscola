package br.com.fiap3espa.auto_escola_3espa.domain.aluno;

import br.com.fiap3espa.auto_escola_3espa.domain.endereco.Endereco;

public record DadosDetalhamentoAluno(
        Long id,
        String nome,
        String email,
        String telefone,
        String cpf,
        Endereco endereco
) {
    public DadosDetalhamentoAluno(Aluno aluno) {
        this(aluno.getId(), aluno.getNome(), aluno.getEmail(), aluno.getTelefone(), aluno.getCpf(), aluno.getEndereco());
    }
}
