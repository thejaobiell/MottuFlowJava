package com.sprint.MottuFlow.controller.rest;

import com.sprint.MottuFlow.domain.moto.MotoDTO;
import com.sprint.MottuFlow.domain.moto.Moto;
import com.sprint.MottuFlow.domain.patio.Patio;
import com.sprint.MottuFlow.domain.moto.MotoService;

import jakarta.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/motos")
public class MotoRestController {
	
    private final MotoService mS;
	
	public MotoRestController( MotoService mS ) {
		this.mS = mS;
	}
	
	private MotoDTO convertToDTO(Moto moto) {
        return new MotoDTO(
                moto.getIdMoto(),
                moto.getPlaca(),
                moto.getModelo(),
                moto.getFabricante(),
                moto.getAno(),
                moto.getPatio().getIdPatio(),
                moto.getLocalizacaoAtual()
        );
    }

    private Moto convertToEntity(MotoDTO dto) {
        Moto moto = new Moto();
        moto.setIdMoto(dto.getIdMoto());
        moto.setPlaca(dto.getPlaca());
        moto.setModelo(dto.getModelo());
        moto.setFabricante(dto.getFabricante());
        moto.setAno(dto.getAno());
        if (dto.getIdPatio() != 0) {
        	Patio patio = new Patio();
            patio.setIdPatio(dto.getIdPatio());
            moto.setPatio(patio);
        }
        moto.setLocalizacaoAtual(dto.getLocalizacaoAtual());

        return moto;
    }

    @GetMapping
    public List<MotoDTO> getAll() {
        List<Moto> motos = mS.listarMotos();
        return motos.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<MotoDTO> getById(@PathVariable Long id) {
        Moto moto = mS.buscarMotoPorId(id);
        return ResponseEntity.ok(convertToDTO(moto));
    }
    
    @GetMapping("/fabricante")
    public ResponseEntity<List<MotoDTO>> getByFabricante(@RequestParam String fabricante) {
        List<Moto> motos = mS.buscarMotoPorFabricante(fabricante);
        List<MotoDTO> dtos = motos.stream().map(this::convertToDTO).collect(Collectors.toList());
        return ResponseEntity.ok(dtos);
    }

    @GetMapping("/patio/{idPatio}")
    public ResponseEntity<List<MotoDTO>> getByPatio(@PathVariable long idPatio) {
        List<Moto> motos = mS.buscarMotoPorPlaca(idPatio);
        List<MotoDTO> dtos = motos.stream().map(this::convertToDTO).collect(Collectors.toList());
        return ResponseEntity.ok(dtos);
    }


    @PostMapping
    public ResponseEntity<MotoDTO> create(@RequestBody @Valid MotoDTO motoDTO) {
        Moto moto = convertToEntity(motoDTO);
        Moto saved = mS.cadastrarMoto(moto);
        return ResponseEntity.ok(convertToDTO(saved));
    }

    @PutMapping("/{id}")
    public ResponseEntity<MotoDTO> update(@PathVariable Long id, @RequestBody MotoDTO motoDTO) {
        Moto motoDetails = convertToEntity(motoDTO);
        Moto updated = mS.editarMoto(id, motoDetails);
        return ResponseEntity.ok(convertToDTO(updated));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        mS.deletarMoto(id);
        return ResponseEntity.noContent().build();
    }
}
