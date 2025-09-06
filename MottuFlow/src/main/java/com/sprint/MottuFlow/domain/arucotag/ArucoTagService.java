package com.sprint.MottuFlow.domain.arucotag;

import com.sprint.MottuFlow.infra.exception.RegraDeNegocioException;
import com.sprint.MottuFlow.domain.moto.Moto;
import com.sprint.MottuFlow.domain.moto.MotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArucoTagService {
	
    private final ArucoTagRepository atR;
	
    private final MotoRepository mR;
	
	public ArucoTagService( ArucoTagRepository atR, MotoRepository mR ) {
		this.atR = atR;
		this.mR = mR;
	}
	
	public List<ArucoTag> listarArucoTags() {
        return atR.findAll();
    }

    public ArucoTag buscarTagPorId( Long id) {
        return atR.findById(id)
                .orElseThrow(() -> new RegraDeNegocioException("ArucoTag não encontrada com id: " + id));
    }
    
    public List<ArucoTag> buscarPorStatus( String status) {
        return atR.findByStatus(status);
    }
    

	public ArucoTag buscarPorCodigo( String codigo) {
	    ArucoTag tag = atR.findByCodigoNative(codigo);
	    if (tag == null) {
	        throw new RegraDeNegocioException("ArucoTag não encontrada com código: " + codigo);
	    }
	    return tag;
	}


    public ArucoTag cadastrarTag( ArucoTag arucoTag) {
        Moto moto = mR.findById(arucoTag.getMoto().getIdMoto())
                .orElseThrow(() -> new RegraDeNegocioException("Moto não encontrada com id: " + arucoTag.getMoto().getIdMoto()));
        arucoTag.setMoto(moto);

        return atR.save(arucoTag);
    }

    public ArucoTag editarTag( Long id, ArucoTag arucoTagAtualizado) {
        ArucoTag arucoTag = buscarTagPorId(id);

        arucoTag.setCodigo(arucoTagAtualizado.getCodigo());
        arucoTag.setStatus(arucoTagAtualizado.getStatus());

        Moto moto = mR.findById(arucoTagAtualizado.getMoto().getIdMoto())
                .orElseThrow(() -> new RegraDeNegocioException("Moto não encontrada com id: " + arucoTagAtualizado.getMoto().getIdMoto()));
        arucoTag.setMoto(moto);

        return atR.save(arucoTag);
    }

    public void deletarTag( Long id) {
        ArucoTag arucoTag = buscarTagPorId(id);
        atR.delete(arucoTag);
    }
}
