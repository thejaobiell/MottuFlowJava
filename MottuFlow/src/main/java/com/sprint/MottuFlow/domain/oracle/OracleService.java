package com.sprint.MottuFlow.domain.oracle;

import org.springframework.stereotype.Service;
import org.springframework.jdbc.core.JdbcTemplate;
import java.util.List;
import java.util.Map;

@Service
public class OracleService {

    private final JdbcTemplate jdbcTemplate;

    public OracleService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Map<String, Object>> executarRelatorioFuncionario(Long idFuncionario) {
        String sql = "SELECT * FROM funcionario WHERE id_funcionario = ?";
        return jdbcTemplate.queryForList(sql, idFuncionario);
    }

    public List<Map<String, Object>> executarFuncaoMoto(Long idMoto) {
        String sql = "SELECT * FROM moto WHERE id_moto = ?";
        return jdbcTemplate.queryForList(sql, idMoto);
    }
}
