package com.sprint.MottuFlow.domain.moto;

import com.sprint.MottuFlow.infra.exception.RegraDeNegocioException;
import com.sprint.MottuFlow.domain.patio.Patio;
import com.sprint.MottuFlow.domain.patio.PatioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MotoService {

    @Autowired
    private MotoRepository mR;

    @Autowired
    private PatioRepository pR;

    public List<Moto> findAllMoto() {
        return mR.findAll();
    }

    public Moto findByIdMoto(Long id) {
        return mR.findById(id).orElseThrow(() -> new RegraDeNegocioException("Moto não encontrada com id: " + id));
    }
    
    public List<Moto> findByFabricanteMoto(String fabricante) {
        return mR.findByFabricante(fabricante);
    }

    public List<Moto> findByPatioIdMoto(long idPatio) {
        return mR.findByPatioId(idPatio);
    }


    public Moto saveMoto(Moto moto) {
        Patio patio = pR.findById(moto.getPatio().getIdPatio()).orElseThrow(() -> new RegraDeNegocioException("Patio não encontrado com id: " + moto.getPatio().getIdPatio()));
        moto.setPatio(patio);

        return mR.save(moto);
    }

    public Moto updateMoto(Long id, Moto motoAtualizada) {
        Moto moto = findByIdMoto(id);
        moto.setPlaca(motoAtualizada.getPlaca());
        moto.setModelo(motoAtualizada.getModelo());
        moto.setFabricante(motoAtualizada.getFabricante());
        moto.setAno(motoAtualizada.getAno());
        moto.setLocalizacaoAtual(motoAtualizada.getLocalizacaoAtual());
        Patio patio = pR.findById(motoAtualizada.getPatio().getIdPatio()).orElseThrow(() -> new RegraDeNegocioException("Patio não encontrado com id: " + motoAtualizada.getPatio().getIdPatio()));
        moto.setPatio(patio);

        return mR.save(moto);
    }

    public void deleteByIdMoto(Long id) {
        Moto moto = findByIdMoto(id);
        mR.delete(moto);
    }
}
