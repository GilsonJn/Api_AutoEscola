package br.com.fiap3espa.auto_escola_3espa.infra.security;

import br.com.fiap3espa.auto_escola_3espa.domain.usuario.Usuario;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {
    public String gerarToken(Usuario usuario) {
        try {
            Algorithm algorithm = Algorithm.HMAC256("12345678");
            return JWT.create()
                    .withIssuer("Auto Escola 3ESPA")
                    .withSubject(usuario.getLogin())
                    .withExpiresAt(dataExpiracao())
                    .sign(algorithm);
        } catch (JWTCreationException exception){
            throw new RuntimeException("Erro ao gerar o token JWT.");
        }
    }

    private Instant dataExpiracao() {
        return LocalDateTime.now().plusMinutes(30)
                .toInstant(ZoneOffset.of("-03:00"));
    }
}