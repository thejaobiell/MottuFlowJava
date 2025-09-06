package com.sprint.MottuFlow.controller.rest;

import com.sprint.MottuFlow.domain.status.StatusDTO;
import com.sprint.MottuFlow.domain.status.Status;
import com.sprint.MottuFlow.domain.status.StatusService;
import com.sprint.MottuFlow.domain.status.TipoStatus;
import com.sprint.MottuFlow.domain.funcionario.Funcionario;
import com.sprint.MottuFlow.domain.moto.Moto;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/registro_status")
public class StatusRestController {
	
	private final StatusService sS;
	
	public StatusRestController( StatusService sS ) {
		this.sS = sS;
	}
	
	private StatusDTO convertToDTO(Status status) {
		return new StatusDTO(
				status.getIdStatus(),
				status.getMoto().getIdMoto(),
				status.getTipoStatus(),
				status.getDescricao(),
				status.getDataStatus(),
				status.getFuncionario().getId_funcionario()
		);
	}
	
	private Status convertToEntity(StatusDTO dto) {
		Status status = new Status();
		status.setIdStatus(dto.getIdStatus());
		status.setTipoStatus(dto.getTipoStatus());
		status.setDescricao(dto.getDescricao());
		status.setDataStatus(dto.getDataStatus());
		
		if (dto.getIdMoto() != 0) {
			Moto moto = new Moto();
			moto.setIdMoto(dto.getIdMoto());
			status.setMoto(moto);
		}
		
		if (dto.getIdFuncionario() != 0) {
			Funcionario funcionario = new Funcionario();
			funcionario.setId_funcionario(dto.getIdFuncionario());
			status.setFuncionario(funcionario);
		}
		
		return status;
	}
	
	@GetMapping
	public List<StatusDTO> getAll() {
		return sS.findAllStatus().stream()
				.map(this::convertToDTO)
				.collect(Collectors.toList());
	}
	
	@GetMapping("/id/{id}")
	public ResponseEntity<StatusDTO> getById(@PathVariable Long id) {
		Status status = sS.findByIdStatus(id);
		return ResponseEntity.ok(convertToDTO(status));
	}
	
	@GetMapping("/tipo")
	public List<StatusDTO> getByTipoStatus(@RequestParam String tipoStatus) {
		TipoStatus tipo;
		try {
			// Converte string para enum, suportando formatos como "Disponivel", "BAIXA_BOLETIM_OCORRENCIA"
			tipo = TipoStatus.valueOf(tipoStatus.toUpperCase().replace(" ", "_"));
		} catch (IllegalArgumentException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "TipoStatus inválido: " + tipoStatus);
		}
		
		return sS.findByTipoStatus(tipo).stream()
				.map(this::convertToDTO)
				.collect(Collectors.toList());
	}
	
	@GetMapping("/descricao")
	public List<StatusDTO> getByDescricaoStatus(@RequestParam String descricao) {
		return sS.findByDescricaoStatus(descricao).stream()
				.map(this::convertToDTO)
				.collect(Collectors.toList());
	}
	
	@PostMapping
	public ResponseEntity<StatusDTO> create(@RequestBody @Valid StatusDTO statusDTO) {
		Status status = convertToEntity(statusDTO);
		Status saved = sS.saveStatus(status);
		return ResponseEntity.status(HttpStatus.CREATED).body(convertToDTO(saved));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<StatusDTO> update(@PathVariable Long id, @RequestBody @Valid StatusDTO statusDTO) {
		Status statusAtualizado = convertToEntity(statusDTO);
		Status updated = sS.updateStatus(id, statusAtualizado);
		return ResponseEntity.ok(convertToDTO(updated));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		sS.deleteByIdStatus(id);
		return ResponseEntity.noContent().build();
	}
}
