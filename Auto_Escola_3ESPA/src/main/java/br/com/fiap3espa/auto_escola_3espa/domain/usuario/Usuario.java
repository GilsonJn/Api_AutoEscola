package br.com.fiap3espa.auto_escola_3espa.domain.usuario;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Collection;
import java.util.List;

@Entity(name = "Usuario")
@Table(name = "usuarios")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Usuario implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Boolean ativo;
    private String login;
    private String senha;

    @Enumerated(EnumType.STRING)
    private Role perfil;

    public Usuario(DadosCadastroUsuario dados) {
        this.ativo = true;
        this.login = dados.login();
        this.senha = encriptador(dados.senha());
        this.perfil = dados.perfil();
    }

    public void atualizarInformacoes(DadosAtualizacaoUsuario dados){
        if (dados.login() != null) {
            this.login = dados.login();
        }
        if (dados.senha() != null) {
            this.senha = encriptador(dados.senha());
        }
        if (dados.perfil() != null) {
            this.perfil = dados.perfil();
        }
    }

    public void atualizarSenha(DadosAtualizacaoSenhaUsuario dados){
        if (dados.senha() != null) {
            this.senha = encriptador(dados.senha());
        }
    }

    public String encriptador(String senha){
        PasswordEncoder encoder = new BCryptPasswordEncoder();
        String hash = encoder.encode(senha);
        return hash;
    }

    public void excluir(){ this.ativo = false; }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("ROLE_" + perfil));
    }

    @Override
    public String getPassword() {
        return senha;
    }

    @Override
    public String getUsername() {
        return login;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

}
