package com.sprint.MottuFlow.domain.arucotag;

import com.sprint.MottuFlow.infra.exception.RegraDeNegocioException;
import com.sprint.MottuFlow.domain.moto.Moto;
import com.sprint.MottuFlow.domain.moto.MotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArucoTagService {

    @Autowired
    private ArucoTagRepository atR;

    @Autowired
    private MotoRepository mR;

    public List<ArucoTag> findAllAruco() {
        return atR.findAll();
    }

    public ArucoTag findByIdAruco(Long id) {
        return atR.findById(id)
                .orElseThrow(() -> new RegraDeNegocioException("ArucoTag não encontrada com id: " + id));
    }
    
    public List<ArucoTag> findByStatus(String status) {
        return atR.findByStatus(status);
    }
    

	public ArucoTag findByCodigoStatus(String codigo) {
	    ArucoTag tag = atR.findByCodigoNative(codigo);
	    if (tag == null) {
	        throw new RegraDeNegocioException("ArucoTag não encontrada com código: " + codigo);
	    }
	    return tag;
	}


    public ArucoTag saveAruco(ArucoTag arucoTag) {
        Moto moto = mR.findById(arucoTag.getMoto().getIdMoto())
                .orElseThrow(() -> new RegraDeNegocioException("Moto não encontrada com id: " + arucoTag.getMoto().getIdMoto()));
        arucoTag.setMoto(moto);

        return atR.save(arucoTag);
    }

    public ArucoTag updateAruco(Long id, ArucoTag arucoTagAtualizado) {
        ArucoTag arucoTag = findByIdAruco(id);

        arucoTag.setCodigo(arucoTagAtualizado.getCodigo());
        arucoTag.setStatus(arucoTagAtualizado.getStatus());

        Moto moto = mR.findById(arucoTagAtualizado.getMoto().getIdMoto())
                .orElseThrow(() -> new RegraDeNegocioException("Moto não encontrada com id: " + arucoTagAtualizado.getMoto().getIdMoto()));
        arucoTag.setMoto(moto);

        return atR.save(arucoTag);
    }

    public void deleteByIdAruco(Long id) {
        ArucoTag arucoTag = findByIdAruco(id);
        atR.delete(arucoTag);
    }
}
