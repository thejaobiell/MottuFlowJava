package com.sprint.MottuFlow.controller.rest;

import com.sprint.MottuFlow.domain.status.StatusDTO;
import com.sprint.MottuFlow.domain.funcionario.Funcionario;
import com.sprint.MottuFlow.domain.moto.Moto;
import com.sprint.MottuFlow.domain.status.Status;
import com.sprint.MottuFlow.domain.status.StatusService;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping( "/api/registro_status" )
public class StatusRestController {
	
	@Autowired
	private StatusService statusService;
	
	private StatusDTO convertToDTO( Status status ) {
		return new StatusDTO( status.getIdStatus(), status.getMoto().getIdMoto(), status.getTipoStatus(), status.getDescricao(), status.getDataStatus(), status.getFuncionario().getId_funcionario() );
	}
	
	private Status convertToEntity( StatusDTO dto ) {
		Status status = new Status();
		status.setIdStatus( dto.getIdStatus() );
		status.setTipoStatus( dto.getTipoStatus() );
		status.setDescricao( dto.getDescricao() );
		status.setDataStatus( dto.getDataStatus() );
		
		if ( dto.getIdMoto() != 0 ) {
			Moto moto = new Moto();
			moto.setIdMoto( dto.getIdMoto() );
			status.setMoto( moto );
		}
		if ( dto.getIdFuncionario() != 0 ) {
			Funcionario funcionario = new Funcionario();
			funcionario.setId_funcionario( dto.getIdFuncionario() );
			status.setFuncionario( funcionario );
		}
		return status;
	}
	
	@GetMapping
	public List<StatusDTO> getAll() {
		List<Status> statusList = statusService.findAllStatus();
		return statusList.stream().map( this::convertToDTO ).collect( Collectors.toList() );
	}
	
	@GetMapping( "/id/{id}" )
	public ResponseEntity<StatusDTO> getById( @PathVariable Long id ) {
		Status status = statusService.findByIdStatus( id );
		return ResponseEntity.ok( convertToDTO( status ) );
	}
	
	@GetMapping( "/tipo" )
	public List<StatusDTO> getByTipoStatus( @RequestParam String tipoStatus ) {
		List<Status> statusList = statusService.findByTipoStatus( tipoStatus );
		return statusList.stream().map( this::convertToDTO ).collect( Collectors.toList() );
	}
	
	@GetMapping( "/descricao" )
	public List<StatusDTO> getByDescricaoStatus( @RequestParam String descricao ) {
		List<Status> statusList = statusService.findByDescricaoStatus( descricao );
		return statusList.stream().map( this::convertToDTO ).collect( Collectors.toList() );
	}
	
	@PostMapping
	public ResponseEntity<StatusDTO> create( @RequestBody @Valid StatusDTO statusDTO ) {
		Status status = convertToEntity( statusDTO );
		Status saved = statusService.saveStatus( status );
		return ResponseEntity.ok( convertToDTO( saved ) );
	}
	
	@PutMapping( "/{id}" )
	public ResponseEntity<StatusDTO> update( @PathVariable Long id, @RequestBody StatusDTO statusDTO ) {
		Status statusAtualizado = convertToEntity( statusDTO );
		Status updated = statusService.updateStatus( id, statusAtualizado );
		return ResponseEntity.ok( convertToDTO( updated ) );
	}
	
	@DeleteMapping( "/{id}" )
	public ResponseEntity<Void> delete( @PathVariable Long id ) {
		statusService.deleteByIdStatus( id );
		return ResponseEntity.noContent().build();
	}
}
