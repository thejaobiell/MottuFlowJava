package com.sprint.MottuFlow.domain.camera;

import com.sprint.MottuFlow.infra.exception.RegraDeNegocioException;
import com.sprint.MottuFlow.domain.patio.Patio;
import com.sprint.MottuFlow.domain.patio.PatioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CameraService {

    @Autowired
    private CameraRepository cR;

    @Autowired
    private PatioRepository pR;

    public List<Camera> findAllCamera() {
        return cR.findAll();
    }

    public Camera findByIdCamera(Long id) {
        return cR.findById(id)
                .orElseThrow(() -> new RegraDeNegocioException("Camera não encontrada com id: " + id));
    }
    
    public List<Camera> findByStatusOperacional(String status) {
        return cR.findByStatusOperacional(status);
    }

    public List<Camera> findByLocalizacaoFisica(String localizacao) {
        return cR.findByLocalizacaoFisica(localizacao);
    }

    public Camera saveCamera(Camera camera) {
        Patio patio = pR.findById(camera.getPatio().getIdPatio())
                .orElseThrow(() -> new RegraDeNegocioException("Patio não encontrado com id: " + camera.getPatio().getIdPatio()));
        camera.setPatio(patio);

        return cR.save(camera);
    }

    public Camera updateCamera(Long id, Camera cameraAtualizado) {
        Camera camera = findByIdCamera(id);

        camera.setStatusOperacional(cameraAtualizado.getStatusOperacional());
        camera.setLocalizacaoFisica(cameraAtualizado.getLocalizacaoFisica());

        Patio patio = pR.findById(cameraAtualizado.getPatio().getIdPatio()).orElseThrow(() -> new RegraDeNegocioException("Patio não encontrado com id: " + cameraAtualizado.getPatio().getIdPatio()));
        camera.setPatio(patio);

        return cR.save(camera);
    }

    public void deleteByIdCamera(Long id) {
        Camera camera = findByIdCamera(id);
        cR.delete(camera);
    }
}
