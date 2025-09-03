package com.sprint.MottuFlow.controller.web;

import com.sprint.MottuFlow.domain.funcionario.Funcionario;
import com.sprint.MottuFlow.domain.funcionario.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/funcionario")
public class FuncionarioWebController {
	
	private final FuncionarioService fS;
	
	public FuncionarioWebController( FuncionarioService fS ) {
		this.fS = fS;
	}
	
	@GetMapping("/cadastro")
	public String cadastroFuncionarioForm(Model model) {
		model.addAttribute("funcionario", new Funcionario());
		return "cadastro-funcionario";
	}
	
	@PostMapping("/cadastro")
	public String cadastroFuncionarioSubmit(@ModelAttribute Funcionario funcionario) {
		fS.cadastrarFuncionario(funcionario);
		return "redirect:/";
	}
}
