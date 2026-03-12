package br.com.fiap3espa.auto_escola_3espa.domain.usuario;

public record DadosDetalhamentoUsuario(
        Long id,
        String login,
        Role perfil
) {
    public DadosDetalhamentoUsuario(Usuario usuario) {
        this(usuario.getId(), usuario.getLogin(), usuario.getPerfil());
    }
}
