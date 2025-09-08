package com.sprint.MottuFlow.domain.autenticao;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.sprint.MottuFlow.infra.exception.RegraDeNegocioException;
import com.sprint.MottuFlow.domain.funcionario.Funcionario;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {
	
	/*
	 * Serviço responsável por gerar tokens JWT para autenticação de usuários.
	 * Gera um token JWT para o usuário autenticado.
	 * @param usuario O usuário autenticado.
	 * @return O token JWT gerado.
	 */
	public String gerarToken( Funcionario funcionario) {
		try {
			Algorithm algorithm = Algorithm.HMAC256("joao-gabriel-lucas-leal-leo-mota");
			return JWT.create()
					.withIssuer("MottuFlow") // Identificador do emissor do token
					.withSubject(funcionario.getUsername()) // Nome de usuário do usuário autenticado
					.withExpiresAt(expiracao(120)) // Expira em 120 minutos
					.sign(algorithm);
		} catch (JWTCreationException exception) {
			throw new RegraDeNegocioException("Erro ao gerar o token JWT de acesso");
		}
	}
	
	public String gerarRefreshToken(Funcionario funcionario) {
		try {
			Algorithm algorithm = Algorithm.HMAC256("joao-gabriel-lucas-leal-leo-mota");
			return JWT.create()
					.withIssuer("MottuFlow")
					.withSubject(funcionario.getId_funcionario().toString())
					.withExpiresAt(expiracao(10080))
					.sign(algorithm);
		} catch (JWTCreationException exception) {
			throw new RegraDeNegocioException("Erro ao gerar o token JWT de acesso");
		}
	}
	
	public String getSubject( String token) {
		DecodedJWT decodedJWT;
		try {
			Algorithm algorithm = Algorithm.HMAC256("joao-gabriel-lucas-leal-leo-mota");
			JWTVerifier verifier = JWT.require(algorithm)
					.withIssuer("MottuFlow")
					.build();
			
			decodedJWT = verifier.verify(token);
			return decodedJWT.getSubject();
		} catch (JWTVerificationException exception) {
			throw new RegraDeNegocioException("Erro ao verificar o token JWT de acesso");
		}
	}
	
	private Instant expiracao(int minutos) {
		return LocalDateTime.now().plusMinutes(minutos).toInstant(ZoneOffset.of("-03:00"));
	}
}