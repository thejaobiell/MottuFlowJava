package com.sprint.MottuFlow.controller.rest;

import com.sprint.MottuFlow.domain.moto.MotoDTO;
import com.sprint.MottuFlow.domain.moto.Moto;
import com.sprint.MottuFlow.domain.patio.Patio;
import com.sprint.MottuFlow.domain.moto.MotoService;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/motos")
public class MotoRestController {

    @Autowired
    private MotoService motoService;

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
        List<Moto> motos = motoService.findAllMoto();
        return motos.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<MotoDTO> getById(@PathVariable Long id) {
        Moto moto = motoService.findByIdMoto(id);
        return ResponseEntity.ok(convertToDTO(moto));
    }
    
    @GetMapping("/fabricante")
    public ResponseEntity<List<MotoDTO>> getByFabricante(@RequestParam String fabricante) {
        List<Moto> motos = motoService.findByFabricanteMoto(fabricante);
        List<MotoDTO> dtos = motos.stream().map(this::convertToDTO).collect(Collectors.toList());
        return ResponseEntity.ok(dtos);
    }

    @GetMapping("/patio/{idPatio}")
    public ResponseEntity<List<MotoDTO>> getByPatio(@PathVariable long idPatio) {
        List<Moto> motos = motoService.findByPatioIdMoto(idPatio);
        List<MotoDTO> dtos = motos.stream().map(this::convertToDTO).collect(Collectors.toList());
        return ResponseEntity.ok(dtos);
    }


    @PostMapping
    public ResponseEntity<MotoDTO> create(@RequestBody @Valid MotoDTO motoDTO) {
        Moto moto = convertToEntity(motoDTO);
        Moto saved = motoService.saveMoto(moto);
        return ResponseEntity.ok(convertToDTO(saved));
    }

    @PutMapping("/{id}")
    public ResponseEntity<MotoDTO> update(@PathVariable Long id, @RequestBody MotoDTO motoDTO) {
        Moto motoDetails = convertToEntity(motoDTO);
        Moto updated = motoService.updateMoto(id, motoDetails);
        return ResponseEntity.ok(convertToDTO(updated));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        motoService.deleteByIdMoto(id);
        return ResponseEntity.noContent().build();
    }
}
