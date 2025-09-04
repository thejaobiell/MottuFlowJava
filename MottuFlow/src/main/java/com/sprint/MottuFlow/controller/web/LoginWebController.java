package com.sprint.MottuFlow.controller.web;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginWebController {
	@GetMapping( "/login" )
	public String telaLogin( @RequestParam( value = "error", required = false ) String error, @RequestParam( value = "logout", required = false ) String logout, Model model ) {
		if ( error != null ) model.addAttribute( "mensagemErro", "Usuário ou senha inválidos!" );
		if ( logout != null ) model.addAttribute( "mensagemSucesso", "Logout efetuado com sucesso!" );
		return "login"; // nome do template Thymeleaf login.html
	}
}