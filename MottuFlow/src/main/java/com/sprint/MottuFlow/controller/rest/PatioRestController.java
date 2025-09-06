package com.sprint.MottuFlow.controller.rest;

import com.sprint.MottuFlow.domain.patio.PatioDTO;
import com.sprint.MottuFlow.domain.patio.Patio;
import com.sprint.MottuFlow.domain.patio.PatioService;

import jakarta.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/patios")
public class PatioRestController {
	
    private final PatioService pS;
	
	public PatioRestController( PatioService pS ) {
		this.pS = pS;
	}
	
	private PatioDTO convertToDTO(Patio patio) {
        return new PatioDTO(
                patio.getIdPatio(),
                patio.getNome(),
                patio.getEndereco(),
                patio.getCapacidadeMaxima()
        );
    }

    private Patio convertToEntity(PatioDTO dto) {
        Patio patio = new Patio();
        patio.setIdPatio(dto.getIdPatio());
        patio.setNome(dto.getNome());
        patio.setEndereco(dto.getEndereco());
        patio.setCapacidadeMaxima(dto.getCapacidadeMaxima());
        return patio;
    }

    @GetMapping
    public List<PatioDTO> getAll() {
        List<Patio> patios = pS.listarPatios();
        return patios.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<PatioDTO> getById(@PathVariable Long id) {
        Patio patio = pS.buscarPatioPorId(id);
        return ResponseEntity.ok(convertToDTO(patio));
    }
    
    @GetMapping("/search")
    public List<PatioDTO> searchByEndereco(@RequestParam String endereco) {
        List<Patio> patios = pS.buscarPatioPorEndereco(endereco);
        return patios.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    @PostMapping
    public ResponseEntity<PatioDTO> create(@RequestBody @Valid PatioDTO patioDTO) {
        Patio patio = convertToEntity(patioDTO);
        Patio saved = pS.cadastrarPatio(patio);
        return ResponseEntity.ok(convertToDTO(saved));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PatioDTO> update(@PathVariable Long id, @RequestBody PatioDTO patioDTO) {
        Patio patioDetails = convertToEntity(patioDTO);
        Patio updated = pS.editarPatio(id, patioDetails);
        return ResponseEntity.ok(convertToDTO(updated));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        pS.deletarPatio(id);
        return ResponseEntity.noContent().build();
    }
}
