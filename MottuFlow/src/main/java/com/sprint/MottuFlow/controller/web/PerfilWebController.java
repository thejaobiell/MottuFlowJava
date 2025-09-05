package com.sprint.MottuFlow.controller.web;

import com.sprint.MottuFlow.domain.funcionario.Funcionario;
import com.sprint.MottuFlow.domain.funcionario.FuncionarioService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PerfilWebController {
	
	private final FuncionarioService funcionarioService;
	
	public PerfilWebController( FuncionarioService funcionarioService ) {
		this.funcionarioService = funcionarioService;
	}
	
	@GetMapping( "/perfil" )
	public String mostrarPerfil( Model model, @AuthenticationPrincipal UserDetails userDetails ) {
		Funcionario usuario = funcionarioService.buscarFuncionarioPorEmail( userDetails.getUsername() );
		model.addAttribute( "usuario", usuario );
		return "perfil";
	}
}