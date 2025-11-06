DECLARE
    v_count NUMBER;
BEGIN
    SELECT COUNT(*)
    INTO v_count
    FROM all_objects
    WHERE object_type = 'PACKAGE'
      AND object_name = 'PCT_MOTTUFLOW'
      AND owner = USER;

    IF v_count = 0 THEN
        EXECUTE IMMEDIATE '
            CREATE OR REPLACE PACKAGE pct_mottuflow AS
                PROCEDURE relatorio_funcionario_moto_status(p_id_funcionario IN NUMBER, p_json OUT CLOB);
                PROCEDURE soma_fato_motos;
                FUNCTION moto_to_json(p_id_moto IN NUMBER) RETURN CLOB;
                FUNCTION validar_senha(p_id_funcionario IN NUMBER, p_senha IN VARCHAR2) RETURN VARCHAR2;
            END pct_mottuflow;
        ';

        EXECUTE IMMEDIATE '
            CREATE OR REPLACE PACKAGE BODY pct_mottuflow AS
                PROCEDURE relatorio_funcionario_moto_status(
                    p_id_funcionario IN NUMBER,
                    p_json OUT CLOB
                ) IS
                BEGIN
                    SELECT JSON_OBJECT(
                               ''id_funcionario'' VALUE f.id_funcionario,
                               ''nome'' VALUE f.nome,
                               ''cargo'' VALUE f.cargo,
                               ''motos'' VALUE COALESCE(
                                   JSON_ARRAYAGG(
                                       JSON_OBJECT(
                                           ''id_moto'' VALUE m.id_moto,
                                           ''placa'' VALUE m.placa,
                                           ''status'' VALUE rs.tipo_status
                                       )
                                   ),
                                   JSON_ARRAY()
                               )
                           )
                    INTO p_json
                    FROM funcionario f
                    LEFT JOIN registro_status rs ON f.id_funcionario = rs.id_funcionario
                    LEFT JOIN moto m ON rs.id_moto = m.id_moto
                    WHERE f.id_funcionario = p_id_funcionario
                    GROUP BY f.id_funcionario, f.nome, f.cargo;
                EXCEPTION
                    WHEN NO_DATA_FOUND THEN p_json := ''{\"erro\":\"Funcionario nao encontrado\"}'';
                    WHEN OTHERS THEN p_json := ''{\"erro\":\"'' || SQLERRM || ''\"}'';
                END;

                FUNCTION validar_senha(p_id_funcionario IN NUMBER, p_senha IN VARCHAR2)
                RETURN VARCHAR2 IS
                v_senha_bd VARCHAR2(255);
                BEGIN
                    SELECT senha INTO v_senha_bd
                    FROM funcionario
                    WHERE id_funcionario = p_id_funcionario;

                    IF v_senha_bd = p_senha THEN
                        RETURN ''Valido'';
                    ELSE
                        RETURN ''Invalido'';
                    END IF;

                EXCEPTION
                    WHEN NO_DATA_FOUND THEN
                        RETURN ''Funcionario nao encontrado'';
                    WHEN TOO_MANY_ROWS THEN
                        RETURN ''Mais de um funcionario retornado'';
                    WHEN OTHERS THEN
                        RETURN ''Erro inesperado: '' || SQLERRM;
                END;

                PROCEDURE soma_fato_motos IS
                    v_total NUMBER;
                BEGIN
                    SELECT COUNT(*) INTO v_total FROM moto;
                    DBMS_OUTPUT.PUT_LINE(''Total de motos: '' || v_total);
                END;

                FUNCTION moto_to_json(p_id_moto IN NUMBER) RETURN CLOB IS
                    v_json CLOB;
                BEGIN
                    SELECT JSON_OBJECT(
                               ''id_moto'' VALUE m.id_moto,
                               ''placa'' VALUE m.placa,
                               ''modelo'' VALUE m.modelo,
                               ''fabricante'' VALUE m.fabricante,
                               ''ano'' VALUE m.ano,
                               ''localizacao_atual'' VALUE m.localizacao_atual
                           )
                    INTO v_json
                    FROM moto m
                    WHERE m.id_moto = p_id_moto;

                    RETURN v_json;
                EXCEPTION
                    WHEN NO_DATA_FOUND THEN RETURN ''{\"erro\":\"Moto nao encontrada\"}'';
                    WHEN OTHERS THEN RETURN ''{\"erro\":\"'' || SQLERRM || ''\"}'';
                END;

            END pct_mottuflow;
        ';
    END IF;
END;
/
