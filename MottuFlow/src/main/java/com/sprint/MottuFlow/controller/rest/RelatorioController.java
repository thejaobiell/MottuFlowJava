package com.sprint.MottuFlow.controller.rest;

import com.sprint.MottuFlow.domain.oracle.OracleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/database")
public class RelatorioController {

    private final OracleService oracleService;

    public RelatorioController(OracleService oracleService) {
        this.oracleService = oracleService;
    }

    @GetMapping("/funcionario/{id}")
    public List<Map<String, Object>> relatorioFuncionario(@PathVariable Long id) {
        return oracleService.executarRelatorioFuncionario(id);
    }

    @GetMapping("/moto/{id}")
    public List<Map<String, Object>> motoJson(@PathVariable Long id) {
        return oracleService.executarFuncaoMoto(id);
    }
}

