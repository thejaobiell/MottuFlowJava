package com.sprint.MottuFlow.controller.rest;

import org.springframework.web.bind.annotation.*;
import com.sprint.MottuFlow.domain.masteringdatabase.MasteringDatabaseService;
import java.util.Map;

@RestController
@RequestMapping("/api/database")
public class MasteringDatabaseController {
	
	private final MasteringDatabaseService mdS;
	
	public MasteringDatabaseController(MasteringDatabaseService mdS) {
		this.mdS = mdS;
	}
	
	@GetMapping("/funcionario/{id}")
	public String relatorioFuncionario(@PathVariable Long id) {
		return mdS.executarRelatorioFuncionario(id);
	}
	
	@GetMapping("/moto/{id}")
	public String motoJson(@PathVariable Long id) {
		return mdS.executarFuncaoMoto(id);
	}
}
