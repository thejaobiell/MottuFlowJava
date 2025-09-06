package com.sprint.MottuFlow.controller.web;

import com.sprint.MottuFlow.domain.patio.Patio;
import com.sprint.MottuFlow.domain.patio.PatioService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/patios")
public class PatioWebController {
	
	private final PatioService pS;
	
	public PatioWebController(PatioService pS ) {
		this.pS = pS;
	}
	
	// Listar todos os pátios
	@GetMapping("/listar")
	public String listarPatios(Model model) {
		model.addAttribute("patios", pS.listarPatios());
		model.addAttribute("novoPatio", new Patio());
		return "patios/listar"; // -> resources/templates/patios/listar.html
	}
	
	// Cadastrar novo pátio
	@PostMapping("/cadastrar")
	public String cadastrarPatio(@ModelAttribute("novoPatio") Patio patio) {
		pS.cadastrarPatio(patio);
		return "redirect:/patios/listar";
	}
	
	// Formulário de edição
	@GetMapping("/editar/{id}")
	public String editarPatioForm(@PathVariable Long id, Model model) {
		Patio patio = pS.buscarPatioPorId(id);
		model.addAttribute("patio", patio);
		return "patios/editar"; // -> resources/templates/patios/editar.html
	}
	
	// Editar pátio
	@PostMapping("/editar/{id}")
	public String editarPatio(@PathVariable Long id, @ModelAttribute Patio patioAtualizado) {
		pS.editarPatio(id, patioAtualizado);
		return "redirect:/patios/listar";
	}
	
	// Deletar pátio
	@PostMapping("/deletar/{id}")
	public String deletarPatio(@PathVariable Long id) {
		pS.deletarPatio(id);
		return "redirect:/patios/listar";
	}
}
