package com.sprint.MottuFlow.infra.security;

import com.sprint.MottuFlow.autenticao.TokenService;
import com.sprint.MottuFlow.domain.funcionario.Funcionario;
import com.sprint.MottuFlow.domain.funcionario.FuncionarioRepository;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class FiltroTokenAcesso extends OncePerRequestFilter {
	
	private final TokenService tokenService;
	
	private final FuncionarioRepository funcionarioRepository;
	
	public FiltroTokenAcesso( TokenService tokenService, FuncionarioRepository funcionarioRepository ) {
		this.tokenService = tokenService;
		this.funcionarioRepository = funcionarioRepository;
	}
	
	@Override
	protected void doFilterInternal( HttpServletRequest request, HttpServletResponse response, FilterChain filterChain ) throws ServletException, IOException {
		String token = recuperarTokenRequisicao( request );
		
		if ( token != null ) {
			String usuario = tokenService.verificarToken( token );
			Funcionario funcionario = funcionarioRepository.findByEmailIgnoreCase( usuario ).orElseThrow();
			
			Authentication authentication = new UsernamePasswordAuthenticationToken( funcionario, null, funcionario.getAuthorities() );
			
			SecurityContextHolder.getContext().setAuthentication( authentication );
		}
		
		filterChain.doFilter( request, response );
	}
	
	private String recuperarTokenRequisicao( HttpServletRequest request ) {
		var authorizationHeader = request.getHeader( "Authorization" );
		
		if ( authorizationHeader != null ) {
			return authorizationHeader.replace( "Bearer ", "" );
		}
		return null;
	}
}