package com.sprint.MottuFlow.controller.rest;

import com.sprint.MottuFlow.domain.oracle.OracleService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/database")
public class RelatorioController {

    private final OracleService oracleService;

    public RelatorioController(OracleService oracleService) {
        this.oracleService = oracleService;
    }

    @GetMapping("/funcionario/{id}")
    public String relatorioFuncionario(@PathVariable Long id) {
        // retorna diretamente o JSON gerado pela procedure
        return oracleService.executarRelatorioFuncionario(id);
    }

    @GetMapping("/moto/{id}")
    public String motoJson(@PathVariable Long id) {
        return oracleService.executarFuncaoMoto(id);
    }
}
