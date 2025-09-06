package com.sprint.MottuFlow.domain.moto;

import com.sprint.MottuFlow.infra.exception.RegraDeNegocioException;
import com.sprint.MottuFlow.domain.patio.Patio;
import com.sprint.MottuFlow.domain.patio.PatioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MotoService {

    private final MotoRepository mR;
	
    private final PatioRepository pR;
	
	public MotoService( MotoRepository mR, PatioRepository pR ) {
		this.mR = mR;
		this.pR = pR;
	}
	
	public List<Moto> listarMotos() {
        return mR.findAll();
    }

    public Moto buscarMotoPorId( Long id) {
        return mR.findById(id).orElseThrow(() -> new RegraDeNegocioException("Moto não encontrada com id: " + id));
    }
    
    public List<Moto> buscarMotoPorFabricante( String fabricante) {
        return mR.findByFabricante(fabricante);
    }

    public List<Moto> buscarMotoPorPlaca( long idPatio) {
        return mR.findByPatioId(idPatio);
    }
	
    public Moto cadastrarMoto( Moto moto) {
        Patio patio = pR.findById(moto.getPatio().getIdPatio()).orElseThrow(() -> new RegraDeNegocioException("Patio não encontrado com id: " + moto.getPatio().getIdPatio()));
        moto.setPatio(patio);

        return mR.save(moto);
    }
	
	public Moto editarMoto(Long id, Moto motoAtualizada) {
		Moto moto = buscarMotoPorId(id);
		
		if (motoAtualizada.getPlaca() != null && !motoAtualizada.getPlaca().isBlank()) {
			moto.setPlaca(motoAtualizada.getPlaca());
		}
		if (motoAtualizada.getModelo() != null && !motoAtualizada.getModelo().isBlank()) {
			moto.setModelo(motoAtualizada.getModelo());
		}
		if (motoAtualizada.getFabricante() != null && !motoAtualizada.getFabricante().isBlank()) {
			moto.setFabricante(motoAtualizada.getFabricante());
		}
		if (motoAtualizada.getAno() > 2010) {
			moto.setAno(motoAtualizada.getAno());
		}
		if (motoAtualizada.getLocalizacaoAtual() != null && !motoAtualizada.getLocalizacaoAtual().isBlank()) {
			moto.setLocalizacaoAtual(motoAtualizada.getLocalizacaoAtual());
		}
		if (motoAtualizada.getPatio() != null && motoAtualizada.getPatio().getIdPatio() != null) {
			Patio patio = pR.findById(motoAtualizada.getPatio().getIdPatio())
					.orElseThrow(() -> new RegraDeNegocioException(
							"Pátio não encontrado com id: " + motoAtualizada.getPatio().getIdPatio()
					));
			moto.setPatio(patio);
		}
		
		return mR.save(moto);
	}
	
	
	public void deletarMoto(Long id) {
        Moto moto = buscarMotoPorId(id);
        mR.delete(moto);
    }
}
