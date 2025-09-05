package com.sprint.MottuFlow.controller.web;

import com.sprint.MottuFlow.domain.funcionario.Funcionario;
import com.sprint.MottuFlow.domain.funcionario.FuncionarioService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping( "/funcionarios" )
public class FuncionarioWebController {
	
	private final FuncionarioService funcionarioService;
	
	public FuncionarioWebController( FuncionarioService funcionarioService ) {
		this.funcionarioService = funcionarioService;
	}
	
	@GetMapping( "/listar" )
	public String listarFuncionarios( Model model ) {
		model.addAttribute( "funcionarios", funcionarioService.listarFuncionarios() );
		model.addAttribute( "novoFuncionario", new Funcionario() );
		return "funcionarios/listar";
	}
	
	@PostMapping( "/cadastrar" )
	public String cadastrarFuncionario( @ModelAttribute( "novoFuncionario" ) Funcionario funcionario ) {
		funcionarioService.cadastrarFuncionario( funcionario );
		return "redirect:/funcionarios/listar";
	}
	
	@GetMapping( "/editar/{id}" )
	public String editarFuncionarioForm( @PathVariable Long id, Model model ) {
		Funcionario funcionario = funcionarioService.buscarFuncionarioPorId( id );
		model.addAttribute( "funcionario", funcionario );
		return "funcionarios/editar";
	}
	
	@PostMapping( "/editar/{id}" )
	public String editarFuncionario( @PathVariable Long id, @ModelAttribute Funcionario funcionarioAtualizado ) {
		funcionarioService.editarFuncionario( id, funcionarioAtualizado );
		return "redirect:/funcionarios/listar";
	}
	
	@PostMapping( "/deletar/{id}" )
	public String deletarFuncionario( @PathVariable Long id ) {
		funcionarioService.deletarFuncionario( id );
		return "redirect:/funcionarios/listar";
	}
}
