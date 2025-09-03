package com.sprint.MottuFlow.domain.localidade;

import com.sprint.MottuFlow.infra.exception.RegraDeNegocioException;
import com.sprint.MottuFlow.domain.camera.Camera;
import com.sprint.MottuFlow.domain.moto.Moto;
import com.sprint.MottuFlow.domain.patio.Patio;
import com.sprint.MottuFlow.domain.camera.CameraRepository;
import com.sprint.MottuFlow.domain.moto.MotoRepository;
import com.sprint.MottuFlow.domain.patio.PatioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class LocalidadeService {

    @Autowired
    private LocalidadeRepository lR;

    @Autowired
    private MotoRepository mR;

    @Autowired
    private PatioRepository pR;

    @Autowired
    private CameraRepository cR;

    public List<Localidade> findAll() {
        return lR.findAll();
    }

    public Localidade findById(Long id) {
        return lR.findById(id).orElseThrow(() -> new RegraDeNegocioException("Localidade não encontrada com id: " + id));
    }
    
    public List<Localidade> findByPontoReferencia(String ponto) {
        return lR.findByPontoReferencia(ponto);
    }

    public List<Localidade> findByDataHoraBetween(LocalDateTime dataInicio, LocalDateTime dataFim) {
        return lR.findDatas(dataInicio, dataFim);
    }



    public Localidade save(Localidade localidade) {
        Moto moto = mR.findById(localidade.getMoto().getIdMoto()).orElseThrow(() -> new RegraDeNegocioException("Moto não encontrada com id: " + localidade.getMoto().getIdMoto()));

        Patio patio = pR.findById(localidade.getPatio().getIdPatio()).orElseThrow(() -> new RegraDeNegocioException("Patio não encontrado com id: " + localidade.getPatio().getIdPatio()));

        Camera camera = cR.findById(localidade.getCamera().getIdCamera()).orElseThrow(() -> new RegraDeNegocioException("Camera não encontrada com id: " + localidade.getCamera().getIdCamera()));

        localidade.setMoto(moto);
        localidade.setPatio(patio);
        localidade.setCamera(camera);

        return lR.save(localidade);
    }

    public Localidade update(Long id, Localidade localidadeAtualizada) {
        Localidade localidade = findById(id);

        localidade.setDataHora(localidadeAtualizada.getDataHora());
        localidade.setPontoReferencia(localidadeAtualizada.getPontoReferencia());

        Moto moto = mR.findById(localidadeAtualizada.getMoto().getIdMoto()).orElseThrow(() -> new RegraDeNegocioException("Moto não encontrada com id: " + localidadeAtualizada.getMoto().getIdMoto()));

        Patio patio = pR.findById(localidadeAtualizada.getPatio().getIdPatio()).orElseThrow(() -> new RegraDeNegocioException("Patio não encontrado com id: " + localidadeAtualizada.getPatio().getIdPatio()));

        Camera camera = cR.findById(localidadeAtualizada.getCamera().getIdCamera()).orElseThrow(() -> new RegraDeNegocioException("Camera não encontrada com id: " + localidadeAtualizada.getCamera().getIdCamera()));

        localidade.setMoto(moto);
        localidade.setPatio(patio);
        localidade.setCamera(camera);

        return lR.save(localidade);
    }

    public void deleteById(Long id) {
        Localidade localidade = findById(id);
        lR.delete(localidade);
    }
}
