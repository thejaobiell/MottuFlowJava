package com.sprint.MottuFlow.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class AutenticacaoWebController {
	@GetMapping("/login")
	public String login(){
		return "login";
	}
}
