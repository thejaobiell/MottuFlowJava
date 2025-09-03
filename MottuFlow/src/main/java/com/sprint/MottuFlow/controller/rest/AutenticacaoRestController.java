package com.sprint.MottuFlow.controller.rest;

import com.sprint.MottuFlow.autenticao.DadosLogin;
import com.sprint.MottuFlow.autenticao.DadosRefreshToken;
import com.sprint.MottuFlow.autenticao.DadosToken;
import com.sprint.MottuFlow.autenticao.TokenService;
import com.sprint.MottuFlow.domain.funcionario.Funcionario;
import com.sprint.MottuFlow.domain.funcionario.FuncionarioRepository;
import com.sprint.MottuFlow.infra.exception.RegraDeNegocioException;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.authentication.AuthenticationManager;

@RestController
public class AutenticacaoRestController {
	private final AuthenticationManager aM;
	private final TokenService tS;
	private final FuncionarioRepository fR;
	
	public AutenticacaoRestController( AuthenticationManager aM, TokenService tS, FuncionarioRepository fR ) {
		this.aM = aM;
		this.tS = tS;
		this.fR = fR;
	}
	
	@PostMapping( "/login" )
	public ResponseEntity<DadosToken> efetuarLogin( @Valid @RequestBody DadosLogin dados ) {
		var autenticationToken = new UsernamePasswordAuthenticationToken( dados.email(), dados.senha() );
		var authentication = aM.authenticate( autenticationToken );
		
		var funcionario = (Funcionario) authentication.getPrincipal();
		String tokenAcesso = tS.gerarToken( funcionario );
		String refreshToken = funcionario.novoRefreshToken();
		fR.save( funcionario );
		
		return ResponseEntity.ok( new DadosToken( tokenAcesso, refreshToken ) );
	}
	
	@PostMapping( "/atualizar-token" )
	public ResponseEntity<DadosToken> atualizarToken( @Valid @RequestBody DadosRefreshToken dados ) {
		var refreshToken = dados.refreshToken();
		var funcionario = fR.findByRefreshToken( refreshToken )
				.orElseThrow( () -> new RegraDeNegocioException( "Refresh token inválido!" ) );
		
		if ( funcionario.refreshTokenExpirado() )
			throw new RegraDeNegocioException( "Refresh token expirado!" );
		
		String tokenAcesso = tS.gerarToken( funcionario );
		String novoRefreshToken = funcionario.novoRefreshToken();
		
		fR.save( funcionario );
		
		return ResponseEntity.ok( new DadosToken( tokenAcesso, novoRefreshToken ) );
	}
}