package com.sprint.MottuFlow.repository;

import com.sprint.MottuFlow.model.Localidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface LocalidadeRepository extends JpaRepository<Localidade, Long> {

    @Query("SELECT l FROM Localidade l WHERE l.pontoReferencia LIKE %:ponto%")
    List<Localidade> findByPontoReferencia(@Param("ponto") String ponto);

    @Query("SELECT l FROM Localidade l WHERE l.dataHora >= :dataInicio AND l.dataHora <= :dataFim")
    List<Localidade> findDatas(@Param("dataInicio") java.time.LocalDateTime dataInicio,
                                      @Param("dataFim") java.time.LocalDateTime dataFim);

}
