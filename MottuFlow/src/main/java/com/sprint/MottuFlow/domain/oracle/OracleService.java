package com.sprint.MottuFlow.domain.oracle;

import org.springframework.stereotype.Service;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;

import javax.sql.DataSource;
import java.sql.Clob;
import java.sql.SQLException;
import java.util.Map;

@Service
public class OracleService {

    private final SimpleJdbcCall relatorioFuncionarioCall;
    private final SimpleJdbcCall funcaoMotoCall;

    public OracleService(DataSource dataSource) {
        this.relatorioFuncionarioCall = new SimpleJdbcCall(dataSource)
                .withCatalogName("PCT_MOTTUFLOW")
                .withProcedureName("RELATORIO_FUNCIONARIO_MOTO_STATUS")
                .withoutProcedureColumnMetaDataAccess()
                .declareParameters(
                        new org.springframework.jdbc.core.SqlParameter("P_ID_FUNCIONARIO", java.sql.Types.NUMERIC),
                        new org.springframework.jdbc.core.SqlOutParameter("P_JSON", java.sql.Types.CLOB)
                );

        this.funcaoMotoCall = new SimpleJdbcCall(dataSource)
                .withCatalogName("PCT_MOTTUFLOW")
                .withFunctionName("MOTO_TO_JSON");
    }


    public String executarRelatorioFuncionario(Long idFuncionario) {
        Map<String, Object> out = relatorioFuncionarioCall.execute(Map.of("P_ID_FUNCIONARIO", idFuncionario));
        Object clobObj = out.get("P_JSON");

        if (clobObj instanceof Clob) {
            Clob clob = (Clob) clobObj;
            try {
                return clob.getSubString(1, (int) clob.length());
            } catch (SQLException e) {
                throw new RuntimeException("Erro ao ler CLOB", e);
            }
        }
        return clobObj != null ? clobObj.toString() : null;
    }

    public String executarFuncaoMoto(Long idMoto) {
        Object clobObj = funcaoMotoCall.executeFunction(Object.class, Map.of("P_ID_MOTO", idMoto));

        if (clobObj instanceof Clob) {
            Clob clob = (Clob) clobObj;
            try {
                return clob.getSubString(1, (int) clob.length());
            } catch (SQLException e) {
                throw new RuntimeException("Erro ao ler CLOB", e);
            }
        }
        return clobObj != null ? clobObj.toString() : null;
    }
}
